package org.example.backendexamples.exception;

import lombok.*;
import org.example.backendexamples.exception.Code;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class XException extends RuntimeException{
    private Code code;
    private int number;
    private String message;

}
