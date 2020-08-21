/* Multiple thread operation with multiple objects which will by default occur as 
   there is  synchronized method which will be available for all threads which will lock the objects 
   and hence, parallely multiple thread will access their  object and we will get MIXED output*/
   class disp
   {
       public synchronized void wish(String name)  //passing name of person whome we want to wish with only one thread
       {                                           // i.e synchronized function now, which allow only one thread to execute at a time
           for(int i=0;i<3;i++)                    // but due to multiple objects, all thread will access it parallely
            {                                      //and we will get mixed output
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
   
   
   class SyncronizedThreadDemo_with_Mixed_output
   {
       public static void main(String arg[])
       {
           disp d1=new disp();
           disp d2=new disp();
           MyThread t1=new MyThread(d1,"Dhoni");
           MyThread t2=new MyThread(d2,"Yuvraj");
           t1.start();
           t2.start();          
       }
   }