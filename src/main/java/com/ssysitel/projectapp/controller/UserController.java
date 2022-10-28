package com.ssysitel.projectapp.controller;

import com.ssysitel.projectapp.model.Users;
import com.ssysitel.projectapp.dao.UserRepository;
import com.ssysitel.projectapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration")
    public Users registerUser(@RequestBody Users user) throws Exception {
        String userEmail=user.getEmail();
        Users userData=null;
        if (userEmail!=null && !"".equals(userEmail)) {
            userData = userService.fetchUserByEmail(userEmail);

            if (userData != null)
                throw new Exception(" user with " + userEmail + " is already exist");

        }
       userData=userService.saveUser(user);
       return userData;
    }

    @PostMapping(value = "/login")
    public Users Login(@RequestBody Users user) throws Exception {
        String em=user.getEmail();
        String pw=user.getPassword();
        Users userData=null;
        if (em!=null && pw!=null)
        {
            userData=userService.fetchUserByEmailAndPassword(em,pw);

        }
        if (userData==null) {
            throw new Exception("Bad credentials");
        }
        return userData;

     }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<Users> getUsers() throws Exception {
        return userService.getUsers();
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public Optional<Users> getUserById(@PathVariable("id") Long id) throws Exception {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/searchName")
    public List<Users> searchByNameUser(@RequestParam(name = "name",defaultValue = "") String name) throws Exception {
        return userService.findByNameUsers("%"+name+"%");
    }

    @GetMapping(value = "/searchPhone")
    public List<Users> searchByPhoneUser(@RequestParam(name = "phone",defaultValue = "") String phone) throws Exception {
        return userService.findByPhoneUsers("%"+phone+"%");
    }

    @GetMapping(value = "/searchEmail")
    public List<Users> searchByEmailUser(@RequestParam(name = "email",defaultValue = "") String emailu) throws Exception {
        return userService.findByEmailUsers("%"+emailu+"%");
    }

    @RequestMapping (value = "/users/{id}",method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable Long id) throws Exception {
     return userService.deleteUser(id);
    }

    @RequestMapping(value = "/products/{id}",method = RequestMethod.PUT)
    public Users activeUser(@RequestBody Users u,@PathVariable Long id) throws Exception {

        return this.userService.ActiveUser(u,id);
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.PUT)
    public Users updateUser(@RequestBody Users u,@PathVariable Long id) throws Exception {
        return this.userService.updateUser(u,id);
    }

    @PostMapping (value = "/saveUsers")
    public Users saveUser(@RequestBody Users user) throws Exception {
       return  this.userService.saveUser(user);
    }

    @GetMapping(value = "/getUserByAccount")
    public List<Users> getUserByIdAcc(@RequestParam(name = "id_account",defaultValue = "") String id_account) throws Exception {
        return userService.getUserByIdAcc(id_account);
    }

    @GetMapping (value = "/countUsers")
    public int countUsers() throws Exception {
        return  userService.countUsers();

    }
}
