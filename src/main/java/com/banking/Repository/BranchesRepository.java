package com.banking.Repository;

import com.banking.Model.Branches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchesRepository extends JpaRepository<Branches, String> {
    @Query(value="SELECT * FROM branches WHERE archived = 'True' ",nativeQuery = true)
    public List<Branches> archivedBranches();

    @Query(value="SELECT * FROM branches WHERE archived = 'false'",nativeQuery = true)
    public  List<Branches> unArchivedBranches();
}
