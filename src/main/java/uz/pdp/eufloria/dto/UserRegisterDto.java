package uz.pdp.eufloria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRegisterDto {
    private String email;
    private String username;
    private String password;
}
