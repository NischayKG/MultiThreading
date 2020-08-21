import java.util.*;
class ThreadB extends Thread //Defining a Thread
{
    int total=0;
    public void run()         //Job of thread (Executed by Child Thread...)
    {
        synchronized(this)    //child thread Locks on b Object
        {
            System.out.println("Child thread starts calculation...");
            for(int i=1;i<=100;i++)
                total+=i;
            
            System.out.println("Child thread trying to give notification...");
            this.notify();

        }
        
    }
    
}
class Thread_wait_and_notify_Demo
{
    public static void main(String arr[])throws InterruptedException
    {
        ThreadB b=new ThreadB();      //Thread Instanciated
        b.start();
        synchronized(b)            //Main thread Lock on b object
        {
            System.out.println("Main thread trying to call wait() method...");
            b.wait();                    //Main thread releases the LOCK on b and enter in the waiting state 
            System.out.println("Main thread got notification...");
            System.out.println(b.total);  //Executed by Main Thread... o/p 5050
        }
        
    }
}