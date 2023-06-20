package local.kz.java11mvc.facade;

import java.util.List;

public interface ObjectAccessFacade {
    <T> List<T> getAll(T t);
    <T> void create(T t);
    <T> void delete(T t);
    <T,U> U find(T t);
    <T> void update(T t);
}
