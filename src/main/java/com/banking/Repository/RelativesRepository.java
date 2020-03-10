package com.banking.Repository;

import com.banking.Model.Relative_Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelativesRepository extends JpaRepository<Relative_Nominee, Integer> {

}
