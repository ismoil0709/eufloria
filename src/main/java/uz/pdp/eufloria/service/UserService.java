package uz.pdp.eufloria.service;

import org.springframework.stereotype.Service;
import uz.pdp.eufloria.dto.request.UserLoginDto;
import uz.pdp.eufloria.dto.request.UserRegisterDto;
import uz.pdp.eufloria.dto.request.UserUpdateDto;
import uz.pdp.eufloria.dto.response.UserDto;

import java.util.List;

@Service
public interface UserService {
    UserDto register(UserRegisterDto userRegisterDto);
    UserDto login(UserLoginDto userLoginDto);
    UserDto getById(Long id);
    UserDto getByUsername(String username);
    UserDto getByEmail(String email);
    List<UserDto> getAll();
    UserDto getByPhoneNumber(String phoneNumber);
    List<UserDto> getByStatus(Boolean status);
    UserDto update(UserUpdateDto userUpdateDto);
    void deleteById(Long id);

}