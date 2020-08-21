class ThreadDemoDeadlock2
{
    public static void main(String arr[])throws InterruptedException
    {
      Thread.currentThread().join();  //Creating the instance of main thread to call main Thread and pause itself
      //i.e main thread will call the main thread and wait untill the compilition of main thread (Simply a Dead-Lock)
        
    }
}