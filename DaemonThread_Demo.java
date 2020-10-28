import java.util.*;
class MyThread extends Thread
{}

class DaemonThread_Demo
{
    public static void main(String[] arr)
    {
        System.out.println(Thread.currentThread().isDaemon()); //False as by deaault it is non-daemon
    //  Thread.currentthread.setDaemon(true);                  // R:E as it is already started so we can't change it's state
        MyThread t=new MyThread();
        System.out.println(t.isDaemon());                      //false as it has inherited from main thread as non-Daemon
        t.setDaemon(true);
        System.out.println(t.isDaemon());                      //true as it had been made Daemon



    }
}
