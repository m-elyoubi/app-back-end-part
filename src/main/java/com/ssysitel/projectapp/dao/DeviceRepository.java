package com.ssysitel.projectapp.dao;


import com.ssysitel.projectapp.dto.OrderResponse;
import com.ssysitel.projectapp.dto.SizeTables;
import com.ssysitel.projectapp.model.DeviceId;
import com.ssysitel.projectapp.model.Devices;
import com.ssysitel.projectapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Devices, DeviceId> {

    @Query("select d from Devices d where d.id like :id_device")
    public Long findByIdDevice(@Param("id_device") String id_device);
    @Query("select d from Devices d where d.accounts.id like :id_account")
    public List<Devices> getDeviceByIdAccount(@Param("id_account") String id_account);
    @Query("select d from Devices d where d.users.id in :id_user")
    public List<Devices> getDeviceByIdUser(@Param("id_user") Long id_user);
    @Query("select d from Devices d where d.module like:m")
    public List<Devices> findByModuleDevice(@Param("m") String module);

    @Query("select d from Devices d where (d.accounts.id like :id_account and d.users.id in :id_user) ")
    public List<Devices> getDeviceByIdAccountAndIdUser(@Param("id_account") String id_account,@Param("id_user") Long id_user);

   @Query("select count(d.id) from Devices d ")
   public Integer countDevices();

    @Query("select count(d.id) from Devices d where d.position='Park' ")
    public Long TotalDevicesPark();  // total device there are in the park

    @Query("select count(d.id) from Devices d where d.position='Market' ")
    public long TotalDevicesMarket();  // total device there are in the market

   @Query("select new com.ssysitel.projectapp.dto.OrderResponse( a.id,a.ContactName,COUNT(d.accounts.id)  ) from Devices d join d.accounts a group by d.accounts.id order by COUNT(d.accounts.id) DESC")
   public List<OrderResponse> countRepeatAccountInDevice();

}

/*
SELECT  devices.id,accounts.contact_name,COUNT(devices.id_accounts) as TotalRepetation
FROM `devices` JOIN accounts
on accounts.id=devices.id_accounts
GROUP BY devices.id_accounts
ORDER by TotalRepetation DESC;
//----------------------------------------------- GET SIZES OF TABLES ------------
SELECT table_name as `TABLES` , round(((data_length + index_length) / 1024 / 1024), 2) `Size in MB`
FROM information_schema.TABLES
 WHERE table_schema = "db_users1" AND table_name in ("users","accounts","devices");
 */
