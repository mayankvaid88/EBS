package org.ebs.controller;

import org.ebs.model.LoginModel;
import org.ebs.model.SignUpModel;
import org.ebs.service.LoginService;
import org.ebs.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(path = "/session", method = RequestMethod.POST)
    public void login(@RequestBody LoginModel loginModel, HttpServletRequest request) throws UserNotFoundException, InvalidUserCredentialException {
        loginService.login(loginModel);
        HttpSession session = request.getSession(true);
        session.setAttribute(Constants.LOGIN_ID, loginModel.getUserName());
    }

    @RequestMapping(path = "/session", method = RequestMethod.DELETE)
    public void logout(HttpServletRequest request) throws SessionNotFoundException {
        Object attribute = request.getSession().getAttribute(Constants.LOGIN_ID);
        if (attribute == null) {
            throw new SessionNotFoundException();
        }
        request.getSession().invalidate();
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public void signUp(@RequestBody @NotNull SignUpModel signUpModel) throws PasswordMismatchException {
        System.out.println("password "+signUpModel.getPassword().length);
        if (!signUpModel.getPassword().equals(signUpModel.getConfirmPassword())) {
            throw new PasswordMismatchException();
        }
        loginService.signUp(signUpModel);
    }
}
