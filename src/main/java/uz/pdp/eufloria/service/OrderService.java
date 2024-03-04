package uz.pdp.eufloria.service;


import org.springframework.stereotype.Service;
import uz.pdp.eufloria.dto.request.OrderSaveDto;
import uz.pdp.eufloria.dto.response.OrderDto;

import java.util.List;

@Service
public interface OrderService {


    OrderDto orderSave(OrderSaveDto orderSaveDto);

    Boolean deleteOrder(Long id);

    List<OrderDto> findByUserId(Long userId);

    List<OrderDto> findByOrderId(Long id);


}
