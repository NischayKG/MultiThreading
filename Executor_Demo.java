import java.util.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class PrintJob implements Runnable
{
    String name;
    PrintJob(String name)
    {
        this.name=name;
    }
    public void run()
    {
        System.out.println(name+"...Job Started by the Thread "+Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){}
        System.out.println(name+"...Job completed by the Thread "+Thread.currentThread().getName());
    }
}
class Executor_Demo
{
    public static void main(String arr[])
    {
        PrintJob[] jobs={ new PrintJob("Durga"),
        new PrintJob("Ravi"),
        new PrintJob("Shiva"),
        new PrintJob("Pavan"),
        new PrintJob("Surresh"),
        new PrintJob("Anil")};
        ExecutorService service=Executors.newFixedThreadPool(3);
        for(PrintJob job:jobs)
        {
            service.submit(job);
        }
        service.shutdown();
    }
}
