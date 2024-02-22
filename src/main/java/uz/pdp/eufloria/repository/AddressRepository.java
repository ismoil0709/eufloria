package uz.pdp.eufloria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.eufloria.domain.Address;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
     Optional<Address> findByCity(String city);
     Optional<Address> findByCountry(String country);
}
