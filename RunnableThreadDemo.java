import java.util.*;
class MyRunnable implements Runnable                              //Defining a Thread
{
    public void run()                                          //Job of thread (Executed by Child Thread...)
    {
        for(int i=0;i<10;i++)
            System.out.println("child Thread");
    }
}
class RunnableThreadDemo
{
    public static void main(String arr[])
    {
        MyRunnable r=new MyRunnable();
        Thread t=new Thread(r);   //Thread class instanciation passing target runnable
        t.start();
        for(int i=0;i<10;i++)        //Executed by Main Thread...
            System.out.println("Main Thread");
    }
}