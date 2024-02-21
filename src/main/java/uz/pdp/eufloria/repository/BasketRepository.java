package uz.pdp.eufloria.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.eufloria.domain.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long>{
}
