package org.ebs.controller;

import org.ebs.model.LoginModel;
import org.ebs.service.LoginService;
import org.ebs.utils.InvalidUserCredentialException;
import org.ebs.utils.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(path = "/session", method = RequestMethod.POST)
    public void login(@RequestBody LoginModel loginModel) throws UserNotFoundException, InvalidUserCredentialException {
        loginService.login(loginModel);
    }
}
