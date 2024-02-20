package uz.pdp.eufloria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PictureDeleteDto {
    @NotNull
    @NotEmpty
    @NotBlank
    private String url;
    @NotNull
    @NotEmpty
    private Long productId;
}
