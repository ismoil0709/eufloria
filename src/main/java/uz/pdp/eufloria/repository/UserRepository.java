package uz.pdp.eufloria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eufloria.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhoneNumber(String phoneNumber);
    void deleteByUsername(String username);
    void deleteByEmail(String email);

}