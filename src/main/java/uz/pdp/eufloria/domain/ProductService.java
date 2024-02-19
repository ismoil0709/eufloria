package uz.pdp.eufloria.domain;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper = new ModelMapper();




    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((element) -> modelMapper.map(element, ProductDto.class))
                .collect(Collectors.toList());
    }


    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        return modelMapper.map(product, ProductDto.class);
    }


    public ProductDto createProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }


    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct != null) {
            BeanUtils.copyProperties(productDto, existingProduct);
            Product updatedProduct = productRepository.save(existingProduct);
            return modelMapper.map(updatedProduct, ProductDto.class);
        }
        return null;
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

//    private ProductDto convertToDto(Product product) {
//        ProductDto productDto = new ProductDto();
//        BeanUtils.copyProperties(product, productDto);
//        return productDto;
//    }

//    private Product convertToEntity(ProductDto productDto) {
//        Product product = new Product();
//        BeanUtils.copyProperties(productDto, product);
//        return product;
//    }

}
