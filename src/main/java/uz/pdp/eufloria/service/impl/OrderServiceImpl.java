package uz.pdp.eufloria.service.impl;

import lombok.RequiredArgsConstructor;
import uz.pdp.eufloria.domain.Order;
import uz.pdp.eufloria.dto.request.OrderSaveDto;
import uz.pdp.eufloria.dto.response.OrderDto;
import uz.pdp.eufloria.exception.NotFoundException;
import uz.pdp.eufloria.repository.AddressRepository;
import uz.pdp.eufloria.repository.OrderRepository;
import uz.pdp.eufloria.repository.UserRepository;
import uz.pdp.eufloria.service.OrderService;

import java.util.List;

import static org.apache.tomcat.jni.Buffer.address;

@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    @Override
    public OrderDto orderSave(OrderSaveDto orderSaveDto) {


        return new OrderDto(orderRepository.save(Order.builder()
                .orderType(orderSaveDto.getOrderType())
                .time(orderSaveDto.getTime())
                .date(orderSaveDto.getDate())
                .shippingCoast(orderSaveDto.getShippingCoast())
                .totalPrice(orderSaveDto.getTotalPrice())
                .orderType(orderSaveDto.getOrderType())
                .user(userRepository.findById(orderSaveDto.getUserId()).orElseThrow(
                        ()->new NotFoundException("User")
                ))
                .address(addressRepository.findById(orderSaveDto.getAddressId()).orElseThrow(
                        ()->new NotFoundException("Address")
                ))
                .build()));
    }

    @Override
    public Boolean deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return true;
    }

    @Override
    public List<OrderDto> findByUserId(Long userId) {
        return orderRepository.findByUserId(userId).orElseThrow(() -> new NotFoundException("order"));
    }

    @Override
    public List<OrderDto> findByOrderId(Long id) {
        return orderRepository.findByOrderId(id).orElseThrow(() -> new NotFoundException("order"));
    }
}
