package uz.pdp.eufloria.domain;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.eufloria.exception.NotFoundException;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private final ModelMapper modelMapper =new ModelMapper();


    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
       return categories.stream().map(category -> modelMapper.map(category, CategoryDto.class))
                .toList();

    }


    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found with id: " + id));
        return modelMapper.map(category, CategoryDto.class);
    }


    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto,Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }


    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found with id: " + id));

        existingCategory.setName(categoryDto.getName());
        Category updatedCategory = categoryRepository.save(existingCategory);
        return modelMapper.map(updatedCategory, CategoryDto.class);
    }


    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new NotFoundException("Category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
    }
}
