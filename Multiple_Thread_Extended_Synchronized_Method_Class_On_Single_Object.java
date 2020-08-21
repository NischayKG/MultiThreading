class disp
{
    public synchronized void dispN() //Object level lock implemented here 
    {                                                 
        for(int i=1;i<=5;i++)                          
        {                                         
            System.out.print(i);
            try                                      
            {                                      
                Thread.sleep(2000);
            }
            catch(InterruptedException e){}
          
        }
    }

    public synchronized void dispC()  //Object level lock implemented here
    {                                                 
        for(int i=65;i<70;i++)                          
        {                                         
            System.out.print((char)i);
            try                                      
            {                                      
                Thread.sleep(2000);
            }
            catch(InterruptedException e){}
        }
    }
}

class MyThread1 extends Thread
{
    disp d;
    MyThread1(disp d)   //constructor to allocate the name corresponding to the object
    {
        this.d=d;
    }
    public void run()
    {
        d.dispC();
    }
}

class MyThread2 extends Thread
{
    disp d;
    String name;
    MyThread2(disp d)   //constructor to allocate the name corresponding to the object
    {
        this.d=d;
    }
    public void run()
    {
        d.dispN();
    }
}
   

   
class Multiple_Thread_Extended_Synchronized_Method_Class_On_Single_Object
{
    public static void main(String arg[])
    {
        disp d1=new disp();
        MyThread1 t1=new MyThread1(d1);
        MyThread2 t2=new MyThread2(d1);
        t1.start();
        t2.start();          
    }
}