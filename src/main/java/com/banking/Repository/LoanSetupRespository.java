package com.banking.Repository;

import com.banking.Model.Loan_Setup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanSetupRespository extends JpaRepository<Loan_Setup,Integer> {
}
