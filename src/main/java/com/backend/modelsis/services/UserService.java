package com.backend.modelsis.services;

import com.backend.modelsis.entites.UserCustomer;
import com.backend.modelsis.repository.UserCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserCustomerRepository userCustomerRepository;
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean verifyPassword(String inputPassword, String HASHED_PASSWORD) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(inputPassword.getBytes());
            byte[] hashedPasswordBytes = md.digest();

            StringBuilder hashedPassword = new StringBuilder();
            for (byte b : hashedPasswordBytes) {
                hashedPassword.append(String.format("%02x", b));
            }

            return HASHED_PASSWORD.equals(hashedPassword.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public UserCustomer postUser(UserCustomer user){
        UserCustomer u = new UserCustomer();
        u.setUsername(user.getUsername());
        u.setPassword(hashPassword(user.getPassword()));
        return userCustomerRepository.save(u);
    }
    public UserCustomer getUser(UserCustomer user){
        UserCustomer user1 = userCustomerRepository.findUserByUsername(user.getUsername());
        if (verifyPassword(user.getPassword(),user1.getPassword())) {
            return user1;
        }else{
            return null;
        }
    }
}
