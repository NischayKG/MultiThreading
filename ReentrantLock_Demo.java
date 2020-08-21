import java.util.concurrent.locks.*;

class ReentrantLock_Demo
{
    public static void main(String arr[])
    {
        ReentrantLock l=new ReentrantLock();
        l.lock();
        l.lock();
        System.out.println("Lock or not? :"+l.isLocked());
        System.out.println("Current thread Hold lock or not? :"+l.isHeldByCurrentThread());
        System.out.println("No. of waiting threads to get lock? :"+l.getQueueLength());
        System.out.println("No. of Locks, thread is holding now? :"+l.getHoldCount());
        l.unlock();
        System.out.println("No. of Locks, thread is holding now? :"+l.getHoldCount());
        System.out.println("Lock or not? :"+l.isLocked());
        l.unlock();
        System.out.println("Lock or not? :"+l.isLocked());
        System.out.println("Lock is fair or not? :"+l.isFair());
        
    }
}