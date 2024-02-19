package uz.pdp.eufloria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.eufloria.domain.User;
import uz.pdp.eufloria.dto.UserLoginDto;
import uz.pdp.eufloria.dto.UserRegisterDto;
import uz.pdp.eufloria.dto.UserUpdateDto;
import uz.pdp.eufloria.exception.InvalidArgumentException;
import uz.pdp.eufloria.exception.NotFoundException;
import uz.pdp.eufloria.exception.NullOrEmptyException;
import uz.pdp.eufloria.repository.UserRepository;
import uz.pdp.eufloria.service.UserService;
import uz.pdp.eufloria.util.Validator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public User register(UserRegisterDto userRegisterDto) {
        return userRepository.save(User.builder()
                        .username(userRegisterDto.getUsername())
                        .password(passwordEncoder.encode(userRegisterDto.getPassword()))
                        .email(userRegisterDto.getEmail())
                        .build());
    }

    @Override
    public User login(UserLoginDto userLoginDto) {
        User user = userRepository.findByUsername(userLoginDto.getUsername()).orElseThrow(
                () -> new NotFoundException("Username"));
        if (!passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword()))
            throw new InvalidArgumentException("Password");
        return user;
    }

    @Override
    public User getById(Long id) {
        if (id == null)
            throw new NullOrEmptyException("Id");
        return userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User"));
    }

    @Override
    public User getByUsername(String username) {
        if (Validator.isNullOrEmpty(username))
            throw new NullOrEmptyException("Username");
        return userRepository.findByUsername(username).orElseThrow(
                () -> new NotFoundException("Username"));
    }

    @Override
    public User getByEmail(String email) {
        if (Validator.isNullOrEmpty(email))
            throw new NullOrEmptyException("Email");
        return userRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundException("Email"));
    }

    @Override
    public List<User> getAll() {
        List<User> all = userRepository.findAll();
        if (all.isEmpty())
            throw new NotFoundException("Users");
        return all;
    }

    @Override
    public User getByPhoneNumber(String phoneNumber) {
        if (Validator.isNullOrEmpty(phoneNumber))
            throw new NullOrEmptyException("Phone Number");
        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(
                () -> new NotFoundException("Phone Number"));
    }

    @Override
    public User update(UserUpdateDto userUpdateDto) {
        //Update will be written after Address class is completed.
        return null;
    }

    @Override
    public void deleteById(Long id) {
        if (id == null)
            throw new NullOrEmptyException("Id");
        userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User")
        );
        userRepository.deleteById(id);
    }

    @Override
    public void deleteByUsername(String username) {
        if (Validator.isNullOrEmpty(username))
            throw new NullOrEmptyException("Username");
        userRepository.findByUsername(username).orElseThrow(
                () -> new NotFoundException("Username")
        );
        userRepository.deleteByUsername(username);
    }

    @Override
    public void deleteByEmail(String email) {
        if (Validator.isNullOrEmpty(email))
            throw new NullOrEmptyException("Email");
        userRepository.findByEmail(email).orElseThrow(
                () -> new NotFoundException("Email")
        );
        userRepository.deleteByEmail(email);
    }
}