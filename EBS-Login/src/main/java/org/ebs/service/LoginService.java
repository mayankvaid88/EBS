package org.ebs.service;


import org.ebs.entity.LoginEntity;
import org.ebs.model.LoginModel;
import org.ebs.model.SignUpModel;
import org.ebs.repository.LoginRepository;
import org.ebs.utils.EncryptionManager;
import org.ebs.utils.InvalidUserCredentialException;
import org.ebs.utils.UserNotFoundException;
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

    public void signUp(SignUpModel signUpModel) {
        String encryptedPWd = EncryptionManager.encrypt(signUpModel.getPassword());
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUserName(signUpModel.getUsername());
        loginEntity.setPassword(encryptedPWd);
        loginRepository.save(loginEntity);
    }
}
