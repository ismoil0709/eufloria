package uz.pdp.eufloria.service;

import org.springframework.stereotype.Service;
import uz.pdp.eufloria.dto.response.ProductDto;
import uz.pdp.eufloria.dto.request.ProductCreateDto;

import java.util.List;

@Service
public interface ProductService {
    ProductDto save(ProductCreateDto productCreateDto);
    ProductDto update(ProductDto productDto);
    void delete(Long id);
    ProductDto getById(Long id);
    List<ProductDto> getAll();
    List<ProductDto> getAllByAvailable(Boolean available);
}
