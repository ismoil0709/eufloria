package uz.pdp.eufloria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserUpdateDto {
    private String email;
    private String phoneNumber;
    private Address address;
    private String username;
    private String password;
}
