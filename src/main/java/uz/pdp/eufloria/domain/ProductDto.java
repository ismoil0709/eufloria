package uz.pdp.eufloria.domain;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto implements Serializable {
   private Long id;
   private String name;
   private String description;
   private Boolean available;
   private Long category_id;
   private List<PictureDto> pictures;
}