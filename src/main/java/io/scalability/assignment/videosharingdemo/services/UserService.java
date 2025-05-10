package io.scalability.assignment.videosharingdemo.services;

public interface UserService{
    // register
    void register(String username, String password);

    // login
    void login(String username, String password);

    // change password
    void changePassword(String username, String oldPassword, String newPassword);
    
    // logout
    void logout();

}


