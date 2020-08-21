import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;
import java.util.*;
class MyThread extends Thread
{
    static ReentrantLock l=new ReentrantLock();
    MyThread(String name)
    {
        super(name);
    }
    public void run()
    {
        do{
            try{
            if(l.tryLock(3000,TimeUnit.MILLISECONDS))  //each time , thread waiting for 3 sec and goes to else part and
            {                                         //  comes back here again until got lock
                System.out.println(Thread.currentThread().getName()+"...got the Lock");
                try{
                    Thread.sleep(10000);               // one of the thread sleep for 10 sec...
                }
                catch(InterruptedException e){}
                System.out.println(Thread.currentThread().getName()+"...releases the Lock");
                l.unlock();                            //after waking up, thread releases thr lock and other thread aquairs lock
                break;
            }
            else
            {
                System.out.println(Thread.currentThread().getName()+"...Unable to get the Lock");
            }
        }
        catch(Exception e){}
        }while(true);
    }
}
class ReentrentLock_Demo4
{ 
    public static void main(String arg[])
    {

        MyThread t1=new MyThread("First Thread");
        MyThread t2=new MyThread("Second Thread");
        t1.start();
        t2.start();          
    }
}