package uz.pdp.eufloria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.eufloria.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndStatus(String username, boolean status);
    Optional<User> findByIdAndStatus(Long id, boolean status);
    Optional<User> findByEmailAndStatus(String email, boolean status);
    Optional<User> findByPhoneNumberAndStatus(String phoneNumber, boolean status);
    List<User> findAllByStatus(boolean status);

}