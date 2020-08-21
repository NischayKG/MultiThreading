import java.util.*;
class MyThread extends Thread //Defining a Thread
{
    public void run()         //Job of thread (Executed by Child Thread...)
    {
        for(int i=0;i<10;i++)
        {   System.out.println("Seeta Thread");
            try 
            {
                Thread.sleep(2000);
            }
            catch(InterruptedException e)
            {}
        }
    }
}
class ThreadJoinDemo
{
    public static void main(String arr[]) throws InterruptedException
    {
        MyThread t=new MyThread();   //Thread Instanciated
        t.start();                   /*Form here, in run method, sleep method will be called...and if loop is of 10 and 2000ms...
                                    ...then for minimum of 20sec. seeta will sleep and after that only Rama will be executed */
   //     t.join();                            //as main thread wil be calling child thread here using join hence after seeta only ram will execute
      t.join(10000); // by passing 10K millisec or 10 sec, no need fo Ram to wait for 20 sec, After 10 sec, execution will continue...
        for(int i=0;i<10;i++)        //Executed by main Thread...
            System.out.println("Rama Thread");
    }
}