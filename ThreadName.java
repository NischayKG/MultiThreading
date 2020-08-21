import java.util.*;
class MyThread extends Thread //Defining a Thread
{
    
}
class ThreadName
{
    public static void main(String arr[])
    {
        System.out.println(Thread.currentThread().getName()); //for main thread
        MyThread t=new MyThread();   //Thread Instanciated
        System.out.println(t.getName());
        MyThread t1=new MyThread();   //Thread Instanciated
        System.out.println(t1.getName());
        Thread.currentThread().setName("good");                // setting main thread name
        t1.setName("boy");                                   //setting child thread name  
        System.out.println(Thread.currentThread().getName());  //for main thread
        System.out.println(t1.getName());
     //   System.out.println(10/0);                // RunTime Exception: in thread "good"

       
    }
}