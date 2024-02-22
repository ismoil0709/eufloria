package uz.pdp.eufloria.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
import uz.pdp.eufloria.dto.response.StoreDto;
import uz.pdp.eufloria.service.StoreService;

import java.time.LocalTime;

@RestController
@RequestMapping("/api/v1/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid StoreDto storeDto) {
        return ResponseEntity.ok(storeService.save(storeDto));
    }

    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid StoreDto storeDto) {
        return ResponseEntity.ok(storeService.update(storeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @NotNull Long id) {
        storeService.delete(id);
        return ResponseEntity.ok("Store deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable @NotNull Long id) {
        return ResponseEntity.ok(storeService.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable @NotBlank String name) {
        return ResponseEntity.ok(storeService.getByName(name));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(storeService.getAll());
    }

    @GetMapping("/opens/{opens}")
    public ResponseEntity<?> getByOpens(@PathVariable @NotNull LocalTime opens) {
        return ResponseEntity.ok(storeService.getAllByOpens(opens));
    }

    @GetMapping("/closes/{closes}")
    public ResponseEntity<?> getByCloses(@PathVariable @NotNull LocalTime closes) {
        return ResponseEntity.ok(storeService.getAllByCloses(closes));
    }
}
