/* Single thread operation which will by default occur in a sync. way as 
   there is no other thread to access the same object*/
class disp
{
    public void wish(String name)  //passing name of person whome we want to wish
    {
        for(int i=0;i<10;i++)
        {
            System.out.print("Good Morining : ");
            try 
            {
                Thread.sleep(2000);
            }
            catch(InterruptedException e){}
            System.out.println(name);
        }
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


class SyncronizedThreadDemo   
{
    public static void main(String arg[])
    {
        disp d=new disp();
        MyThread t1=new MyThread(d,"Dhoni");
        t1.start();        
    }
}