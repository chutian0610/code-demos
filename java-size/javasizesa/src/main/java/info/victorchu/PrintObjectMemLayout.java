package info.victorchu;

import sun.jvm.hotspot.oops.HeapPrinter;
import sun.jvm.hotspot.oops.HeapVisitor;
import sun.jvm.hotspot.oops.ObjectHeap;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.tools.Tool;

public class PrintObjectMemLayout extends Tool {

    @Override
    public void run() {
        VM vm = VM.getVM();
        ObjectHeap objHeap = vm.getObjectHeap();
        HeapVisitor heapVisitor = new HeapPrinter(System.out);
        objHeap.iterate(heapVisitor);
    }

    public static void main(String[] args) throws InterruptedException {
        PrintObjectMemLayout layout = new PrintObjectMemLayout();
        layout.execute(args);
        layout.stop();
    }
}
