package uz.pdp.eufloria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eufloria.domain.Order;
import uz.pdp.eufloria.domain.Payment;
import uz.pdp.eufloria.dto.response.PaymentDto;
import uz.pdp.eufloria.dto.request.PaymentSaveDto;
import uz.pdp.eufloria.exception.NotFoundException;
import uz.pdp.eufloria.exception.NullOrEmptyException;
import uz.pdp.eufloria.repository.OrderRepository;
import uz.pdp.eufloria.repository.PaymentRepository;
import uz.pdp.eufloria.service.PaymentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Override
    public PaymentDto save(PaymentSaveDto paymentSaveDto) {
        if (paymentSaveDto == null) {
            throw new NullOrEmptyException("PaymentSaveDto");
        }
        Optional<Order> order = orderRepository.findById(paymentSaveDto.getOrderId());
        Payment payment = paymentRepository.save(Payment.builder()
                .card(paymentSaveDto.getCard())
                .amount(paymentSaveDto.getAmount())
                .order(order)
                .build());

        return new PaymentDto(payment);
    }

    @Override
    public List<PaymentDto> getAllPayments() {
        return paymentRepository.findAll().stream().map(PaymentDto::new).toList();
    }

    @Override
    public List<PaymentDto> getAllPaymentsByCard(String card) {
        return paymentRepository.getPaymentsByCard(card).stream().map(PaymentDto::new).toList();
    }