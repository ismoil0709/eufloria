package uz.pdp.eufloria.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.pdp.eufloria.domain.Category;

@AllArgsConstructor
@Getter
public class CategoryDto {
    private Long id;
    private String name;
    public CategoryDto(Category category){
        this.id = category.getId();
        this.name = category.getName();
    }
}
