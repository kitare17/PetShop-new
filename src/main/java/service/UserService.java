package service;

import entity.User;
import repository.UserRepository;

public class UserService {
    public static User addUser(User user){
        UserRepository.register(user);
        return user;
    }
    public static boolean checkUserNameExist(String username){
        return UserRepository.checkUserNameExist(username);
    }
    public static User checkLogin(String username,String password){
        return UserRepository.login(username, password);
    }
}
