package service;

import entity.Food;
import entity.Pet;
import repository.ProductRepository;

import java.util.ArrayList;

public class ProductService {
    public static ArrayList<Pet> listPet(){
        return ProductRepository.listPet();
    }
    public static ArrayList<Food> listFood(){
        return ProductRepository.listFood();
    }
    public static ArrayList<Pet> listCat(){
        return ProductRepository.listCat();
    }
    public static ArrayList<Pet> listDog(){
        return ProductRepository.listDog();
    }
}
