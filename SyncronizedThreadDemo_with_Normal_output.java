/* Multiple thread operation with multiple objects which will by default occur as 
   there is  STATIC synchronized method which will be available for all threads which
    will lock their respective objects and hence, because of static , one thread even 
    after having theri respective object will get the chance*/
   class disp
   {
       public static synchronized void wish(String name) //This is class leven lock
       {                                                 
           for(int i=0;i<3;i++)                          //passing name of person whome we want to wish with only one thread
            {                                           // i.e synchronized function now, which allow only one thread to execute at a time
               System.out.print("Good Morining : ");    // due to static method, even after having multiple objects, 
               try                                      
               {                                        //and we will get normal output
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
   
   
   class SyncronizedThreadDemo_with_Normal_output
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