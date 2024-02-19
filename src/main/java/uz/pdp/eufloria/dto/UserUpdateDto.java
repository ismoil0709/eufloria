package uz.pdp.eufloria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserUpdateDto {
    @NotNull
    @NotBlank
    @NotEmpty
    private String email;
    @NotNull
    @NotBlank
    @NotEmpty
    private String phoneNumber;
    @NotNull
    @NotBlank
    @NotEmpty
    private Address address;
    @NotNull
    @NotBlank
    @NotEmpty
    private String username;
    @NotNull
    @NotBlank
    @NotEmpty
    private String password;
}
