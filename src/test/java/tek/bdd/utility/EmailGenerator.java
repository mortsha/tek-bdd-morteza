package tek.bdd.utility;

public class EmailGenerator {

    public static String getEmail(String firstName) {
        int randomNumber = (int) (Math.random() * 10000);
        return firstName + +randomNumber + "@happy.org";
    }
}
