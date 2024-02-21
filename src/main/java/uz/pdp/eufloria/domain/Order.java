package uz.pdp.eufloria.domain;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.eufloria.enums.OrderType;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private Double totalPrice;
    private LocalDate date;
    private LocalTime time;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    private Double shippingCoast;
    @ManyToOne
    private Address address;

}
