package com.poliFood.service;

import com.poliFood.model.User;
import com.poliFood.projection.UserBarView;
import com.poliFood.projection.UserView;
import com.poliFood.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user){
        userRepository.save(user);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public List<UserView> findAll(){
        return userRepository.findAllBy();
    }

    public User findByEmail(String email){return userRepository.findByEmail(email);}

    public UserBarView getCurrentUser() {
        return userRepository.findAllByEmail(getCurrentUserEmail());
    }

    public String getCurrentUserEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getPrincipal().toString();
    }

    public UserView findAllById(Long id){
        return userRepository.findAllById(id);
    }
}
