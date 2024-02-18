package uz.pdp.eufloria.service;

import org.springframework.stereotype.Service;
import uz.pdp.eufloria.domain.User;
import uz.pdp.eufloria.dto.UserLoginDto;
import uz.pdp.eufloria.dto.UserRegisterDto;
import uz.pdp.eufloria.dto.UserUpdateDto;

import java.util.List;

@Service
public interface UserService {
    User register(UserRegisterDto userRegisterDto);
    User login(UserLoginDto userLoginDto);
    User getById(Long id);
    User getByUsername(String username);
    User getByEmail(String email);
    List<User> getAll();
    User getByPhoneNumber(String phoneNumber);
    User update(UserUpdateDto userUpdateDto);
    void deleteById(Long id);
    void deleteByUsername(String username);
    void deleteByEmail(String email);
}