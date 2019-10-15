package info.victorchu;

import java.lang.instrument.Instrumentation;

/**
 * @Author victor
 * @Email victorchu0610@outlook.com
 * @Version 1.0
 * @Description TODO
 */
public class SizeAgent {
    private static volatile Instrumentation instrumentation;

    public static void premain(String args, Instrumentation instr){
        instrumentation = instr;
    }

    public static Instrumentation getInstrumentation(){
        Instrumentation instr = instrumentation;
        if (instr == null) {
            throw new IllegalStateException("SizeAgent not initted");
        }
        return instr;
    }
}
