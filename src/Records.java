record User(int userId, String name){}

/**
 * Records reduce boiler plate code.
 * More safer serialization
 * Prior Java 16: if(obj instanceOf User){
 *     User u = (User) obj;
 *     ...use u...
 * }
 * As of Java 16: if(obj instanceOf User u){
 *     ...use u...
 * }
 */

class Test
{
    record  Admin(int id, String role){}

    public void testing(Object ob)
    {
        if (ob instanceof User(int userId, String name)) {
            System.out.println("User id: " + userId);
            System.out.println("Name: " + name);
        }
        if(ob instanceof Admin(int id, String role))
        {
            System.out.println("Admin user with role: " + role);
        }
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.testing(new User(1, "Rajvi"));
        test.testing(new Admin(105, "Admin"));
    }
}