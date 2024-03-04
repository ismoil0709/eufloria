package uz.pdp.eufloria.dto.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.eufloria.domain.enums.OrderType;
import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderSaveDto {
    private Double totalPrice;
    private LocalDate date;
    private Long userId;
    private LocalTime time;
    private OrderType orderType;
    private Double shippingCoast;
    private Long addressId;

}
