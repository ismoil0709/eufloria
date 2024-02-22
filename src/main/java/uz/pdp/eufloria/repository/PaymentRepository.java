package uz.pdp.eufloria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.eufloria.domain.Payment;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("select p from Payment p inner join Order o on o.id = :id")
    Optional<Payment> findByOrder(Long id);
    List<Payment> findAllByCard(String card);
}