import java.util.concurrent.locks.ReentrantLock;

class disp
{
    ReentrantLock l=new ReentrantLock();
    public  void wish(String name) //This is class leven lock
    {        
        l.lock();             //lock, done by thread which reaches 1st                             
        for(int i=0;i<3;i++)                          //passing name of person whome we want to wish with only one thread
         {                                           // i.e Reentrant Lock now, which allow only one thread to execute at a time
            System.out.print("Good Morining : ");     
            try                                      
            {                                        //and we will get normal output
                Thread.sleep(2000);
            }
            catch(InterruptedException e){}
            System.out.println(name);
        }
        l.unlock();          // unlock done by the thread which locked...
    }
}
class MyThread extends Thread
{
    disp d;
    String name;
    MyThread(disp d,String name)   //constructor to allocate the name corresponding to the object
    {
        this.d=d;
        this.name=name;
    }
    public void run()
    {
        d.wish(name);
    }
}


class ReentrentLock_Demo2
{
    public static void main(String arg[])
    {
        disp d1=new disp();
        MyThread t1=new MyThread(d1,"Dhoni");
        MyThread t2=new MyThread(d1,"Yuvraj");
        t1.start();
        t2.start();          
    }
}