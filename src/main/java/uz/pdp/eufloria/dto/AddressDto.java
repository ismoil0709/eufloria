package uz.pdp.eufloria.dto;

import uz.pdp.eufloria.domain.Address;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.eufloria.domain.User;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    @NotNull @NotEmpty @NotBlank
    private String country;
    @NotNull @NotEmpty @NotBlank
    private String city;
    @NotNull @NotEmpty @NotBlank
    private String district;
    @NotNull @NotEmpty @NotBlank
    private String street;
    @NotNull @NotEmpty @NotBlank
    private String home;
    @NotNull @OneToOne
    private User user;
    @NotNull
    private String lon;
    @NotNull
    private String lan;

    public AddressDto (Address address){
        this.id = address.getId();
        this.country = address.getCountry();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.district = address.getDistrict();
        this.home = address.getHome();
        this.lan = address.getLan();
        this.lon = address.getLon();
    }
}
