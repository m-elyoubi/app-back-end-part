package com.ssysitel.projectapp.controller;

import com.ssysitel.projectapp.dao.AccountRepository;
import com.ssysitel.projectapp.model.Accounts;
import com.ssysitel.projectapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins ="http://localhost:4200")
@RestController

public class AccountController {

    @Autowired
    private AccountService accountService;

   @RequestMapping(value = "/accounts",method = RequestMethod.GET)
    public List<Accounts> getAllAccounts() throws Exception {

        return accountService.getAllAccounts();
    }

    @RequestMapping(value = "/getAlIdAccount",method = RequestMethod.GET)
    public List<String> getAllIdAccounts() throws Exception {

        return accountService.getAllIdAccounts();
    }

    @RequestMapping(value = "/searchByNameAcc",method = RequestMethod.GET)
    public List<Accounts> searchByNameAccount(@RequestParam(name = "name",defaultValue = "") String name) throws Exception {

        return accountService.searchByNameAccount("%"+name+"%");
    }

    @RequestMapping(value = "/searchByPhoneAcc",method = RequestMethod.GET)
    public List<Accounts> searchByPhoneAccount(@RequestParam(name = "phone",defaultValue = "") String phone) throws Exception {
        return accountService.searchByPhoneAccount("%"+phone+"%");
    }

    @RequestMapping(value = "/saveAccount",method = RequestMethod.POST)
    public Accounts saveAccount(@RequestBody Accounts a) throws Exception {

        return accountService.saveAccount(a);
    }

    @RequestMapping(value = "/activeAccount/{id}",method = RequestMethod.PUT)
    public Accounts activeAccount(@RequestBody Accounts a,@PathVariable String id) throws Exception {
        return accountService.activeAccount(a,id);
    }

    @DeleteMapping(value = "/accounts/{id}")
    public boolean deleteAccount(@PathVariable String id) throws Exception {
       return accountService.deleteAccount(id);
    }

    @GetMapping(value = "/accounts/{id}")
    public Accounts getAccountById(@PathVariable String id) throws Exception {
       return  accountService.getAccountById(id);

    }

    @PutMapping(value = "/accountUpdate/{id}")
    public Accounts updateAccountById(@RequestBody Accounts a,@PathVariable String id) throws Exception {
        return  accountService.updateAccountById(a,id);
    }

    @GetMapping(value = "/countAccounts")
    public int countAccounts() throws Exception {
        return  accountService.countAccounts();

    }

}


/*
    @RequestMapping(value = "/accountsWithUser",method = RequestMethod.GET)
    public List<OrderResponse> getAccountWithUser()
    {

        return accountRepository.getJoinInfo();
    }

 */