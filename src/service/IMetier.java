package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IMetier <T>{
    void add(T o);
    void saveAll() throws IOException;
    List<T> getAll() throws IOException, ClassNotFoundException;
    T findById(long id);
    void delete(long id);
}
