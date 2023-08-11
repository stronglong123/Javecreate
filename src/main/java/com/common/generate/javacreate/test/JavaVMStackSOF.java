package com.common.generate.javacreate.test;

/**
 * @author xialei
 * @date 2023/6/1 17:30
 */
public class JavaVMStackSOF {

    private int stackLength=1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    // -Xss128k
    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length="+oom.stackLength);
            throw e;
        }
    }

}
