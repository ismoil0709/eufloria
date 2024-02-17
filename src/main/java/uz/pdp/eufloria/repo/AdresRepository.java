package uz.pdp.eufloria.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.eufloria.entity.Adress;

@Repository
public interface AdresRepository extends JpaRepository<Adress, Long> {

}
