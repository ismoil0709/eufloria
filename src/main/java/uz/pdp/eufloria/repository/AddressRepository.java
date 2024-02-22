package uz.pdp.eufloria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.eufloria.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
