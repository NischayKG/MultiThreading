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
            this.notify();                      // after notifying, it went to dead state as it's job is done
                                          

        }
        
    }
    
}
class Thread_sleep_wait_and_notify_Inter_Thread_Communication
{
    public static void main(String arr[])throws InterruptedException
    {
        ThreadB b=new ThreadB();      //Thread Instanciated
        b.start();
        Thread.sleep(10000);       //Main thread went to sleep for 10 sec... then automatically child thread... 
                                   //..starts and then enter into dead state after completing it's job
                                   //after 10 seconds, the sopln of main threads starts...
                                   //but Worst WRONG DECISION to sleep as no one will be there to notify back and
                                   //main could be in waiting state forever...
                                   
        synchronized(b)            //Main thread Lock on b object
        {
            System.out.println("Main thread trying to call wait() method..."); //after waking up, it invokes wait..
                                                                               //but noone is there to notify back...
            b.wait();                    //Main thread releases the LOCK on b and enter in the waiting stats
            System.out.println("Main thread got notification...");   //Might not recieve Notification as there is no one to
                                                                     // notify him because all threads(child thread) is dead...
                                                                     //even after 10 years also, execution will be stuck here...
            System.out.println(b.total);  //should be Executed by Main Thread... o/p 5050
        }
        
    }
}