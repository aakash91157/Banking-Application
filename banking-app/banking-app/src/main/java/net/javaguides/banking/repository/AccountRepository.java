package net.javaguides.banking.repository;

import net.javaguides.banking.entity.Account;
import net.javaguides.banking.enums.ProfileStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

    List<Account> findAllByStatus(ProfileStatus status);

    Optional<Account> findByIdAndStatus(Long id, ProfileStatus status);

}
