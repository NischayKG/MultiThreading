import java.util.*;
class MyThread extends Thread //Defining a Thread
{
    public void run()         //Job of thread (Executed by Child Thread...)
    {
        for(int i=0;i<10;i++)
        {  
            System.out.println("child Thread");
            Thread.yield();                    // pause the Execution of Child Thread and give a chance to Main Thread Hence...
        }                                     //... Main Thread will complete first
                                              // Hence the Thread.yield method is used to pause the long running method...
                                              //...and give a chance to the Thread of same priority to use the processor
        
    }
}
class ThreadYieldMethod
{
    public static void main(String arr[])
    {
        MyThread t=new MyThread();   //Thread Instanciated
        t.start();
        for(int i=0;i<10;i++)        //Executed by Main Thread...
            System.out.println("Main Thread");
    }
}