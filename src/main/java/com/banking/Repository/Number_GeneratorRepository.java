package com.banking.Repository;

import com.banking.Model.Number_Generator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Number_GeneratorRepository extends JpaRepository<Number_Generator,Integer> {
}
