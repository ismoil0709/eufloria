package uz.pdp.eufloria.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eufloria.domain.Basket;
import uz.pdp.eufloria.domain.Product;
import uz.pdp.eufloria.dto.response.BasketDto;
import uz.pdp.eufloria.exception.NotFoundException;
import uz.pdp.eufloria.repository.BasketRepository;
import uz.pdp.eufloria.repository.ProductRepository;
import uz.pdp.eufloria.service.BasketService;

import java.util.List;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final ProductRepository productRepository;

    @Override
    public BasketDto getById(Long id) {
        return new BasketDto(basketRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Basket")
        ));
    }
    @Override
    public List<BasketDto> getAll() {
        return basketRepository.findAll().stream().map(BasketDto::new).toList();
    }
    @Override
    public void addProductToBasket(Long productId,Long id) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new NotFoundException("Product")
        );
        Basket basket = basketRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Basket")
        );
        basket.getProductList().add(product);
    }
    @Override
    public void removeProductFromBasket(Long productId,Long id) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new NotFoundException("Product")
        );
        Basket basket = basketRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Basket")
        );
        basket.getProductList().remove(product);
    }
    @Override
    public void clearBasket(Long id) {
        Basket basket = basketRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Basket")
        );
        basket.getProductList().clear();
    }
}
