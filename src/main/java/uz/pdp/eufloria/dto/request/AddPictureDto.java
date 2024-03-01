package uz.pdp.eufloria.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Getter
public class AddPictureDto {
    @NotNull
    private MultipartFile file;
    @NotNull
    private Long productId;
}
