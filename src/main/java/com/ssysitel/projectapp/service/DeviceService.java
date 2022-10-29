package com.ssysitel.projectapp.service;

import com.ssysitel.projectapp.dao.AccountRepository;
import com.ssysitel.projectapp.dao.DeviceRepository;
import com.ssysitel.projectapp.dao.UserRepository;
import com.ssysitel.projectapp.dto.OrderResponse;
import com.ssysitel.projectapp.dto.SizeTables;
import com.ssysitel.projectapp.model.DeviceId;
import com.ssysitel.projectapp.model.Devices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Repository  // for instance au demarage

public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;
    private Devices devices;
    private List<Devices> listDevice;


    public List<Devices> getAllDevices() throws Exception {

        listDevice = deviceRepository.findAll();
        if (listDevice != null)
            return listDevice;
        else
            throw new Exception("can't get any devices from database because it is null");
    }
    public List<Devices> getDeviceByIdAcc(String id_account) throws Exception {
        if (id_account != null || !"".equals(id_account)) {
            listDevice= deviceRepository.getDeviceByIdAccount(id_account);
            if (listDevice!=null)
                return listDevice;
            else
                throw new Exception("can't found any device has "+id_account+"from database because ");
        }
        else
            throw new Exception("id account is null or empty");
    }
    public List<Devices> getDeviceByIdAccAndIdUser(String id_account, Long id_user) throws Exception {
        if (id_account != null || !"".equals(id_account) && id_user!=null) {
            listDevice= deviceRepository.getDeviceByIdAccountAndIdUser(id_account, id_user);
            if (listDevice!=null)
                return listDevice;
            else
                throw new Exception("can't get device by id account and id user from database because it is null ");
        }
        else
            throw new Exception("id account or id user is null or empty");

    }
    public List<Devices> getDeviceByIdUser(Long id_user) throws Exception {
        if (id_user != null) {
            listDevice= deviceRepository.getDeviceByIdUser(id_user);
            if (listDevice!=null)
                return listDevice;
            else
                throw new Exception("can't get device by id user from database because it is null");
        }
        else
            throw new Exception("id user is null or empty");

    }
    public Devices ActiveDevice(Devices device,Long id) throws Exception {
       if (device!=null || !"".equals(id)) {
           device.setDeviceId(id);
           devices = deviceRepository.save(device);
           if (device != null)
               return devices;
           else
               throw new Exception("can't active device because device is  null");
       }
       else
        throw new Exception("device or id device is  null");
    }
    public List<Devices> searchByModule(String module) throws Exception {
        if (module!=null || !"".equals(module)) {
            listDevice= deviceRepository.findByModuleDevice("%" + module + "%");
            if (listDevice!=null)
                return listDevice;
            else
                throw new Exception("can't found device has module"+module+"in database");
        }
        else
            throw new Exception("module device is  null");

    }
    public List<OrderResponse> countAccountOfDevice() throws Exception {

        if (deviceRepository.countRepeatAccountInDevice()!=null)
            return deviceRepository.countRepeatAccountInDevice();
        else
            throw new Exception("count Account Of Device is null");
    }
    public int countDevices() throws Exception {

        Integer count= deviceRepository.countDevices();
        if (count!=null)
            return count;
        else
            throw new Exception("there are no device in database");
    }
    public Devices saveAccount(Devices d) throws Exception {
        if (d!=null) {
            devices= deviceRepository.save(d);
            if (devices!=null)
                return devices;
            else
                throw new Exception("can't save device because it is null");
        }
        else
            throw new Exception("device is null");

    }
    public boolean delete(DeviceId id) throws Exception {
        if (id!=null || !"".equals(id)) {
            deviceRepository.deleteById(id);
            return true;}
        else
            throw new Exception("id device is  null or empty");
        }
    public Optional<Devices> getDeviceById(DeviceId id) throws Exception {
        if (id!=null || !"".equals(id)) {
            if (deviceRepository.findById(id)!=null)
                return deviceRepository.findById(id);
            else
                throw new Exception("can't found any device has id"+id+"in database");
        }
        else
            throw new Exception("id device  is  null");
    }
    public Devices updateDevice(Devices device ,Long id) throws Exception {
        if (device!=null || !"".equals(id)) {
            device.setDeviceId(id);
            devices= deviceRepository.save(device);
            if (devices!=null)
                return devices;
            else
                throw new Exception("can't update device because device is  null");
        }
        else
            throw new Exception("device or id device is  null");
    }
    public List<SizeTables> countUserAccountDevice() throws Exception { // calculate the number of users ,Accounts and devices in database
        List<SizeTables> list = new ArrayList<>();
        Integer countDevice = deviceRepository.countDevices(), countAccount = accountRepository.countAccounts(), countUser = userRepository.CountUser();
        if (countDevice != null && countAccount != null && countUser != null) {
            long[] s = {0, countDevice, countUser, countAccount, 0};
            String[] n = {"Size of DataBase", "Users", "Accounts", "Devices", "Notifications"};

            for (int i = 0; i < n.length; i++) {
                list.add(new SizeTables(n[i], s[i]));
            }
        }
        if (list == null)
            throw new Exception("there is no device in database");

        return list;

    }
    public List<Long> totalDeviceFindParkAndMarket() throws Exception {
        List<Long> list = new ArrayList<>();
        Integer countDevice = deviceRepository.countDevices();
        Long totalDevicesPark = deviceRepository.TotalDevicesPark();
        if (countDevice != null && totalDevicesPark != null) {
            list.add(totalDevicesPark * 100 / countDevice);
            list.add(deviceRepository.TotalDevicesMarket() * 100 / deviceRepository.countDevices());
        }
        if (list == null)
            throw new Exception("there is no device in database");
        return list;
    }

}
