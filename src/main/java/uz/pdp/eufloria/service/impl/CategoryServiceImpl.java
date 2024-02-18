package uz.pdp.eufloria.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eufloria.domain.Category;
import uz.pdp.eufloria.domain.Product;
import uz.pdp.eufloria.dto.response.CategoryDto;
import uz.pdp.eufloria.exception.AlreadyExistsException;
import uz.pdp.eufloria.exception.NotFoundException;
import uz.pdp.eufloria.exception.NullOrEmptyException;
import uz.pdp.eufloria.repository.CategoryRepository;
import uz.pdp.eufloria.repository.ProductRepository;
import uz.pdp.eufloria.service.CategoryService;
import uz.pdp.eufloria.util.Validator;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        if (Validator.isNullOrEmpty(categoryDto.getName()))
            throw new NullOrEmptyException("Category name");
        if (categoryRepository.findByName(categoryDto.getName()).isPresent())
            throw new AlreadyExistsException("Category");
        return new CategoryDto(categoryRepository.save(new Category(null, categoryDto.getName())));
    }

    @Override
    public void delete(Long id) {
        if (id == null)
            throw new NullOrEmptyException("Product id");
        if (!categoryRepository.existsById(id))
            throw new NotFoundException("Category");
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto getById(Long id) {
        if (id == null)
            throw new NullOrEmptyException("Product id");
        return new CategoryDto(categoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Product")
        ));
    }

    @Override
    public List<CategoryDto> getAll() {
        return categoryRepository.findAll().stream().map(CategoryDto::new).toList();
    }

    @Override
    public CategoryDto getByName(String name) {
        if (Validator.isNullOrEmpty(name))
            throw new NullOrEmptyException("Category name");
        return new CategoryDto(categoryRepository.findByName(name).orElseThrow(
                ()->new NotFoundException("Category")
        ));
    }

    @Override
    public void addCategoryToProduct(String category, Long productId) {
        if (Validator.isNullOrEmpty(category))
            throw new NullOrEmptyException("Category");
        if (productId == null)
            throw new NullOrEmptyException("Product id");
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new NotFoundException("Product")
        );
        product.getCategory().add(categoryRepository.findByName(category).orElseThrow(
                () -> new NotFoundException("Category")
        ));
        productRepository.save(product);
    }

    @Override
    public void removeCategoryFromProduct(String category, Long productId) {
        if (Validator.isNullOrEmpty(category))
            throw new NullOrEmptyException("Category");
        if (productId == null)
            throw new NullOrEmptyException("Product id");
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new NotFoundException("Product")
        );
        product.getCategory().remove(categoryRepository.findByName(category).orElseThrow(
                () -> new NotFoundException("Category")
        ));
        productRepository.save(product);
    }
}
