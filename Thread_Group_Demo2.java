class Thread_Group_Demo2
{
    public static void main(String[] args) 
    {
        ThreadGroup g1=new ThreadGroup("tg");
        Thread t1=new Thread(g1,"Thread-1");
        Thread t2=new Thread(g1,"Thread-2");
        g1.setMaxPriority(3);
        Thread t3=new Thread(g1,"Thread-3");
        System.out.println("Thr priority of thread t1 is :"+t1.getPriority());
        System.out.println("Thr priority of thread t2 is :"+t2.getPriority());
        System.out.println("Thr priority of thread t3 is :"+t3.getPriority());

    }
}