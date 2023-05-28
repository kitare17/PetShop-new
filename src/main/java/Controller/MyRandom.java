package Controller;

import Model.UserDAO;

import java.util.Random;

public class MyRandom {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int LENGTH = 4;

    public static String getRandomCusID() {
        StringBuilder sb ;
        do {
            sb = new StringBuilder();
            sb.append("C");

            for (int i = 1; i <= LENGTH; i++) {
                sb.append(new Random().nextInt(10));
            }
        }
        while(UserDAO.checkExistID(sb.toString()));
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++)
        System.out.println(getRandomCusID());
    }
}
