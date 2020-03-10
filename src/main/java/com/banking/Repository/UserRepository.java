package com.banking.Repository;

import com.banking.Model.Customer;
import com.banking.Model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,String> {

    @Query(value="SELECT * FROM users WHERE archived = 'True' ",nativeQuery = true)
    public  List<Users> ArchivedUser();

    @Query(value="SELECT * FROM users WHERE archived = 'false' AND first_name <> 'admin'",nativeQuery = true)
    public  List<Users> UnArchivedUsers();
    
    @Query(value="SELECT * FROM users WHERE username =?1")
    public  Users findbyusername(String username);
    
}
