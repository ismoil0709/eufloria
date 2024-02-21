package uz.pdp.eufloria.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.pdp.eufloria.domain.Address;
import uz.pdp.eufloria.domain.Order;
import uz.pdp.eufloria.domain.User;
import uz.pdp.eufloria.enums.OrderType;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private Double totalPrice;
    private Long userId;
    private LocalDate date;
    private LocalTime time;
    private OrderType orderType;
    private Double shippingCoast;
    private Long addressId;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.userId = order.getUser().getId();
        this.totalPrice = order.getTotalPrice();
        this.date = order.getDate();
        this.time = order.getTime();
        this.orderType = order.getOrderType();
        this.shippingCoast = order.getShippingCoast();
        this.addressId = order.getAddress().getId();
    }
}
