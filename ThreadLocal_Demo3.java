import java.util.*;
class CustomerThread extends Thread
{
    static Integer custID=0;
    private static ThreadLocal tl=new ThreadLocal()
    {
        protected Integer initialValue()
        {
            return ++custID;
        }
    };
    CustomerThread(String name)
    {
        super(name);
    }
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+" executes with id : "+tl.get());
    }
}

class ThreadLocal_Demo3
{
    public static void main(String arr[])
    {
        CustomerThread c1=new CustomerThread("Customer Thread 1");
        CustomerThread c2=new CustomerThread("Customer Thread 2");
        CustomerThread c3=new CustomerThread("Customer Thread 3");
        CustomerThread c4=new CustomerThread("Customer Thread 4");
        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}
