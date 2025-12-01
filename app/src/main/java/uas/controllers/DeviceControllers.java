package uas.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import uas.models.Device;
import uas.models.IDeviceController;

public class DeviceControllers implements IDeviceController{
    private ArrayList<Device> listDevices;

    public DeviceControllers(){
        this.listDevices = new ArrayList<>();
    }

    public ArrayList<Device> getAllDevice(){
        return this.listDevices;
    }

    public void addDevice(Device device){
        this.listDevices.add(device);
    }

    public void sortByOS(){
        //List< listSort = new ArrayList<>(listDevices);
        this.listDevices.sort( (a, b) -> {return -1 * a.compareTo(b);});
    }
}
