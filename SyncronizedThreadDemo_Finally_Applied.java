/* Multiple thread operation which will by default occur in a sync. way as 
   there is  synchronized method which will be applied on threads as only 
   one thread will access the  object and we will get sequenced output of 
   any thread at fifst and after completion of that thread, other thread will display it's output*/
   class disp
   {
       public synchronized void wish(String name)  //passing name of person whome we want to wish with only one thread
       {                                           // i.e synchronized function now, which allow only one thread to execute at a time
           for(int i=0;i<3;i++)
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
   
   
   class SyncronizedThreadDemo_Finally_Applied
   {
       public static void main(String arg[])
       {
           disp d=new disp();
           MyThread t1=new MyThread(d,"Dhoni");
           t1.start();
           MyThread t2=new MyThread(d,"Yuvraj");
           t2.start(); 
           MyThread t3=new MyThread(d,"Sachin");
           t3.start();          
       }
   }