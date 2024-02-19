package uz.pdp.eufloria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.pdp.eufloria.domain.Category;

import java.util.List;

@AllArgsConstructor
@Getter
public class ProductCreateDto {
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    private String description;
    @NotNull
    @NotEmpty
    @NotBlank
    private Boolean available;
    @NotNull
    @NotEmpty
    private List<Category> categories;
}
