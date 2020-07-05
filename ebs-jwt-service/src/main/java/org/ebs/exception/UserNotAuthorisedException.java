package org.ebs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "User Not Authorised")
public class UserNotAuthorisedException extends Exception {
}
