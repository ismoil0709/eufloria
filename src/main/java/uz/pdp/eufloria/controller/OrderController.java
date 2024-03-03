package uz.pdp.eufloria.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.eufloria.dto.request.OrderSaveDto;
import uz.pdp.eufloria.dto.response.OrderDto;
import uz.pdp.eufloria.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/save")
    public ResponseEntity<OrderDto>save(@RequestBody OrderSaveDto orderSaveDto){
        return ResponseEntity.ok(orderService.orderSave(orderSaveDto));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }
    @GetMapping("/find/by/{userId}")
    public ResponseEntity<List<OrderDto>> findByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(orderService.findByUserId(userId));
    }
    @GetMapping("/find/by/{id}")
    public ResponseEntity<List<OrderDto>>findByOrderId(@PathVariable Long id){
        return ResponseEntity.ok(orderService.findByOrderId(id));
    }

}
