package org.ebs.controller;

import org.ebs.exception.*;
import org.ebs.model.LoginModel;
import org.ebs.model.SignUpModel;
import org.ebs.model.UserProfile;
import org.ebs.service.LoginService;
import org.ebs.service.UserProfileService;
import org.ebs.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(path = "/session", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody LoginModel loginModel, HttpServletRequest request) throws UserNotFoundException, InvalidUserCredentialException, UserProfileNotFoundException {
        logger.info("Login journey started");
        loginService.login(loginModel);
        HttpSession session = request.getSession(true);
        session.setAttribute(Constants.LOGIN_ID, loginModel.getUserName());
        UserProfile userProfile = userProfileService.getUserProfile(loginModel.getUserName());
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://ebs-jwt-service/jwt")
                .queryParam("loginId", userProfile.getLoginId())
                .queryParam("name", userProfile.getName())
                .queryParam("roleE", userProfile.getRoleE().getRole());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
            ResponseEntity<String> str = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
        HttpHeaders h = new HttpHeaders();
        h.add(HttpHeaders.SET_COOKIE, "jwt=" + str.getBody());
        return ResponseEntity.status(HttpStatus.OK).headers(h).build();
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
    public void signUp(@RequestBody @NotNull SignUpModel signUpModel) throws PasswordMismatchException, CredentialsAlreadyPresentException {
        if (signUpModel.getPassword().length != signUpModel.getConfirmPassword().length) {
            throw new PasswordMismatchException();
        } else {
            for (int i = 0; i < signUpModel.getPassword().length - 1; i++) {
                if (signUpModel.getPassword()[i] != signUpModel.getConfirmPassword()[i]) {
                    throw new PasswordMismatchException();
                }
            }
        }
        loginService.signUp(signUpModel);
    }
}