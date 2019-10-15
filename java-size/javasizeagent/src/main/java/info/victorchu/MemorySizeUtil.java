package info.victorchu;


import java.lang.instrument.Instrumentation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author victor
 * @Email victorchu0610@outlook.com
 * @Version 1.0
 * @Description TODO
 */
public class MemorySizeUtil {

    public static long memoryUsageOf(Object obj){
        return SizeAgent.getInstrumentation().getObjectSize(obj);
    }

    public static long deepMemoryUsageOfAll(Collection<? extends Object> objs){
        Instrumentation instr = SizeAgent.getInstrumentation();
        long total = 0L;
        Set<Integer> counted = new HashSet(objs.size() * 4);
        for (Object o : objs) {
            total += deepMemoryUsageOf0(o,counted);
        }
        return total;
    }
    public static long deepMemoryUsageOf(Object obj){
        return deepMemoryUsageOf0(obj,new HashSet());
    }
    private static long deepMemoryUsageOf0(Object objP,Set<Integer> visited){
        Deque<Object> toBeQueue = new ArrayDeque<>();
        toBeQueue.add(objP);
        long size = 0L;
        while (toBeQueue.size() > 0) {
            Object obj = toBeQueue.poll();
            size += skipObject(visited, obj) ? 0L : memoryUsageOf(obj);
            Class<?> tmpObjClass = obj.getClass();
            if (tmpObjClass.isArray()) {
                // [I , [F 基本类型名字长度是2
                if (tmpObjClass.getName().length() > 2) {
                    for (int i = 0, len = Array.getLength(obj); i < len; i++) {
                        Object tmp = Array.get(obj, i);
                        if (tmp != null) {
                            // 非基本类型需要深度遍历其对象
                            toBeQueue.add(Array.get(obj, i));
                        }
                    }
                }
            } else {
                while (tmpObjClass != null) {
                    Field[] fields = tmpObjClass.getDeclaredFields();
                    for (Field field : fields) {
                        if (Modifier.isStatic(field.getModifiers()) // 静态变量不计
                                || field.getType().isPrimitive() // 基本类型不重复计
                                || field.getName().startsWith("this") // 内部类实例对外部类实例的引用不再重复计算
                        ) {
                            continue;
                        }
                        field.setAccessible(true);
                        Object fieldValue = null;
                        try {
                            fieldValue = field.get(obj);
                            if (fieldValue == null) {
                                continue;
                            }
                            toBeQueue.add(fieldValue);
                        } catch (IllegalAccessException e) {
                            throw new InternalError("Couldn't read " + field);
                        }
                    }
                    tmpObjClass = tmpObjClass.getSuperclass();
                }
            }
        }
        return size;
    }

    static boolean skipObject(Set<Integer> visited, Object obj) {
        return !visited.add(obj.hashCode());
    }
}
