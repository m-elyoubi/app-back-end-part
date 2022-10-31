package com.ssysitel.projectapp;

import com.ssysitel.projectapp.dao.AccountRepository;
import com.ssysitel.projectapp.dao.DeviceRepository;
import com.ssysitel.projectapp.dto.SizeTables;
import com.ssysitel.projectapp.model.*;
import com.ssysitel.projectapp.dao.UserRepository;
import com.ssysitel.projectapp.service.AccountService;
import com.ssysitel.projectapp.service.DeviceService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class ProjectAppApplication implements CommandLineRunner{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private DeviceService deviceService;

    public static void main(String[] args) {
        SpringApplication.run(ProjectAppApplication.class, args);
        // --------------------------------------------
    }
    @Override
    public void run(String... args) throws Exception {
        // --------------------------      Test for class Accounts     --------------------------

       Accounts account1=new Accounts("zouhir","sysadmin","06575849",new Date(2030),new Date(),"1234",true);
        Accounts account2=new Accounts("user","mouhcin","0745372896",new Date(2026),new Date(),"1234f",false);
        Accounts account3=new Accounts("admin","farida","0712345670",new Date(2020),new Date(),"1234fr",true);
        Accounts account4=new Accounts("admin","ghizlane","0679076323",new Date(2022),new Date(),"1234g",true);
        Accounts account5=new Accounts("ibm","nourdine","0667924608",new Date(2024),new Date(),"1234n",false);
        Accounts account6=new Accounts("admin","admin","0608543423",new Date(2023),new Date(),"1234m",true);
        accountService.saveAccount(account1);
        accountService.saveAccount(account2);
        accountService.saveAccount(account3);
       /* accountService.saveAccount(account4);
        accountService.saveAccount(account5);
        accountService.saveAccount(account6);*/


    // --------------------------    Test for class Users       --------------------------
    Users u1=new Users( 1L,"admin","zouhir","123z","0667-325948","zouhir.elkhalfi@usmba.ac.ma","Zouhir","admin",true);
    Users u2=new Users(2L,"user","mouhcin","123m","0629-509243","mouhcin.elyoubi@uit.ac.ma","Mouhcin","admin",true);
    Users u3=new Users(3L,"admin","youssef","youssef","0671-743114","youssef.boujydah@ensao.ac.ma","Youssef","user",true);
    /* Users u4=new Users(new UserID(4L,"admin"),"radia", "123r","0653-914981","radia.elouardi@usmba.ac.ma","Radia","user",false);
    Users u5=new Users(new UserID(5L,"admin"),"ziyad", "123z","0723-456789","ziyad.el@gmail.com","Ziyad","user",false);
    Users u6=new Users(new UserID(6L,"MOUHCIN"),"mouhcin","123e","0629-509243","elyoubimouhcine4@gmail.com","Mouhcin","user",true);
     */
        userRepository.save(u1);

        userRepository.save(u2);
        userRepository.save(u3);
       /* userRepository.save(u4);


        userRepository.save(u5);
       userRepository.save(u6);
        System.out.println("Count users "+userRepository.CountUser());

           */


    // --------------------------      Test for class Vehicles     --------------------------
/*
        Devices vehicle1=new Devices(new DeviceId(1L,1L,"admin"),"DACIA","FBM","Market",240,true);
        Devices vehicle2=new Devices(new DeviceId(2L,2L,"user"),"range-rover","FMA","Market",350,true);
        Devices vehicle3=new Devices(new DeviceId(3L,3L,"admin"),"4x4","BFMA","Market",300,false);
        Devices vehicle4=new Devices(new DeviceId(4L,4L,"admin"),"mercedes benz","FMAB","Park",200,false);
      */
 /* Devices vehicle5=new Devices(new DeviceId(5L,"user"),"Volvo S60","FMA","Park",180,true);
        Devices vehicle6=new Devices(new DeviceId(6L,"admin"),"Land Rover","MFA","Park",330,false);
        Devices vehicle7=new Devices(new DeviceId(7L,"admin"),
                "PICKUP TRUCK","MFA","Market",210,true);
        Devices vehicle8=new Devices(new DeviceId(8L,"user")," Honda Ridgeline","MFA","Market",250,true);
        Devices vehicle9=new Devices(new DeviceId(9L,"admin"),
                "MINIVAN","MFA","Park",270,true);

        deviceRepository.save(vehicle1);
        deviceRepository.save(vehicle2);
        deviceRepository.save(vehicle3);
        deviceRepository.save(vehicle4);
      /*  deviceRepository.save(vehicle5);
       deviceRepository.save(vehicle6);
       deviceRepository.save(vehicle7);
       deviceRepository.save(vehicle8);
       deviceRepository.save(vehicle9);



       System.out.println("Count Account in device "+ deviceRepository.countRepeatAccountInDevice());
       System.out.println("Count Account in device "+ deviceRepository.countRepeatAccountInDevice());

          List<Long> list=deviceService.totalDeviceFindParkAndMarket();
          for(long l:list)
              System.out.println(l);
        List<SizeTables> l=deviceService.countUserAccountDevice();
        for(SizeTables lis:l)
            System.out.println(lis);
            */


}


}
