package info.victorchu;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author victor
 * @Email victorchu0610@outlook.com
 * @Version 1.0
 * @Description TODO
 */
public class SizeUnsafeFetcher {
    private static Unsafe UNSAFE;
    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new InternalError("Couldn't get Unsafe instance！");
        }
    }

    public static void analyze(Object object) throws NoSuchFieldException {
        Class<?> tmpObjClass = object.getClass();
        Field[] fields = tmpObjClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field:"+field.getName()+",offset:"+UNSAFE.objectFieldOffset(tmpObjClass.getDeclaredField(field.getName())));
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {
        analyze(new A());
    }
}
