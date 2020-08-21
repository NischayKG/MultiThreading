import java.util.*;
class MyThread extends Thread //Defining a Thread
{
    
}
class ThreadPriorities
{
    public static void main(String arr[])
    {
        System.out.println("The Main thread Priority is :"+Thread.currentThread().getPriority());  //for main thread
        Thread.currentThread().setPriority(7); //setting main thread priority to 7
        System.out.println("The Main thread Priority is :"+Thread.currentThread().getPriority());  //for main thread
        MyThread t=new MyThread(); 
        System.out.println("The child thread Priority is :"+t.getPriority());  //for child thread inherited from main
    //  Thread.currentThread().setPriority(17); //This will give Illegal Argument Exception   
    }
}