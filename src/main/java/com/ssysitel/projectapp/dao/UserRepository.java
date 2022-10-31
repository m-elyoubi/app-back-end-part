package com.ssysitel.projectapp.dao;

import com.ssysitel.projectapp.model.UserID;
import com.ssysitel.projectapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface UserRepository extends JpaRepository<Users, UserID> {
    public   Users findByEmail(String email);
    public Users findByEmailAndPassword(String email,String password);
    @Query("select u from Users  u where u.accounts.id in :account ")
    public List<Users> getUserByIdAcc(@Param("account") String id_account);
   @Query("select u from Users u where u.username like:x")
   public List<Users> findByUsername(@Param("x") String name);
    @Query("select u from Users u where u.numberOfPhone like:x")
    public List<Users> findByNumberOfPhone(@Param("x") String phone);
    @Query("select u from Users u where u.email like:x")
    public List<Users> findByEmailUsers(@Param("x") String email);
    @Query("select count(u.id) from Users u")
    public Integer CountUser();
}