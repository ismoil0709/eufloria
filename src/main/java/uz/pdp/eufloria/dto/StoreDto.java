package uz.pdp.eufloria.dto;

import com.nimbusds.openid.connect.sdk.claims.Address;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    @NotNull
    private LocalTime opens;
    @NotNull
    private LocalTime closes;
    @OneToOne
    private Address address;
    @OneToMany
    private List<ProductDto> products;

    public StoreDto(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.opens = store.getOpens();
        this.closes = store.getCloses();
    }
}
