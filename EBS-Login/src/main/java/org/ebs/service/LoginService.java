package org.ebs.service;


import org.ebs.entity.LoginEntity;
import org.ebs.exception.CredentialsAlreadyPresentException;
import org.ebs.exception.InvalidUserCredentialException;
import org.ebs.exception.UserNotFoundException;
import org.ebs.model.LoginModel;
import org.ebs.model.SignUpModel;
import org.ebs.repository.LoginRepository;
import org.ebs.utils.EncryptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void login(LoginModel loginModel) throws UserNotFoundException, InvalidUserCredentialException {
        Optional<LoginEntity> loginEntity = loginRepository.findById(loginModel.getUserName());
        if (!loginEntity.isPresent()) {
            throw new UserNotFoundException();
        }
        if (!EncryptionManager.validate(loginModel.getPassword(), loginEntity.get().getPassword())) {
            throw new InvalidUserCredentialException();
        }
    }

    public void signUp(SignUpModel signUpModel) throws CredentialsAlreadyPresentException {
        String encryptedPWd = EncryptionManager.encrypt(signUpModel.getPassword());
        Optional<LoginEntity> byId = loginRepository.findById(signUpModel.getUsername());
        if (byId.isPresent()) {
            throw new CredentialsAlreadyPresentException();
        }
        loginRepository.findById(signUpModel.getUsername());
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUserName(signUpModel.getUsername());
        loginEntity.setPassword(encryptedPWd);
        loginRepository.save(loginEntity);
    }
}
