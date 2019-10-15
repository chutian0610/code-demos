package test;

import info.victorchu.MemorySizeUtil;

/**
 * @Author victor
 * @Email victorchu0610@outlook.com
 * @Version 1.0
 * @Description TODO
 */
public class Main
{
    public static void main(String[] args)
    {
        //1.测试非基本类型对象大小
        System.out.println(String.format("sizeof(new A):%s", MemorySizeUtil.memoryUsageOf(new A())));
        System.out.println(String.format("fullsizeof(new A):%s", MemorySizeUtil.deepMemoryUsageOf(new A())));
        System.out.println(String.format("sizeof(new B):%s",  MemorySizeUtil.memoryUsageOf(new B())));
        System.out.println(String.format("fullsizeof(new B):%s", MemorySizeUtil.deepMemoryUsageOf(new B())));

        //2.测试基本类型数组对象的大小
        System.out.println(String.format("sizeof(new int[1]):%s", MemorySizeUtil.memoryUsageOf(new int[1])));
        System.out.println(String.format("fullsizeof(new int[1]):%s", MemorySizeUtil.deepMemoryUsageOf(new int[1])));
        System.out.println(String.format("sizeof(new int[2]):%s", MemorySizeUtil.memoryUsageOf(new int[2])));
        System.out.println(String.format("fullsizeof(new int[2]):%s", MemorySizeUtil.deepMemoryUsageOf(new int[2])));
        System.out.println(String.format("sizeof(new int[3]):%s", MemorySizeUtil.memoryUsageOf(new int[3])));
        System.out.println(String.format("fullsizeof(new int[3]):%s", MemorySizeUtil.deepMemoryUsageOf(new int[3])));


        //3.测试非基本类型数组对象的大小
        System.out.println(String.format("sizeof(new Integer[1]):%s", MemorySizeUtil.memoryUsageOf(new Integer[1])));
        System.out.println(String.format("fullsizeof(new Integer[1]):%s", MemorySizeUtil.deepMemoryUsageOf(new Integer[1])));
        System.out.println(String.format("sizeof(new Integer[2]):%s", MemorySizeUtil.memoryUsageOf(new Integer[2])));
        System.out.println(String.format("fullsizeof(new Integer[2]):%s", MemorySizeUtil.deepMemoryUsageOf(new Integer[2])));
        System.out.println(String.format("sizeof(new Integer[3]):%s", MemorySizeUtil.memoryUsageOf(new Integer[3])));
        System.out.println(String.format("fullsizeof(new Integer[3]):%s", MemorySizeUtil.deepMemoryUsageOf(new Integer[3])));

        //4.测试非基本类型数组对象的大小
        System.out.println(String.format("sizeof(new A[1]):%s", MemorySizeUtil.memoryUsageOf(new A[1])));
        System.out.println(String.format("fullsizeof(new A[1]):%s", MemorySizeUtil.deepMemoryUsageOf(new A[1])));
        System.out.println(String.format("sizeof(new A[2]):%s", MemorySizeUtil.memoryUsageOf(new A[2])));
        System.out.println(String.format("fullsizeof(new A[2]):%s", MemorySizeUtil.deepMemoryUsageOf(new A[2])));
        System.out.println(String.format("sizeof(new A[3]):%s", MemorySizeUtil.memoryUsageOf(new A[3])));
        System.out.println(String.format("fullsizeof(new A[3]):%s", MemorySizeUtil.deepMemoryUsageOf(new A[3])));

        //5.测试存在继承关系的非基本类型数组对象的大小
        System.out.println(String.format("sizeof(new B[1]):%s", MemorySizeUtil.memoryUsageOf(new B[1])));
        System.out.println(String.format("fullsizeof(new B[1]):%s", MemorySizeUtil.deepMemoryUsageOf(new B[1])));
        System.out.println(String.format("sizeof(new B[2]):%s", MemorySizeUtil.memoryUsageOf(new B[2])));
        System.out.println(String.format("fullsizeof(new B[2]):%s", MemorySizeUtil.deepMemoryUsageOf(new B[2])));
        System.out.println(String.format("sizeof(new B[3]):%s", MemorySizeUtil.memoryUsageOf(new B[3])));
        System.out.println(String.format("fullsizeof(new B[3]):%s", MemorySizeUtil.deepMemoryUsageOf(new B[3])));

        // 6. 内部类
        System.out.println(String.format("sizeof(new A.C()):%s", MemorySizeUtil.deepMemoryUsageOf(new A().new C())));
    }
}