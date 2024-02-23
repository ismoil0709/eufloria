package uz.pdp.eufloria.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eufloria.service.BasketService;

import java.util.Map;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    @PutMapping("/add/{productId}/{id}")
    public ResponseEntity <?> addProductToBasket(@PathVariable Long productId, @PathVariable Long id){
        basketService.addProductToBasket(productId, id);
        return ResponseEntity.ok(Map.of("message", "Product successfully added to the basket"));
    }

    @PostMapping("/clear")
    public ResponseEntity<?> clearBasket(@PathVariable Long id){
        basketService.clearBasket(id);
        return ResponseEntity.ok(Map.of("message", "Basket successfully cleared"));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(basketService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(basketService.getById(id));
    }

    @DeleteMapping("/remove/{productId}/{id}")
    public ResponseEntity<?> removeProductFromBasket(@PathVariable Long productId, @PathVariable Long id){
        basketService.removeProductFromBasket(productId, id);
        return ResponseEntity.ok(Map.of("message", "Product successfully removed to the basket"));
    }

}











