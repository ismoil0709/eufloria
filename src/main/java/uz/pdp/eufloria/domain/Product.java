package uz.pdp.eufloria.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean available;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> category;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Picture> pictures;
}
