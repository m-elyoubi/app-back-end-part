package com.ssysitel.projectapp.service;

import com.ssysitel.projectapp.dao.AccountRepository;
import com.ssysitel.projectapp.model.Accounts;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@Transactional
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    List<Accounts> listAcc = null;
    Accounts account = null;

    public List<Accounts> getAllAccounts() throws Exception {

        listAcc = accountRepository.findAll();
        if (listAcc != null)
            return listAcc;
        else
            throw new Exception("can't get all accounts accounts because account is  null");
    }

    public Accounts saveAccount(Accounts a) throws Exception {
        if (a != null) {
            a.setAccountID(UUID.randomUUID().toString());
            account = accountRepository.save(a);
            if (account != null)
                return account;
            else
                throw new Exception("there is no account in database");
        } else
            throw new Exception("Account is  null");
    }

    public Accounts activeAccount(Accounts account, String id) throws Exception {
        if (account != null && !"".equals(id)) {
            account.setAccountID(id);
            account = accountRepository.save(account);
            if (account != null)
                return account;
            else
                throw new Exception("there is no account in database");
        } else
            throw new Exception("account or id is null");

    }

    public boolean deleteAccount(String id) throws Exception {
        if (id != null) {
            accountRepository.deleteById(id);
            return true;
        } else
            throw new Exception("id account is  null");
    }

    public Accounts getAccountById(String id) throws Exception {
        if (id != null) {
            account = accountRepository.findById(id).get();
            if (account != null)
                return account;
            else
                throw new Exception("there is no account has id=" + id + " in database");
        } else
            throw new Exception("id account is  null");
    }

    public List<Accounts> searchByPhoneAccount( String phone) throws Exception {
        if (phone != null || !"".equals(phone)) {
            listAcc= accountRepository.findByPhone("%" + phone + "%");
            if (listAcc!=null)
                return listAcc;
            else
                throw new Exception("can't fount account has phone =" + phone + " in database");
        } else
            throw new Exception("phone account is  null or empty");

    }

    public List<Accounts> searchByNameAccount( String name) throws Exception {
        if (name != null || !"".equals(name)) {
            listAcc = accountRepository.findByName("%" + name + "%");
            if (listAcc!=null)
                return listAcc;
            else
                throw new Exception("can't fount account has name =" + name + " in database");
        } else
            throw new Exception("name account is  null");

    }
    public Accounts updateAccountById(Accounts a, String id) throws Exception {
        if (a != null && !"".equals(id)) {
            a.setAccountID(id);
            account = accountRepository.save(a);
            if (account != null)
                return account;
            else
                throw new Exception("there is no account has id=" + id + " in database");
        } else
            throw new Exception("id account is  null");
    }
    public int countAccounts() throws Exception {
        Integer count = accountRepository.countAccounts();
        if (count != null)
            return count;
        else
            throw new Exception("there are no accounts in database");
    }
    public List<String> getAllIdAccounts() throws Exception {
        List<String> listAccount = accountRepository.getIdAccount();
        if (listAccount != null)
            return listAccount;
        else
            throw new Exception("there is no account in database");
    }
}