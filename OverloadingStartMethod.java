import java.util.*;
class MyThread extends Thread //Defining a Thread
{

    public void start()        
    {
        super.start();    // used to invoke run() method via base start() method 
        System.out.println("Start Method");
    }
    /* Below run method will not be executed 
    as start method of base Thread class is not invoked 
    and extra thread for Run() is not created */
    public void run()         // (would have been executed  by Child Thread...)
    {
        System.out.println("Run Method");
    }
    
}
class OverloadingStartMethod
{
    public static void main(String arr[])
    {
        MyThread t=new MyThread();   //Thread Instanciated
        t.start();
                                    //Executed by Main Thread...
        System.out.println("Main Thread");
    }
}