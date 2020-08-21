class A
{
    public synchronized void d1(B b)  //if we remove sync... then deadlock will not occur
    {
        System.out.println("Thread1 starts Execution of d1() method");
       try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){}
        System.out.println("Thread1 trying to call B's last() method");
        b.last();
    }
    public synchronized void last() //if we remove sync... then deadlock will not occur
    {
        System.out.println("Inside A's Last Method");
    }
}
class B
{
    public synchronized void d2(A a)  //if we remove sync... then deadlock will not occur
    {
        System.out.println("Thread2 starts Execution of d2() method");
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){}
        System.out.println("Thread2 trying to call A's last() method");
        a.last();
    }
    public synchronized void last()    //if we remove sync... then deadlock will not occur
    {
        System.out.println("Inside B's Last Method");
    }
}


class Deadlock_In_Thread_Demo extends Thread
{
    A a=new A();
    B b=new B();
    public void m1() //invoked by main Thread
    {
        this.start(); //here one more thread( i.e Child Thread) is generated which will call run() method
        
        a.d1(b);     //executed by main thread
    }
    public void run()
    {
        b.d2(a);    //excuted by child thread
    }
    public static void main(String arr[])
    {
        Deadlock_In_Thread_Demo t=new Deadlock_In_Thread_Demo();
        t.m1();
    }
}