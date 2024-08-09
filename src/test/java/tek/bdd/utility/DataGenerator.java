package tek.bdd.utility;

import java.util.Random;

public class DataGenerator {
    public static void main(String[] args) {
        System.out.println(getRandomPhoneNumber());
    }


    public static String getRandomPhoneNumber(){
        StringBuilder randomPhone = new StringBuilder();
        for(int i = 0; i<10; i++){
            int random = (int) (Math.random() *10);
            randomPhone.append(String.valueOf(random));
        }
        return randomPhone.toString();
    }
}
