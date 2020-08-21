import java.util.*;
class ThreadLocal_Demo2
{
    public static void main(String[] arr)
    {
        ThreadLocal tl=new ThreadLocal()
        {
            public Object initialValue()
            {
                return "abc";
            }
        };

        System.out.println(tl.get());     //abc
        tl.set("durga");
        System.out.println(tl.get());    // durga
        tl.remove();
        System.out.println(tl.get());    // abc
    }
    
}