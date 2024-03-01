package uz.pdp.eufloria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.pdp.eufloria.domain.Picture;
import uz.pdp.eufloria.domain.Product;

import java.util.List;

@AllArgsConstructor
@Getter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Boolean available;
    private List<CategoryDto> category;
    private List<String> pictureUrl;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.available = product.getAvailable();
        if (product.getCategory() != null)
            this.category = product.getCategory().stream().map(CategoryDto::new).toList();
        if (product.getPictures() != null)
            this.pictureUrl = product.getPictures().stream().map(Picture::getImageUrl).toList();
    }
}
