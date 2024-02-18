package uz.pdp.eufloria.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.pdp.eufloria.domain.Category;

import java.util.List;

@AllArgsConstructor
@Getter
public class ProductCreateDto {
    private String name;
    private String description;
    private Boolean available;
    private List<Category> categories;
}
