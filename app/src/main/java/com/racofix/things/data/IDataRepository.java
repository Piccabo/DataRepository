package com.racofix.things.data;

import java.util.List;
public interface IDataRepository {

    void devices(DataCallback<List<String>> cb1);
}
