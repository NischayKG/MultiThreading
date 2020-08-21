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
class Thread_sleep_wait_and_notify_Inter_Thread_Communication_Modified_Version
{
    public static void main(String arr[])throws InterruptedException
    {
        ThreadB b=new ThreadB();      //Thread Instanciated
        b.start();
        Thread.sleep(10000);       //Main thread went to sleep for 10 sec... then automatically child thread... 
                                   //..starts and then enter into dead state after completing it's job
                                   //after 10 seconds, the sopln of main threads starts...
                                   
        synchronized(b)            //Main thread Lock on b object
        {
            System.out.println("Main thread trying to call wait() method..."); //after waking up, it invokes wait..
                                                                               
            b.wait(10000);                    //Main thread releases the LOCK on b and enter in the waiting state for 10 sec...
            System.out.println("Main thread got notification...");   //Might not recieve Notification as there is no one to
                                                                     // notify him because all threads(child thread) is dead...
                                                                     //but since the waiting time is only 10 sec, it will continue...
                                                                     //it's execution even if it don't recieve any notification
            System.out.println(b.total);  //Executed by Main Thread... o/p 5050
        }
        
    }
}