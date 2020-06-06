package org.ebs.service;

import org.ebs.entity.LoginEntity;
import org.ebs.enums.UserRoleE;
import org.ebs.model.LoginModel;
import org.ebs.model.SignUpModel;
import org.ebs.repository.LoginRepository;
import org.ebs.utils.InvalidUserCredentialException;
import org.ebs.utils.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginServiceTest {

    private LoginRepository loginRepository;
    private LoginService loginService;

    @BeforeEach
    void init() {
        loginRepository = mock(LoginRepository.class);
        loginService = new LoginService(loginRepository);
    }

    @Test
    public void TestLoginServiceShouldBeSuccessfull() throws UserNotFoundException, InvalidUserCredentialException {
        LoginModel loginModel = new LoginModel("DUMMY", "root");
        LoginEntity loginEntity = new LoginEntity("DUMMY", "$2a$10$KXSEWnLeov3vtEbcA07LQuJQq9bJ3SN6w2Qf6lOJp7ZFN43B0nsBa", UserRoleE.ADMIN);
        Optional<LoginEntity> optional = Optional.ofNullable(loginEntity);
        when(loginRepository.findById(loginModel.getUserName())).thenReturn(optional);
        loginService.login(loginModel);
    }

    @Test
    public void TestLoginServiceShouldThrowUserNotFoundExceptionWhenInvalidUsernameProvided() {
        LoginModel loginModel = new LoginModel("DUMMY", "DUMMY");
        LoginEntity loginEntity = null;
        Optional<LoginEntity> optional = Optional.ofNullable(loginEntity);
        when(loginRepository.findById(loginModel.getUserName())).thenReturn(optional);
        assertThrows(UserNotFoundException.class, () -> {
            loginService.login(loginModel);
        });
    }

    @Test
    public void TestLoginServiceShouldThrowInvalidUserCredentialsExceptionWhenInvalidPasswordProvided() {
        LoginModel loginModel = new LoginModel("DUMMY", "DUMMY");
        LoginEntity loginEntity = new LoginEntity("DUMMY", "$2a$10$KXSEWnLeov3vtEbcA07LQuJQq9bJ3SN6w2Qf6lOJp7ZFN43B0nsBa", UserRoleE.ADMIN);
        Optional<LoginEntity> optional = Optional.ofNullable(loginEntity);
        when(loginRepository.findById(loginModel.getUserName())).thenReturn(optional);
        assertThrows(InvalidUserCredentialException.class, () -> {
            loginService.login(loginModel);
        });
    }


    @Test
    public void TestSignUpShouldSaveUserCredentialsSuccessfully() {
        char[] password = {'D', 'U', 'M', 'M', 'Y'};
        SignUpModel signUpModel = new SignUpModel("DUMMY", password);
        loginService.signUp(signUpModel);
    }

}
