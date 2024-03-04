package uz.pdp.eufloria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.eufloria.domain.Basket;
import uz.pdp.eufloria.domain.User;
import uz.pdp.eufloria.dto.request.UserLoginDto;
import uz.pdp.eufloria.dto.request.UserRegisterDto;
import uz.pdp.eufloria.dto.request.UserUpdateDto;
import uz.pdp.eufloria.dto.response.UserDto;
import uz.pdp.eufloria.exception.AlreadyExistsException;
import uz.pdp.eufloria.exception.InvalidArgumentException;
import uz.pdp.eufloria.exception.NotFoundException;
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
    public UserDto register(UserRegisterDto userRegisterDto) {

        if (userRepository.findByUsernameAndStatus(userRegisterDto.getUsername(), true).isPresent())
            throw new AlreadyExistsException("Username");
        if (userRepository.findByEmailAndStatus(userRegisterDto.getEmail(), true).isPresent())
            throw new AlreadyExistsException("Email");
        if (userRepository.findByPhoneNumberAndStatus(userRegisterDto.getPhoneNumber(), true).isPresent())
            throw new AlreadyExistsException("Phone number");

        return new UserDto(userRepository.save(User.builder()
                .username(userRegisterDto.getUsername())
                .password(passwordEncoder.encode(userRegisterDto.getPassword()))
                .email(userRegisterDto.getEmail())
                .phoneNumber(userRegisterDto.getPhoneNumber())
                        .basket(new Basket())
                .build()));
    }

    @Override
    public UserDto login(UserLoginDto userLoginDto) {
        User user = userRepository.findByUsernameAndStatus(userLoginDto.getUsername(), true).orElseThrow(
                () -> new NotFoundException("User"));
        if (!passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword()))
            throw new InvalidArgumentException("Password");
        return new UserDto(user);
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.findByIdAndStatus(id, true).orElseThrow(
                () -> new NotFoundException("User"));
        return new UserDto(user);
    }

    @Override
    public UserDto getByUsername(String username) {
        User user = userRepository.findByUsernameAndStatus(username, true).orElseThrow(
                () -> new NotFoundException("User"));
        return new UserDto(user);
    }

    @Override
    public UserDto getByEmail(String email) {
        User user = userRepository.findByEmailAndStatus(email, true).orElseThrow(
                () -> new NotFoundException("Email"));
        return new UserDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(UserDto::new).toList();
    }

    @Override
    public UserDto getByPhoneNumber(String phoneNumber) {
        User user = userRepository.findByPhoneNumberAndStatus(phoneNumber, true).orElseThrow(
                () -> new NotFoundException("Phone Number"));
        return new UserDto(user);
    }

    @Override
    public List<UserDto> getByStatus(Boolean status) {
        return userRepository.findAllByStatus(status).stream().map(UserDto::new).toList();
    }

    @Override
    public UserDto update(UserUpdateDto userUpdateDto) {
        User user = userRepository.findByIdAndStatus(userUpdateDto.getId(), true).orElseThrow(
                () -> new NotFoundException("User")
        );
        if (userUpdateDto.getEmail() != null && userRepository.findByEmailAndStatus(userUpdateDto.getEmail(), true).isPresent())
            throw new AlreadyExistsException("Email");

        return new UserDto(userRepository.save(
                User.builder()
                        .id(user.getId())
                        .password(Validator.requireNonNullElse(passwordEncoder.encode(userUpdateDto.getPassword()), user.getPassword()))
                        .email(Validator.requireNonNullElse(userUpdateDto.getEmail(), user.getEmail()))
                        .username(Validator.requireNonNullElse(userUpdateDto.getUsername(), user.getUsername()))
                        .phoneNumber(Validator.requireNonNullElse(userUpdateDto.getPhoneNumber(), user.getPhoneNumber()))
                        .address(Validator.requireNonNullElse(userUpdateDto.getAddress(), user.getAddress()))
                        .build()
        ));
    }

    @Override
    public void deleteById(Long id) {
        User user = userRepository.findByIdAndStatus(id, true).orElseThrow(
                () -> new NotFoundException("User")
        );
        user.setStatus(false);
        userRepository.save(user);
    }

}