package com.racofix.things.data;

import java.util.List;

public class LocalDataRepository implements IDataRepository, LocalStore {

    private static LocalDataRepository repository;
//    private final Box<Device> deviceBox;

    public static LocalDataRepository getInstance() {
        if (repository == null)
            synchronized (IDataRepository.class) {
                if (repository == null) repository = new LocalDataRepository();
            }
        return repository;
    }

    private LocalDataRepository() {
//        this.deviceBox = App.getBox(Device.class);
    }

    @Override
    public void devices(DataCallback<List<String>> cb1) {
//        List<Device> devices = deviceBox
//                .query()
//                .equal(Device_.u_mobile, AccountHawk.getMobile())
//                .build()
//                .find();
//        if (cb1 != null && !devices.isEmpty()) cb1.data(devices);
    }

    @Override
    public void putDevices(List<String> devices) {
//        deviceBox.put(devices);
    }
}
