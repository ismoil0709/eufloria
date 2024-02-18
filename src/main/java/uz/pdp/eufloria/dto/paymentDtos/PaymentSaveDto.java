package uz.pdp.eufloria.dto.paymentDtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSaveDto {

    @Pattern(regexp = "\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}", message = "Invalid card Number")
    @NotNull(message = "Card is Null")
    @NotEmpty(message = "Card is empty")
    private String card;
    @NotEmpty(message = "Amount is empty")
    private BigDecimal amount;
    @NotNull(message = "OrderId is null")
    private Long orderId;
}
