class Thread_Group_Demo
{
    public static void main(String[] args) 
    {
        System.out.println("Main Thread's group name is :"+Thread.currentThread().getThreadGroup().getName()); //main
        System.out.println("Main Thread's parent group name is :"+Thread.currentThread().getThreadGroup().getParent().getName()); //system

        
    }
}