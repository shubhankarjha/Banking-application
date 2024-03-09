package net.javaguides.banking.app.repository;

import net.javaguides.banking.app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository< Account,Long> {
}
