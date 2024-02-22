package uz.pdp.eufloria.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.eufloria.domain.Basket;
import uz.pdp.eufloria.domain.Product;
import uz.pdp.eufloria.dto.response.BasketDto;
import uz.pdp.eufloria.dto.response.ProductDto;
import uz.pdp.eufloria.exception.NotFoundException;
import uz.pdp.eufloria.exception.NullOrEmptyException;
import uz.pdp.eufloria.repository.BasketRepository;
import uz.pdp.eufloria.repository.ProductRepository;
import uz.pdp.eufloria.repository.UserRepository;
import uz.pdp.eufloria.service.BasketService;
import uz.pdp.eufloria.service.UserService;
import uz.pdp.eufloria.util.Validator;

import java.util.List;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

//    @Override
//    public BasketDto save(BasketDto basketDto) {
//        return new BasketDto(basketRepository.save(Basket.builder()
//                        .user(userRepository.findById(basketDto.getUserId())
//                                .orElseThrow(()-> new NotFoundException("User")))
//                .build()));
//    }
//
//    @Override
//    public BasketDto update(BasketDto basketDto) {
//        if(basketDto.getId() == null)
//            throw new NullOrEmptyException("Basket id");
//        Basket existingBasket = basketRepository.findById(basketDto.getId())
//                .orElseThrow(()-> new NotFoundException("Basket"));
//
//        return new BasketDto(basketRepository.save(Basket.builder()
//                .user(Validator.requireNonNullElse(basketDto.getUserId(), existingBasket.getUser()))
//                .build();
//
//    }
//
//    @Override
//    public void delete(Long id) {
//        if(!basketRepository.existsById(id))
//            throw new NotFoundException("Basket");
//        basketRepository.deleteById(id);
//    }

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
