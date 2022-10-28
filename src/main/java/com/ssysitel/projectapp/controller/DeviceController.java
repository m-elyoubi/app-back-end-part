package com.ssysitel.projectapp.controller;

import com.ssysitel.projectapp.dao.DeviceRepository;
import com.ssysitel.projectapp.dto.OrderResponse;
import com.ssysitel.projectapp.dto.SizeTables;
import com.ssysitel.projectapp.model.Devices;
import com.ssysitel.projectapp.model.Users;
import com.ssysitel.projectapp.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="http://localhost:4200")
@RestController

public class DeviceController {
    @Autowired
    private DeviceService deviceService;



    @GetMapping(value = "/devices")
    public List<Devices> getAllDevices() throws Exception {
        return deviceService.getAllDevices();
    }

    @GetMapping(value = "/devicesByIdAccount")
    public List<Devices> getDeviceByIdAcc(@RequestParam(name = "id_account",defaultValue = "") String id_account) throws Exception {

        return deviceService.getDeviceByIdAcc(id_account);
    }

    @GetMapping(value = "/devicesByIdAccountIdUser")
    public List<Devices> getDeviceByIdAccAndIdUser(@RequestParam(name = "id_account",defaultValue = "") String id_account,@RequestParam(name = "id_user",defaultValue = "") Long id_user) throws Exception {

        return deviceService.getDeviceByIdAccAndIdUser(id_account,id_user);
    }

    @GetMapping(value = "/getDeviceByIdUser")
    public List<Devices> getDeviceByIdUser(@RequestParam(name = "id_user",defaultValue = "") Long id_user) throws Exception {

        return deviceService.getDeviceByIdUser(id_user);
    }

    @PutMapping(value = "/devices/{id}")
    public Devices activeDevice(@RequestBody Devices device,@PathVariable Long id) throws Exception {

        return deviceService.ActiveDevice(device,id);
    }

    @RequestMapping(value = "/devices/{id}",method = RequestMethod.GET)
    public Optional<Devices> getDeviceById(@PathVariable Long id) throws Exception {

        return deviceService.getDeviceById(id);
    }

    @RequestMapping (value = "/devices/{id}",method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Long id) throws Exception {
      return  deviceService.delete(id);
    }

    @RequestMapping(value = "/updateDevice/{id}",method = RequestMethod.PUT)
    public Devices updateDevice(@RequestBody Devices d, @PathVariable Long id) throws Exception {
        return deviceService.updateDevice(d,id);
    }

    @RequestMapping(value = "/searchByModule",method = RequestMethod.GET)
    public List<Devices> searchByModule(@RequestParam(name = "module",defaultValue = "") String module) throws Exception {
        return deviceService.searchByModule("%"+module+"%");
    }

    @RequestMapping(value = "/saveDevice",method = RequestMethod.POST)
    public Devices saveAccount(@RequestBody Devices d) throws Exception {

        return deviceService.saveAccount(d);
    }

    @GetMapping(value = "/countDevices")
    public int countDevices() throws Exception {

        return deviceService.countDevices();
    }

    @GetMapping(value = "/countAccDevices")
    public List<OrderResponse> countAccountOfDevice() throws Exception {

        return deviceService.countAccountOfDevice();
    }

    @GetMapping(value = "/deviceParkAndMarket")
      public List<Long> totalDeviceParkAndMarket() throws Exception {
        // percentage of devices in ( market and park)
        return   deviceService.totalDeviceFindParkAndMarket();
      }

    @GetMapping(value = "/userAccountDevice")
    public List<SizeTables> countNumberOfUserAndAccountAndDevice() throws Exception {
        return   deviceService.countUserAccountDevice();
    }

}
