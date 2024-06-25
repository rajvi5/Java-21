/**
 * Unnamed patterns and variable which we are not going to use again in our code. "_"
 */
public class UnnamedVariable
{
    public static void main(String[] args)
    {
        try
        {
            double d = 100/0;
        }catch (Exception _)
        {
            System.out.println("Error");
        }
    }
}