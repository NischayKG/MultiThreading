import java.util.*;
class MyThread extends Thread //Defining a Thread
{
    public void run()         //Job of thread (Executed by Child Thread...)
    {
        for(int i=0;i<10;i++)
        {    System.out.println("child Thread");
             try{
                 Thread.sleep(2000);
             }
             catch(InterruptedException e){}
        }
    }
}
class DaemonThread_Demo2
{
    public static void main(String arr[])
    {
        MyThread t=new MyThread();   //Thread Instanciated
        t.setDaemon(true);           // child thread set as Daemon so if mainthread or all other executing non-Daemon ...
                                     //... thread ends, then automatically all Daemon thread will end.

        t.start();
            
        System.out.println("Main Thread ends...");  //Executed by Main Thread...
    }
}