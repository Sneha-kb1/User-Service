package io.scalability.assignment.videosharingdemo.services;

import io.scalability.assignment.videosharingdemo.domain.User;
// import io.john.amiscaray.videosharingdemo.services.UserService;
import io.scalability.assignment.videosharingdemo.exceptions.UserAlreadyExistsException;
import io.scalability.assignment.videosharingdemo.exceptions.UserNotFoundException;
import io.scalability.assignment.videosharingdemo.repo.UserRepo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
    private final UserRepo repo;
    // Manual constructor injection (NO Lombok)
    public UserServiceImpl(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public void register(String username, String password) {
        int hashedPassword = password.hashCode();
        if(repo.existsByUsername(username)){
            throw new UserAlreadyExistsException("User already exists.");
        }   
        repo.save(new User(username, hashedPassword));
    }

    @Override
    public void login(String username, String password) {
        int hashedPassword = password.hashCode();
        if(!repo.existsByUsername(username)){
            throw new UserNotFoundException("User not found.");
        }
        User user = repo.findByUsername(username);
        if(user.getPassword()!=hashedPassword){
            throw new UserNotFoundException("User not found");
        }
    }

    // change password
    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        int oldHashedPassword = oldPassword.hashCode();
        if(!repo.existsByUsername(username)){
            throw new UserNotFoundException("User not found.");
        }
        // check if old password is correct
        User user = repo.findByUsername(username);
        if(user.getPassword()!=oldHashedPassword){
            throw new UserNotFoundException("Incorrect Password");
        }
        int newHashedPassword = newPassword.hashCode();
        user.setPassword(newHashedPassword);
        repo.save(user);
    }

    @Override
    public void logout() {
        // TODO Auto-generated method stub
    }
}
