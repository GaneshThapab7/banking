package com.banking.Repository;

import com.banking.Model.Customer;
import com.banking.Model.users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<users,String> {

    @Query(value="SELECT * FROM users WHERE archived = 'True' ",nativeQuery = true)
    public  List<users> ArchivedUser();

    @Query(value="SELECT * FROM users WHERE archived = 'false' AND first_name <> 'admin'",nativeQuery = true)
    public  List<users> UnArchivedUsers();
    
    @Query(value="select t from users t where t.username=?1")
    public  users findbyUserName(String username);
   
    
}
