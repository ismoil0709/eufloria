package uz.pdp.eufloria.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }
    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<OrderDto>> findByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(orderService.findByUserId(userId));
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<OrderDto>>findByOrderId(@PathVariable Long id){
        return ResponseEntity.ok(orderService.findByOrderId(id));
    }

}
