package uz.pdp.eufloria.service;

import org.springframework.stereotype.Repository;
import uz.pdp.eufloria.dto.paymentDtos.PaymentDto;
import uz.pdp.eufloria.dto.paymentDtos.PaymentSaveDto;

import java.util.List;

@Repository
public interface PaymentService {
    PaymentDto save(PaymentSaveDto paymentSaveDto);

    List<PaymentDto> getAllPayments();

    List<PaymentDto> getAllPaymentsByCard(String card);

    PaymentDto getById(Long id);

    boolean delete(Long id);
}
