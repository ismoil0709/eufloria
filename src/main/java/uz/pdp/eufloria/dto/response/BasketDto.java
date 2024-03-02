package uz.pdp.eufloria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.eufloria.domain.Basket;
import uz.pdp.eufloria.domain.Product;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BasketDto {
    private Long id;
    private List<Long> productIdList;
    public BasketDto(Basket basket){
        this.id = basket.getId();
        this.productIdList = basket.getProductList().stream().map(Product::getId).toList();
    }
}
