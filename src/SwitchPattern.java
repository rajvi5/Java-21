public class SwitchPattern
{
    public static void type(Object o)
    {
        switch(o)
        {
            case User(int x, String _) -> System.out.println("This is instance of User");
            case String _ -> System.out.println("This is instance of String");
            case null -> System.out.println("This is null");
            default -> System.out.println("Object type unknown");
        }
    }

    public static void main(String args[])
    {
        type(new User(1, "Name"));
        type(null);
        type(1);
        type("");
    }
}