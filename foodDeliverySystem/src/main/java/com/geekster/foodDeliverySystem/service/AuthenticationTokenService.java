package com.geekster.foodDeliverySystem.service;

import com.geekster.foodDeliverySystem.model.AuthenticationToken;
import com.geekster.foodDeliverySystem.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationTokenService {
    @Autowired
    AuthenticationRepository tokenRepo;

    public void saveToken(AuthenticationToken token) {
        tokenRepo.save(token);
    }

    public boolean authenticate(String email, String token) {
        if(token==null || email==null){
            return false;
        }

        AuthenticationToken authToken = tokenRepo.findFirstByToken(token);

        if(authToken==null){
            return false;
        }

        String expectedEmail = authToken.getUser().getUserEmail();

        return expectedEmail.equals(email);
    }
}
