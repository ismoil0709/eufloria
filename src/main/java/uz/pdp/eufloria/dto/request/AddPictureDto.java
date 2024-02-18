package uz.pdp.eufloria.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Getter
public class AddPictureDto {
    private MultipartFile file;
    private Long productId;
}
