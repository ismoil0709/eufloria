package uz.pdp.eufloria.domain;

import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PictureDto implements Serializable {
    Long id;
    String imageUrl;
}