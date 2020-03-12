package com.racofix.things.data;

import java.util.List;
public class RemoteDataRepository implements IDataRepository {

    private static IDataRepository repository;
    private final LocalDataRepository localRepo;

    public static IDataRepository getInstance(LocalDataRepository localRepo) {
        if (repository == null)
            synchronized (IDataRepository.class) {
                if (repository == null) repository = new RemoteDataRepository(localRepo);
            }
        return repository;
    }

    private RemoteDataRepository(LocalDataRepository localRepo) {
        this.localRepo = localRepo;
    }

    @Override
    public void devices(DataCallback<List<String>> cb1) {
        /*Http Request Callback*/

        /*
         * 1.response callback
         *  >>  cb1.data(data);
         *
         * 2.结果数据放入本地
         * >>   runOnBackgroundThread(() -> localRepo.putDevices(body));
         * */

//        Http.api().enqueue(new Callback<String>() {
//            void onResponse(String data) {
//                cb1.data(data);
//            }
//        });
    }
}
