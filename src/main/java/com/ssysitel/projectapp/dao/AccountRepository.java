package com.ssysitel.projectapp.dao;
import com.ssysitel.projectapp.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface AccountRepository extends JpaRepository<Accounts,String> {

    @Query("select a from Accounts a where a.name like:x")
    public List<Accounts> findByName(@Param("x") String name);
    @Query("select a from Accounts a where a.numberOfPhone like:x")
    public List<Accounts> findByPhone(@Param("x") String phone);
    @Query("select a.id from Accounts a")
    public List<String> getIdAccount();
    @Query("select count(a.id) from Accounts a")
    public Integer countAccounts();
}
