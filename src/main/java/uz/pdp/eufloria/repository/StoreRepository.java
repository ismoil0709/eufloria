package uz.pdp.eufloria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.eufloria.domain.Store;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByName(String name);
    List<Store> findAllByOpens(LocalTime opens);
    List<Store> findAllByCloses(LocalTime closes);

    //TODO Check address and products when they done
}
