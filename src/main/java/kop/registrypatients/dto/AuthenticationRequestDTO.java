package kop.registrypatients.dto;

import lombok.Data;


@Data
public class AuthenticationRequestDTO {

    private String email;
    private String password;
}
