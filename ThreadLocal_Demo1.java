import java.util.*;
class ThreadLocal_Demo1
{
    public static void main(String[] arr)
    {
        ThreadLocal tl=new ThreadLocal();
        System.out.println(tl.get());     
        tl.set("durga");
        System.out.println(tl.get());    
        tl.remove();
        System.out.println(tl.get());    
    }
    
}