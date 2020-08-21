import java.util.*;
class MyThread extends Thread //Defining a Thread
{
    public void run()         //Job of thread (Executed by Child Thread...)
    {
        for(int i=0;i<10;i++)
            System.out.println("child Thread");
    }
}
class ThreadPriority2
{
    public static void main(String arr[])
    {
        MyThread t=new MyThread();   //Thread Instanciated
        t.setPriority(10);
        t.start();
        for(int i=0;i<10;i++)        //Executed by Main Thread...
            System.out.println("Main Thread");
    }
}