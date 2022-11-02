package com.ssysitel.projectapp.service;

import com.ssysitel.projectapp.dao.UserRepository;
import com.ssysitel.projectapp.model.UserID;
import com.ssysitel.projectapp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private Users user=null;
    private List<Users> listUser=null;

    public Users saveUser(Users user) throws Exception {
        if (user!=null)
            return userRepository.save(user);
        else
           throw new Exception("can't save user because user is  null");
    }
    public Users fetchUserByEmail(String email) throws Exception {
         if (email!=null || !"".equals(email)) {
             this.user = userRepository.findByEmail(email);
             if (this.user == null)
                 throw new Exception("can't found user has email=" + email);
             return this.user;
         }
         else
             throw new Exception(" email user is empty or null");
    }
   public Users fetchUserByEmailAndPassword(String email,String password) throws Exception {
        if (email!=null || !"".equals(email) && password!=null|| !"".equals(password)) {
            this.user = userRepository.findByEmailAndPassword(email, password);
            if (this.user == null)
                throw new Exception("can't found user has email" + email + " and  password" + password);
            return this.user;
        }
        else
            throw new Exception(" user has email or  password  is  empty or null");

   }

   public List<Users> getUsers() throws Exception {

        listUser=userRepository.findAll();
        if (listUser!=null)
            return userRepository.findAll();
        else
            throw new Exception("can't get all users because users are  null or not found in database");
   }
   public List<Users> findByNameUsers(String name) throws Exception {

        if (name!=null || !"".equals(name)) {
            listUser= this.userRepository.findByUsername(name);
            if ( listUser== null)
                throw new Exception("can't found user has this name"+name);

            return listUser;
        }
        else
            throw new Exception("name user="+name+" is empty or null");
    }
   public List<Users> findByPhoneUsers(String phone) throws Exception {
       if (phone!=null || !"".equals(phone)) {
           listUser=this.userRepository.findByNumberOfPhone(phone);
           if ( listUser== null)
               throw new Exception("can't found user has this phone"+phone);
           return listUser;
       }
       else
           throw new Exception("phone user ="+phone+" is empty or null");

    }
   public List<Users> findByEmailUsers(String email) throws Exception {

        if (email != null || !"".equals(email)) {
            listUser=this.userRepository.findByEmailUsers(email);
           if (listUser== null)
               throw new Exception("can't found user has this email" + email);
            return listUser;
        }
        else
            throw new Exception("user has email empty or null");
       }
   public Users ActiveUser(Users u,Integer id) throws Exception {
       if (u != null || id!=null) {
           u.setUserID(id);
           if( userRepository.save(u)==null)
           throw new Exception("can't found this user"+u+" has this id"+id);

           return userRepository.save(u);
       }
       else
           throw new Exception("user is null or  id is empty");
    }
   public Optional<Users> getUserById(UserID id) throws Exception {
       if (id!=null) {
           if (userRepository.findById(id)!=null)
               return userRepository.findById(id);
           else
               throw new Exception("can't found this user has  id"+id);
       }
       else
           throw new Exception("id is empty");
    }
    public boolean deleteUser(UserID id) throws Exception {

        if (id!=null){
            userRepository.deleteById(id);
                return true;
        }
        else
            throw new Exception("id is empty");

    }
    public List<Users> getUserByIdAcc(String id_account) throws Exception {
        if (id_account != null && !"".equals(id_account)) {
            listUser = this.userRepository.getUserByIdAcc(id_account);
            if (listUser != null)
                return listUser;
            else
                throw new Exception("user is null");
        } else
             throw new Exception("can't get this user has "+id_account);
    }
   public Users updateUser(Users u,Integer id) throws Exception {
       if (u!=null && id!=null) {
           u.setUserID(id);
           user= userRepository.save(u);
           if (user==null)
               throw new Exception("can't found this user because null"+id);
           return user;
       }
       else
           throw new Exception(" user is null or id is empty");

    }

    public int countUsers() throws Exception {
          Integer count=userRepository.CountUser();
          if (count!=null)
              return count;
          else
              throw new Exception(" there are no users");
    }
}
