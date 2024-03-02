package uz.pdp.eufloria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.eufloria.domain.Order;
import uz.pdp.eufloria.dto.response.OrderDto;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("select new uz.pdp.eufloria.dto.response.OrderDto(o) from Order o where o.user.id =: userId")
    Optional<List<OrderDto>>findByUserId(Long userId);
    @Query("select new uz.pdp.eufloria.dto.response.OrderDto(o) from Order o where o.id =: id")
    Optional<List<OrderDto>>findByOrderId(Long id);

}
