package org.example.softwarearchitecture.dox;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @CreatedBy
    private String id;
    private String detail;
    private String userId;
}
