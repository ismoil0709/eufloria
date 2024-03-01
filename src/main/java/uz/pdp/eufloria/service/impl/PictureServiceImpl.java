package uz.pdp.eufloria.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import uz.pdp.eufloria.domain.Picture;
import uz.pdp.eufloria.domain.Product;
import uz.pdp.eufloria.dto.request.AddPictureDto;
import uz.pdp.eufloria.dto.request.PictureDeleteDto;
import uz.pdp.eufloria.exception.NotFoundException;
import uz.pdp.eufloria.repository.ProductRepository;
import uz.pdp.eufloria.service.PictureService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {
    private final ProductRepository productRepository;
    private static final String BASE_URL = "https://pictures";
    private static final Path UPLOAD_DIR = Path.of(System.getProperty("user.home") + "eufloria"+ File.separator + "pictures" + File.separator);

    @Override
    @SneakyThrows
    public void save(AddPictureDto pictureCreateDto) {
        Product product = productRepository.findById(pictureCreateDto.getProductId()).orElseThrow(
                () -> new NotFoundException("Product")
        );
        Files.write(UPLOAD_DIR,pictureCreateDto.getFile().getInputStream().readAllBytes());
        product.getPictures().add(new Picture(null, BASE_URL + product.getId()+ "/" + pictureCreateDto.getFile().getOriginalFilename()));
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
