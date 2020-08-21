import java.util.*;
class MyThread extends Thread //Defining a Thread
{
    public void run()         //Job of thread (Executed by Child Thread...)
    {
        System.out.println("No Arg Run Method");
    }
    public void run(int i)         
    {
        System.out.println("Arg Int in Run Method");
    }
}
class OverloadingRunMethod
{
    public static void main(String arr[])
    {
        MyThread t=new MyThread();   //Thread Instanciated
        t.start();
                                    //Executed by Main Thread...
        System.out.println("Main Thread");
    }
}