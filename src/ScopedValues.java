/**
 * Preferred over ThreadLocal variables, especially when using virtual threads.
 * Sharing of immutable data across threads. ThreadLocal variables that we currently use are mutable. And it's hard
 * to debug which process manipulated the variable with which value;
 * Bounded lifetime helps to avoid memory leaks. Lifetime of ThreadLocal variable is till the application stops when remove()
 * is not used.
 * ThreadLocal variables of current thread are mutable hence, mostly copied/duplicated when new Thread() is initialized
 * causing a lot of unwanted memory footprint.
 */
public class ScopedValues
{
    //Define a scoped value
    private static final ScopedValue<String> scopedValue = ScopedValue.newInstance();

    public static void main(String[] args)
    {
        final ScopedValue<String> scopedValue1 = ScopedValue.newInstance();

        Runnable task = () -> System.out.println("ScopedValue: " + (scopedValue.isBound() ? scopedValue.get() : "Unbound"));
        Runnable task1 = () -> System.out.println((scopedValue.isBound() ? scopedValue.get() : "Unbound") + " " +
                (scopedValue1.isBound() ? scopedValue1.get() : "Unbound"));

        task.run();

        ScopedValue.where(scopedValue, "Hello").run(task);
        ScopedValue.where(scopedValue, "Welcome").run(task);
        ScopedValue.where(scopedValue, "You are the best").where(scopedValue1, "Rajvi").run(task1);


        task1.run();

    }
}
