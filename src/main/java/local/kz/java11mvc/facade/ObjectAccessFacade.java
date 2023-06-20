package local.kz.java11mvc.facade;

import local.kz.java11mvc.dto.ShowAllUsersDTO;
import local.kz.java11mvc.dto.ShowDTO;
import local.kz.java11mvc.models.Paper;

import java.util.List;

public interface ObjectFacade {
    <T> List<T> getAll(T t);
//    List<ShowAllUsersDTO> showAllUsers();
    <T> void create(T t);
//    <T> void update(T t);
    <T> void delete(T t, Long id);
    <T,U> U find(T t, Long id);
}
