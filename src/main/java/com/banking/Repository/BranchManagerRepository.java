package com.banking.Repository;

import com.banking.Model.Branch_Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchManagerRepository extends JpaRepository<Branch_Manager,Integer> {
}
