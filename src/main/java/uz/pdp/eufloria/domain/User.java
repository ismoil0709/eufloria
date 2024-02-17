package uz.pdp.eufloria.domain;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.eufloria.domain.enums.Status;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private Status status;
    @OneToMany
    private List<Address> address;
    @OneToMany
    private List<Orders> orders;
    @OneToMany
    private Basket basket;
}
