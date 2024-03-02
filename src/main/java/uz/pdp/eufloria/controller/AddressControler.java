package uz.pdp.eufloria.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eufloria.dto.AddressDto;
import uz.pdp.eufloria.service.AddressService;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressControler {
    private final AddressService addressService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid AddressDto addressDto) {
        return ResponseEntity.ok(addressService.save(addressDto));
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllAddresss(){
        return ResponseEntity.ok(addressService.getAllAddresss());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id){
        return ResponseEntity.ok(addressService.delete(id));
    }
}
