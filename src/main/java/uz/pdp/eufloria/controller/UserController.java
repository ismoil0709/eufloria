package uz.pdp.eufloria.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.eufloria.dto.request.UserLoginDto;
import uz.pdp.eufloria.dto.request.UserRegisterDto;
import uz.pdp.eufloria.dto.request.UserUpdateDto;
import uz.pdp.eufloria.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRegisterDto userRegisterDto){
        return ResponseEntity.ok(userService.register(userRegisterDto));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginDto userLoginDto){
        return ResponseEntity.ok(userService.login(userLoginDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable @NotNull Long id){
        return ResponseEntity.ok(userService.getById(id));
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable @NotNull @NotBlank @NotEmpty String username){
        return ResponseEntity.ok(userService.getByUsername(username));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable @NotNull @NotBlank @NotEmpty String email){
        return ResponseEntity.ok(userService.getByEmail(email));
    }
    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<?> getByPhoneNumber(@PathVariable @NotNull @NotBlank @NotEmpty String phoneNumber){
        return ResponseEntity.ok(userService.getByPhoneNumber(phoneNumber));
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<?> getByStatus(@PathVariable @NotNull boolean status){
        return ResponseEntity.ok(userService.getByStatus(status));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid UserUpdateDto userUpdateDto){
        return ResponseEntity.ok(userService.update(userUpdateDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable @NotNull Long id){
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted");
    }
}
