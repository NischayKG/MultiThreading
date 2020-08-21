class Thread_Group_Parent_Demo
{
    public static void main(String[] args) 
    {
        System.out.println("Main Thread's group name is :"+Thread.currentThread().getThreadGroup().getName()); //main
        System.out.println("Main Thread's parent group name is :"+Thread.currentThread().getThreadGroup().getParent().getName()); //system

        ThreadGroup g1=new ThreadGroup("First Group");
        System.out.println("Child Thread group's name is :"+g1.getName()); //First Group
        System.out.println("Child Thread's parent group name is :"+g1.getParent().getName()); //main

        ThreadGroup g2=new ThreadGroup(g1,"Second Group");               //(parent_group,"Name of this child");
        System.out.println("Child Thread group's name is :"+g2.getName()); //Second Group
        System.out.println("Child Thread's parent group name is :"+g2.getParent().getName()); //First Group

        /* 
            inn the above code-:
            
            system->main->First group->second group
            
        */        
    }
}