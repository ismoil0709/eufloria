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
import uz.pdp.eufloria.dto.request.PaymentSaveDto;
import uz.pdp.eufloria.service.PaymentService;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PaymentSaveDto paymentSaveDto) {
        return ResponseEntity.ok(paymentService.save(paymentSaveDto));
    }

    @PostMapping("/get-all/by/card")
    public ResponseEntity<?> getAllPaymentsByCard(@RequestBody String card) {
        return ResponseEntity.ok(paymentService.getAllPaymentsByCard(card));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getById(id));
    }


    @GetMapping("/get-by/order/{id}")
    public ResponseEntity<?> getByOrder(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getByOrder(id));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.delete(id));
    }
}
