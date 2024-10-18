package org.example.springmvcexamples.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
RequiredArgsConstructor
public enum Code {
    LOGIN_ERROR(400,"账号密码错误"),
    
    private final int number;
    private final String message;

}
