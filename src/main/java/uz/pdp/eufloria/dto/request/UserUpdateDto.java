package uz.pdp.eufloria.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.pdp.eufloria.domain.Address;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserUpdateDto {

    @NotNull
    private Long id;
    private String email;
    private String phoneNumber;
    private List<Address> address;
    private String username;
    private String password;
}