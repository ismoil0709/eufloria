package uz.pdp.eufloria.service;

import org.springframework.stereotype.Service;
import uz.pdp.eufloria.dto.response.CategoryDto;

import java.util.List;

@Service
public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);
    void delete(Long id);
    CategoryDto getById(Long id);
    List<CategoryDto> getAll();
    CategoryDto getByName(String name);
    void addCategoryToProduct(String category,Long productId);
    void removeCategoryFromProduct(String category,Long productId);
}
