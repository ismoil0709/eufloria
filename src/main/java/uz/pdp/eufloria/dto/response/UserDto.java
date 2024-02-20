package uz.pdp.eufloria.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.pdp.eufloria.domain.User;

@Getter
@AllArgsConstructor
public class UserDto {
    @NotNull
    private Long id;
    @NotEmpty
    @NotBlank
    @NotNull
    private String username;
    @NotEmpty
    @NotBlank
    @NotNull
    private String email;
    @NotEmpty
    @NotBlank
    @NotNull
    private String phoneNumber;
    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
    }
}
