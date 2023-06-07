package service;

import repository.ProductRepository;
import repository.UserRepository;

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
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++)
            System.out.println(getRandomFoodID());
    }
}
