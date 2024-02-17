package uz.pdp.eufloria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.eufloria.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
