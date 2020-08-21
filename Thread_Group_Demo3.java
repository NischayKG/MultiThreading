class MyThread extends Thread
{
    MyThread(ThreadGroup g,String name)
    {
        super(g,name);
    }
    public void run()
    {
        System.out.println("Child Thread");
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e){}
    }
}

class Thread_Group_Demo3
{
    public static void main(String[] args)throws InterruptedException
    {
        ThreadGroup pg=new ThreadGroup("Parent Group");
        ThreadGroup cg=new ThreadGroup(pg,"Child Group");
        MyThread t1=new MyThread(pg,"Child Thread1");
        MyThread t2=new MyThread(pg,"Child Thread2");
        t1.start();  //starts and sleepos for 3 sec. meanwhile t2 starts
        t2.start();
        System.out.println("Active Thread Count in parent group is"+ pg.activeCount());  //o/p 2
        System.out.println("Active Group Count in parent group is"+pg.activeGroupCount()); //o/p 1
        pg.list();        //It will print all the details of the group pg
                        /*           OUTPUT-:
            java.lang.ThreadGroup[name=Parent Group,maxpri=10]
            Thread[Child Thread1,5,Parent Group]
            Thread[Child Thread2,5,Parent Group]
            java.lang.ThreadGroup[name=Child Group,maxpri=10]
                        */
        Thread.sleep(5000);
        System.out.println("Active Thread Count in parent group after 5 sec. is"+ pg.activeCount()); //o/p 0
        System.out.println("Active Group Count in parent group after 5 sec. is"+pg.activeGroupCount()); //o/p 1


    }
}