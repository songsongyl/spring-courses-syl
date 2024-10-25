package org.example.springmvcexamples.exception;

import lombok.*;

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
