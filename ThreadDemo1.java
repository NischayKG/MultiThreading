import java.util.*;
class MyThread extends Thread //Defining a Thread
{
    public void run()         //Job of thread (Executed by Child Thread...)
    {
        for(int i=0;i<10;i++)
            System.out.println("Executing the Child Thread");
    }
}
class ThreadDemo1
{
    public static void main(String args[])
    {
        MyThread thread=new MyThread();   //Thread Instanciated
        thread.start();
        for(int i=0;i<10;i++)        //Executed by Main Thread...
            System.out.println("Executing Main Thread");
    }
}
