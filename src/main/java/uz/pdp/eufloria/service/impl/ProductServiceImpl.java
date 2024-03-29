package uz.pdp.eufloria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eufloria.domain.Category;
import uz.pdp.eufloria.domain.Picture;
import uz.pdp.eufloria.domain.Product;
import uz.pdp.eufloria.dto.request.ProductCreateDto;
import uz.pdp.eufloria.dto.response.ProductDto;
import uz.pdp.eufloria.exception.NotFoundException;
import uz.pdp.eufloria.exception.NullOrEmptyException;
import uz.pdp.eufloria.repository.ProductRepository;
import uz.pdp.eufloria.service.ProductService;
import uz.pdp.eufloria.util.Validator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public ProductDto save(ProductCreateDto productCreateDto) {
        if (productCreateDto.getCategories().isEmpty())
            throw new NullOrEmptyException("Product categories");
        return new ProductDto(productRepository.save(Product.builder()
                        .name(productCreateDto.getName())
                        .description(productCreateDto.getDescription())
                        .available(productCreateDto.getAvailable())
                        .category(productCreateDto.getCategories())
                .build()));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        if (productDto.getId() == null)
            throw new NullOrEmptyException("Product id");
        Product existingProduct = productRepository.findById(productDto.getId()).orElseThrow(
                () -> new NotFoundException("Product")
        );
        return new ProductDto(productRepository.save(Product.builder()
                        .id(productDto.getId())
                        .name(Validator.requireNonNullElse(productDto.getName(),existingProduct.getName()))
                        .description(Validator.requireNonNullElse(productDto.getDescription(),existingProduct.getDescription()))
                        .available(Validator.requireNonNullElse(productDto.getAvailable(),existingProduct.getAvailable()))
                        .category(Validator.requireNonNullElse(productDto.getCategory().stream().map(cd-> new Category(cd.getId(),cd.getName())).toList(),existingProduct.getCategory()))
                        .pictures(Validator.requireNonNullElse(productDto.getPictureUrl().stream().map(p->new Picture(null,p)).toList(),existingProduct.getPictures()))
                .build()));
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id))
            throw new NotFoundException("Product");
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto getById(Long id) {
        return new ProductDto(productRepository.findById(id).orElseThrow(
                ()->new NotFoundException("Product")
        ));
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream().map(ProductDto::new).toList();
    }

    @Override
    public List<ProductDto> getAllByAvailable(Boolean available) {
        return productRepository.findAllByAvailable(available).stream().map(ProductDto::new).toList();
    }
}
