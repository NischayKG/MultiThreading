class ParentThread extends Thread
{
    public static ThreadLocal tl=new ThreadLocal();
    public void run()
    {
        tl.set("pp");
        System.out.println("Parent Thread Value- "+tl.get()); //pp
        ChildThread ct=new ChildThread();
        ct.start();
    } 
}
class ChildThread extends Thread
{
    public void run()
    {
        System.out.println("Child Thread Value- "+ParentThread.tl.get()); //null as no value is assigned and "pp" is thread local value to parent thread
    }

}
class ThreadLocal_Demo4
{
    public static void main(String args[])
    {
        ParentThread pt=new ParentThread();
        pt.start();
    }
}