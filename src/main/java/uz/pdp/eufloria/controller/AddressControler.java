package uz.pdp.eufloria.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    @GetMapping("/all")
    public ResponseEntity<?> getAllAddress(){
        return ResponseEntity.ok(addressService.getAllAddresss());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(addressService.delete(id));
    }
}
