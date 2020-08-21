import java.util.*;
class MyThread extends Thread //Defining a Thread
{
    static Thread mt;

    public void run()         //Job of thread (Executed by Child Thread...)
    {   
        try
        {
            mt.join();
        }
        catch(InterruptedException e)
        {}
        for(int i=0;i<10;i++)
            System.out.println("child Thread");
    }
}
class ThreadDemoDeadlock
{
    public static void main(String arr[])throws InterruptedException
    {
        MyThread.mt=Thread.currentThread();  //Creating the instance of main thread to call main Thread and pause the child thread
        MyThread t=new MyThread();           //Thread Instanciated
       
        t.start();     
     // t.join();                            //is we remove the comment then DeadLock will occur...
        for(int i=0;i<10;i++)                //Executed by Main Thread...
        {    
            System.out.println("Main Thread");
            Thread.sleep(2000);
        }
    }
}