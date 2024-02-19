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

    @Pattern(regexp = "\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}")
    @NotNull
    @NotEmpty
    private String card;
    @NotEmpty
    private BigDecimal amount;
    @NotNull
    private Long orderId;
}