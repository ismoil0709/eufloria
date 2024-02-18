package uz.pdp.eufloria.dto.paymentDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.eufloria.domain.Payment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto implements Serializable {
    Long id;
    String card;
    BigDecimal amount;
    NestedOrderDto order;

    public PaymentDto(Payment payment) {
        this.id = payment.getId();
        this.card = payment.getCard();
        this.amount = payment.getAmount();
        this.order = new NestedOrderDto(
                payment.getOrder().getId(),
                payment.getOrder().getDate(),
                payment.getOrder().getTime()
        );
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class NestedOrderDto implements Serializable {
        Long id;
        LocalDate date;
        LocalTime time;
    }
}