package uz.pdp.eufloria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import uz.pdp.eufloria.domain.Store;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class StoreDto {
    private Long id;
    private String name;
    private LocalTime opens;
    private LocalTime closes;
    //@OneToOne
//    private Address address;
//    @OneToMany
//    private List<Product> products;


    public StoreDto(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.opens = store.getOpens();
        this.closes = store.getCloses();
    }
}
