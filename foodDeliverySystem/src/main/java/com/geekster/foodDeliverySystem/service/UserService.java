package com.geekster.foodDeliverySystem.service;


import com.geekster.foodDeliverySystem.dto.SignInInput;
import com.geekster.foodDeliverySystem.dto.SignInOutput;
import com.geekster.foodDeliverySystem.dto.SignUpOutput;
import com.geekster.foodDeliverySystem.model.AuthenticationToken;
import com.geekster.foodDeliverySystem.model.User;
import com.geekster.foodDeliverySystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository iUserRepository;

    @Autowired
    private AuthenticationTokenService tokenService;

    public List<User> getAllUsers() {
        return iUserRepository.findAll();
    }

    public SignUpOutput signUp(User signUpInput) {
        User user = iUserRepository.findFirstByUserEmail(signUpInput.getUserEmail());
        if(user != null){
            throw new IllegalStateException("User already exist");
        }

        String encryptedPassword = null;

        try{
            encryptedPassword = encryptPassword(signUpInput.getUserPassword());
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        signUpInput.setUserPassword(encryptedPassword);
        iUserRepository.save(signUpInput);
        return new SignUpOutput(HttpStatus.ACCEPTED,"User created successfully");
    }

    public String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        Object DatatypeConverter;
        DatatypeConverter = null;
        String hash = String.valueOf(DatatypeConverter.hashCode());

        return hash;
    }

    public SignInOutput signIn(SignInInput signInInput){
        User user = iUserRepository.findFirstByUserEmail(signInInput.getUserEmail());

        if(user == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInInput.getUserPassword());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(user.getUserPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

        //set up output response

        return new SignInOutput("Authentication Successfull !!!", token.getToken());


    }
}
