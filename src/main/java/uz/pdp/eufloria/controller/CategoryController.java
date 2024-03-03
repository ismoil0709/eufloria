package uz.pdp.eufloria.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eufloria.dto.response.CategoryDto;
import uz.pdp.eufloria.service.CategoryService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.save(categoryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @NotNull Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok(Map.of("message", "Category successfully deleted"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable @NotNull Long id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable @NotNull String name) {
        return ResponseEntity.ok(categoryService.getByName(name));
    }

    @PutMapping("/add/{category}/{productId}")
    public ResponseEntity<?> addCategoryToProduct(@PathVariable @NotBlank String category, @PathVariable @NotNull Long productId) {
        categoryService.addCategoryToProduct(category, productId);
        return ResponseEntity.ok(Map.of("message", "Category successfully added to product"));
    }

    @DeleteMapping("/remove/{category}/{productId}")
    public ResponseEntity<?> removeCategoryFromProduct(@PathVariable @NotBlank String category, @PathVariable @NotNull Long productId) {
        categoryService.removeCategoryFromProduct(category, productId);
        return ResponseEntity.ok(Map.of("message", "Category successfully added to product"));
    }
}
