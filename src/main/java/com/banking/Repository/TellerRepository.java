package com.banking.Repository;

import com.banking.Model.Teller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TellerRepository extends JpaRepository<Teller,Integer> {
}
