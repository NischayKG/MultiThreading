class ParentThread extends Thread
{
    public static InheritableThreadLocal tl=new InheritableThreadLocal()
    {
        public Object childValue(Object p)
        {
            return "cc";
        }
    };

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
        System.out.println("Child Thread Value- "+ParentThread.tl.get()); //cc as  value is assigned by thread Local to child
       
    }

}

class ThreadLocal_Demo6
{
    public static void main(String args[])
    {
        ParentThread pt=new ParentThread();
        pt.start();
    }
}