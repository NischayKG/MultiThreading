import java.util.*;
class MyThread extends Thread //Defining a Thread
{
                             //nothing will be displayed as no overRiding of run() method!! Missusing of Multi Threading occurs here!!
}
class MissusingMultiThreading
{
    public static void main(String arr[])
    {
        MyThread t=new MyThread();   //Thread Instanciated
        t.start();
                                    //Executed by Main Thread...
        System.out.println("Main Thread");
    }
}