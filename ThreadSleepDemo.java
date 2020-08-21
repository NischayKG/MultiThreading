class ThreadSleepDemo
{
    public static void main(String arr[])throws InterruptedException
    {
      for(int i=0;i<10;i++)
      {
          System.out.println("Waiting for 3 sec, then execttion..");
          Thread.sleep(3000);
      }
        
    }
}