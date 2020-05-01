package com.project.projet_jee.reporsitories;

import com.project.projet_jee.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {


}
