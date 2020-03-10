package com.banking.Repository;

import com.banking.Model.Loan_Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanCustomerRepository extends JpaRepository<Loan_Customer,String> {

}
