package org.ebs.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.ebs.exception.UserNotAuthorisedException;
import org.ebs.model.UserProfile;
import org.ebs.utils.JwtUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class JwtController {

    @RequestMapping(path = "/jwt", method = RequestMethod.GET)
    public String getJWTToken(HttpServletRequest request, UserProfile userProfile) {
        return JWT.create().withSubject(userProfile.getLoginId()).
                withClaim("NAME", userProfile.getName()).
                withClaim("ROLE", userProfile.getRoleE().getRole()).
                withExpiresAt(JwtUtils.getJwtTokenExpiry()).
                sign(Algorithm.HMAC256(JwtUtils.getJwtSecretKey()));
    }
    @RequestMapping(path = "/jwt", method = RequestMethod.POST)
    public void validateJWTToken(@RequestBody Map<String, String> jwtToken) throws UserNotAuthorisedException {
        try {
            JWT.require(Algorithm.HMAC256(JwtUtils.getJwtSecretKey())).build().verify(jwtToken.get("jwtToken"));
        } catch (JWTVerificationException e) {
            throw new UserNotAuthorisedException();
        }
    }
}