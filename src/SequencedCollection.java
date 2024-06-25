import java.util.ArrayList;
import java.util.List;

/**
 * New interface named SequencedCollection was created that contains methods like addFirst(), removeLast(), getLast().
 * New method reversed() is introduced.
 */
public class SequencedCollection
{
    public static void main(String[] args)
    {
        List<String> stringList = new ArrayList<>();
        stringList.add("Middle");
        stringList.addFirst("First");
        stringList.addLast("Last");
        System.out.println(stringList);
        System.out.println(stringList.reversed());
        System.out.println(stringList.getFirst());

    }
}
