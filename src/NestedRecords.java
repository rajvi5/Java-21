record PostCard(String sender, String receiver) implements Intention {};
record Coupon(String couponCode, double amount) implements Intention {};

record Gift(PostCard postCard, Intention intention) {}
public class NestedRecords {

    public static void test(Gift gift)
    {
        if(gift instanceof Gift(PostCard p, Coupon(String couponCode, double amount)))
        {
            System.out.println("Coupon code: " + couponCode);
        }

        if(gift instanceof Gift(PostCard(var sender, String receiver), var c))
        {
            System.out.println("Receiver: " + receiver);
            System.out.println("Receiver: " + sender);

        }
    }

    public static void main(String[] args) {
        test(new Gift(new PostCard("Rajvi", "Parthesh"), new Coupon("XYZ100", 1250.00 )));
    }}
