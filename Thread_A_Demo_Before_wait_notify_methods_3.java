import java.util.*;
class ThreadB extends Thread //Defining a Thread
{
    int total=0;
    public void run()         //Job of thread (Executed by Child Thread...)
    {
        for(int i=1;i<=100;i++)
            total+=i;
    }
}
class Thread_A_Demo_Before_wait_notify_methods_3
{
    public static void main(String arr[])throws InterruptedException
    {
        ThreadB b=new ThreadB();      //Thread Instanciated
        b.start();
        b.join();                    //we are pausing main thread untill child will complete it's task
        System.out.println(b.total);  //Executed by Main Thread... o/p 5050
    }
}