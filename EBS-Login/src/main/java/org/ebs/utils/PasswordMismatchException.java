package org.ebs.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "New Password and Confirm Password mismatch")
public class PasswordMismatchException extends Exception {
}
