package uz.pdp.eufloria.controller;

import jakarta.validation.Valid;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.eufloria.dto.request.ProductCreateDto;
import uz.pdp.eufloria.dto.response.ProductDto;
import uz.pdp.eufloria.service.ProductService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid ProductCreateDto productCreateDto){
        return ResponseEntity.ok(productService.save(productCreateDto));
    }
    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid ProductDto productDto){
        return ResponseEntity.ok(productService.update(productDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @NotNull Long id){
        productService.delete(id);
        return ResponseEntity.ok(Map.of("message","Product successfully deleted"));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable @NotNull Long id){
        return ResponseEntity.ok(productService.getById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }
    @GetMapping("/all/{available}")
    public ResponseEntity<?> getAllByAvailable(@PathVariable @NotNull Boolean available){
        return ResponseEntity.ok(productService.getAllByAvailable(available));
    }
}
