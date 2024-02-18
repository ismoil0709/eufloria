package uz.pdp.eufloria.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PictureDeleteDto {
    private String url;
    private Long productId;
}
