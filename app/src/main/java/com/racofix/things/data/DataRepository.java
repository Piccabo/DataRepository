package com.racofix.things.data;

import java.util.List;

import static com.racofix.things.data.ThreadLocalExecutor.runOnBackgroundThread;
import static com.racofix.things.data.ThreadLocalExecutor.runOnUIThread;

public class DataRepository implements IDataRepository {

    private final LocalDataRepository localRepo;
    private final IDataRepository remoteRepo;
    private static IDataRepository repository;

    public static IDataRepository getInstance() {
        if (repository == null)
            synchronized (IDataRepository.class) {
                if (repository == null) {
                    LocalDataRepository localRepo = LocalDataRepository.getInstance();
                    IDataRepository remoteRepo = RemoteDataRepository.getInstance(localRepo);
                    repository = new DataRepository(localRepo, remoteRepo);
                }
            }
        return repository;
    }

    private DataRepository(LocalDataRepository localRepo, IDataRepository remoteRepo) {
        this.localRepo = localRepo;
        this.remoteRepo = remoteRepo;
    }

    @Override
    public void devices(DataCallback<List<String>> cb1) {
        runOnBackgroundThread(() ->
                localRepo.devices(data ->
                        runOnUIThread(() ->
                                cb1.data(data))));

        remoteRepo.devices(cb1);
    }
}
