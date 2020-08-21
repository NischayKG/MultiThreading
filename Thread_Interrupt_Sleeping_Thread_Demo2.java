import java.util.*;
class MyThread extends Thread //Defining a Thread
{
    public void run()         //Job of thread (Executed by Child Thread...)
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("I am Lazy Thread");
                
        }
        
        System.out.println("I want to Sleep...");
        
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            System.out.println("I got Interrupted");
        }

    }
}
class Thread_Interrupt_Sleeping_Thread_Demo2
{
    public static void main(String arr[])
    {
        MyThread t=new MyThread();   //Thread Instanciated
        t.start();
        t.interrupt();               // main thread interrupts child thread whenever it tries to sleep
        System.out.println("Main Thread");
    }
}