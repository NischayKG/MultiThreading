import java.util.concurrent.locks.*;
class MyThread extends Thread
{
    static ReentrantLock l=new ReentrantLock();
    MyThread(String name)
    {
        super(name);
    }
    public void run()
    {
        if(l.tryLock())
        {
            System.out.println(Thread.currentThread().getName()+"...got the Lock");
            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e){}
            l.unlock();
        }
        else
        {
            System.out.println(Thread.currentThread().getName()+"...Unable to get the Lock");
        }
    }
}
class ReentrentLock_Demo3
{ 
    public static void main(String arg[])
    {

        MyThread t1=new MyThread("First Thread");
        MyThread t2=new MyThread("Second Thread");
        t1.start();
        t2.start();          
    }
}