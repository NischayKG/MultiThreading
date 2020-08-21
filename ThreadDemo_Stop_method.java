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
class ThreadDemo_Stop_method
{
    public static void main(String arr[])
    {
        MyThread t=new MyThread();   //Thread Instanciated

        t.start();
        t.stop();                     // not recomended to be used as it kills the thread instantly i.e depricated
        System.out.println("Main Thread ends...");  //Executed by Main Thread...
    }
}