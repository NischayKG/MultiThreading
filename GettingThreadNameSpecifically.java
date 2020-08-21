import java.util.*;
class MyThread extends Thread //Defining a Thread
{
    public void run()
    {
        System.out.println("The thread here is :"+Thread.currentThread().getName());  //for child thread
    }

    
}
class GettingThreadNameSpecifically
{
    public static void main(String arr[])
    {
        MyThread t=new MyThread(); 
        t.start();
        System.out.println("The thread here is :"+Thread.currentThread().getName());  //for main thread
    }
}