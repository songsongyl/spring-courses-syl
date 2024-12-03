package org.example.softwarearchitecture.dox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public static final int USER = 1;
    public static final int ADMIN = 10;

    @Id
    @CreatedBy
    private String id;
    private String account;
    private String password;
    private Integer role;

}
