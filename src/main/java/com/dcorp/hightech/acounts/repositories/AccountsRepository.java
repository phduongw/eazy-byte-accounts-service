package com.dcorp.hightech.acounts.repositories;

import com.dcorp.hightech.acounts.entities.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsEntity, Long> {



}
