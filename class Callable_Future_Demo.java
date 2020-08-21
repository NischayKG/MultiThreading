import java.util.concurrent.*;
import java.util.*;
class MyCallable implements Callable
{
    int num;
    MyCallable(int num)
    {
        this.num=num;
    }
    public Object call()throws Exception
    {
        System.out.println(Thread.currentThread().getName()+" ...is responsible for finding sum of first "+num+"numbers");
        int sum=0;
        for(int i=1;i<=num;i++)
        {
            sum+=i;
        }
        return sum;
    }
}

class Callable_Future_Demo
{
    public static void main(String[] args)throws Exception
    {
        MyCallable[] jobs={new MyCallable(10),
            new MyCallable(20),
            new MyCallable(30),
            new MyCallable(40),
            new MyCallable(50),
            new MyCallable(60)};
            ExecutorService service=Executors.newFixedThreadPool(3);
            for(MyCallable job:jobs)
            {
                Future f=service.submit(job);
                System.out.println(f.get());
            }
            service.shutdown();
    }
}