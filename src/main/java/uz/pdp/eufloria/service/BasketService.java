package uz.pdp.eufloria.service;

import org.springframework.stereotype.Service;
import uz.pdp.eufloria.dto.response.BasketDto;
import java.util.List;

@Service
public interface BasketService {
    BasketDto getById(Long id);
    List<BasketDto> getAll();
    void addProductToBasket(Long productId,Long id);
    void removeProductFromBasket(Long productId,Long id);
    void clearBasket(Long id);

}
