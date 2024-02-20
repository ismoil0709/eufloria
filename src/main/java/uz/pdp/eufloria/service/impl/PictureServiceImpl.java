package uz.pdp.eufloria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eufloria.domain.Picture;
import uz.pdp.eufloria.domain.Product;
import uz.pdp.eufloria.dto.request.AddPictureDto;
import uz.pdp.eufloria.dto.request.PictureDeleteDto;
import uz.pdp.eufloria.exception.NotFoundException;
import uz.pdp.eufloria.exception.NullOrEmptyException;
import uz.pdp.eufloria.repository.ProductRepository;
import uz.pdp.eufloria.service.PictureService;
import uz.pdp.eufloria.util.Validator;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {
    private final ProductRepository productRepository;

    @Override
    public void save(AddPictureDto pictureCreateDto) {
        Product product = productRepository.findById(pictureCreateDto.getProductId()).orElseThrow(
                () -> new NotFoundException("Product")
        );
        product.getPictures().add(new Picture(null, "some link"));
        productRepository.save(product);
    }

    @Override
    public void delete(PictureDeleteDto pictureDeleteDto) {
        Product product = productRepository.findById(pictureDeleteDto.getProductId()).orElseThrow(
                () -> new NotFoundException("Product")
        );
        product.getPictures().forEach(p -> {
                    if (p.getImageUrl().equals(pictureDeleteDto.getUrl()))
                        product.getPictures().remove(p);
                }
        );
        productRepository.save(product);
    }
}
