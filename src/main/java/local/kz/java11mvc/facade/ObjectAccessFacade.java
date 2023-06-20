package local.kz.java11mvc.facade;

import java.util.List;

public interface ObjectAccessFacade {
    <T> List<T> getAll(T t);
    <T> void create(T t);
    <T>  T find(T t, Long id);
    <T> void update(T t);
    public <T> void delete(T t, Long id);
}
