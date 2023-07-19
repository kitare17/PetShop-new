package service;

import repository.ProductRepository;
import repository.UserRepository;

import java.util.Random;

public class MyRandom {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int LENGTH = 4;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String getRandomCusID() {
        StringBuilder sb ;
        do {
            sb = new StringBuilder();
            sb.append("C");

            for (int i = 1; i <= LENGTH; i++) {
                sb.append(new Random().nextInt(10));
            }
        }
        while(UserRepository.checkExistID(sb.toString()));
        return sb.toString();
    }
    public static String getRandomEmpID() {
        StringBuilder sb ;
        do {
            sb = new StringBuilder();
            sb.append("E");

            for (int i = 1; i <= LENGTH; i++) {
                sb.append(new Random().nextInt(10));
            }
        }
        while(UserRepository.checkExistID(sb.toString()));
        return sb.toString();
    }

    public static String getRandomPetID(){
        StringBuilder sb ;
        do {
            sb = new StringBuilder();
            sb.append("P");

            for (int i = 1; i <= LENGTH; i++) {
                sb.append(new Random().nextInt(10));
            }
        }
        while(ProductRepository.checkExistPetID(String.valueOf(sb)));
        return sb.toString();
    }
    public static String getRandomFoodID(){
        StringBuilder sb ;
        do {
            sb = new StringBuilder();
            sb.append("F");

            for (int i = 1; i <= LENGTH; i++) {
                sb.append(new Random().nextInt(10));
            }
        }
        while(ProductRepository.checkExistFoodID(String.valueOf(sb)));
        return sb.toString();
    }
    public static String getRandomOTP(){
        StringBuilder sb ;

            sb = new StringBuilder();
            sb.append("F");

            for (int i = 1; i <= LENGTH; i++) {
                sb.append(ALPHABET.charAt(new Random().nextInt(26)));
            }

        return sb.toString();
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++)
            System.out.println(getRandomOTP());
    }
    public static String getRandomServiceBillID() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(20);

        for (int i = 0; i < 20; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
