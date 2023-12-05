package com.example.msrelations.service.registrationService;

import com.example.msrelations.registration.ConfirmationToken;
import com.example.msrelations.registration.Registration;
import com.example.msrelations.repository.TokenRepository;
import com.example.msrelations.repository.UserRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService{

    private final UserRegistrationRepository userRegistrationRepository;

    private final TokenRepository tokenRepository;

    private final MailSender mailSender;


    public ResponseEntity<?> saveUser(Registration user){

        if (userRegistrationRepository.existByUserEmail(user.getUserEmail())){
            return ResponseEntity.badRequest().body("Error:Email is already is use");
        }
        userRegistrationRepository.save(user);
        ConfirmationToken confirmationToken = new ConfirmationToken();
        tokenRepository.save(confirmationToken);
        String subject = "Complete Registration";
        String text = "Hello user,Ton confirm your account, please click here :"+
                "http://localhost:2223/v1/registration/confirm-account?token=" +confirmationToken.getConfirmationToken();

        mailSender.sendEmail(user.getUserEmail(),subject,text);
        System.out.println("Confirmation Token:"+ confirmationToken.generateConfirmationToken());
        return ResponseEntity.ok("vERIFY EMAIL BY THE LINK SENT TO YOUR EMAIL ADDRESS");

    }
    public ResponseEntity<?> confirmEmail(String confirmationToken){
        ConfirmationToken token=tokenRepository.findByConfiramationToken(confirmationToken);

        if(token!=null){
            Registration user=userRegistrationRepository.findByEmailIgnoreCase(token.getUserEntity().getUserEmail());
            user.setEnabled(true);
            userRegistrationRepository.save(user);
            return ResponseEntity.ok("Email verified successfully");
        }



    }
}
