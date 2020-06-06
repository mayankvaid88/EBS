package org.ebs.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Credentials already Exist")
public class CredentialsAlreadyPresentException extends Exception {
}
