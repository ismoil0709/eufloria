package uz.pdp.eufloria.service;

import org.springframework.stereotype.Service;
import uz.pdp.eufloria.dto.response.PaymentDto;
import uz.pdp.eufloria.dto.request.PaymentSaveDto;

import java.util.List;

@Service
public interface PaymentService {
    PaymentDto save(PaymentSaveDto paymentSaveDto);

    List<PaymentDto> getAllPayments();

    List<PaymentDto> getAllPaymentsByCard(String card);

    PaymentDto getById(Long id);

    PaymentDto getByOrder(Long id);

    boolean delete(Long id);
}