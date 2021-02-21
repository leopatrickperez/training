package com.bootcamp.springboot.services;
import com.bootcamp.springboot.model.User;
import com.bootcamp.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public Optional<User> findById(long id) {
        return this.userRepository.findById(id);
    }

    public User findByUserName(String username) {
        return this.userRepository.findByUsername(username);
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }
}
