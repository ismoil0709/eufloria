package uz.pdp.eufloria.domain;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Category}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto implements Serializable {
   private Long id;
   private String name;
}