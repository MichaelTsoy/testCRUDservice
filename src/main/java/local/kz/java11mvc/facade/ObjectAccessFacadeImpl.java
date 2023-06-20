package local.kz.java11mvc.facade;

import local.kz.java11mvc.mapper.*;
import local.kz.java11mvc.dto.PaperDTO;
import local.kz.java11mvc.dto.UserDTO;
import local.kz.java11mvc.services.Impl.ClientRepository;
import local.kz.java11mvc.services.Impl.PaperRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ObjectFacadeImpl implements ObjectFacade{
    private ClientRepository clientRepository;
    private PaperRepository paperRepository;
    private ShowAllUsersMapper showAllUsersMapper;
    private ClientMapper clientMapper;
    private PaperMapper paperMapper;
    public ObjectFacadeImpl(ClientRepository clientRepository, PaperRepository paperRepository, ShowAllUsersMapper showAllUsersMapper, ClientMapper clientMapper, PaperMapper paperMapper){
        this.clientRepository = clientRepository;
        this.paperRepository = paperRepository;
        this.showAllUsersMapper = showAllUsersMapper;
        this.clientMapper = clientMapper;
        this.paperMapper = paperMapper;
    }
    public <T> List<T> getAll(T t){
        if(t.getClass().equals(UserDTO.class)){
            List<UserDTO> list = new ArrayList<>();
            clientRepository.findAll().stream().forEach(e -> list.add(clientMapper.mapToDTO(e)));
        return (List<T>)list;
        }
        if(t.getClass().equals(PaperDTO.class)){
            List<PaperDTO> list = new ArrayList<>();
            paperRepository.findAll().stream().forEach(e->list.add(paperMapper.mapToDTO(e)));
            return (List<T>)list;
        }
        return null;
    }
//    public List<ShowAllUsersDTO> showAllUsers(){
//        List<UserDTO> list1 = new ArrayList<>();
//        List<PaperDTO> list2 = new ArrayList<>();
//
//        clientRepository.findAll().stream().forEach((e)-> {
//            list1.add(clientMapper.mapToDTO(e));
//        });
//        paperRepository.findAll()
//                .stream()
//                .forEach((c)->
//                        list2.add(paperMapper.mapToDTO(c)));
//        return showAllUsersMapper.map(list1, list2);
//    }
    public <T> void update(T t){
        if(t.getClass().equals(UserDTO.class)){clientRepository.update(clientMapper.mapToEntity((UserDTO)t));}
        if(t.getClass().equals(PaperDTO.class)){paperRepository.update(paperMapper.mapToEntity((PaperDTO)t));}
    }
    public <T> void delete(T t, Long id){
        if(t.getClass().equals(UserDTO.class)){clientRepository.deleteById(id);}
        if(t.getClass().equals(PaperDTO.class)){paperRepository.deleteById(id);}
    }

    @Override
    public <T> void create(T t) {
        if(t.getClass().equals(UserDTO.class)){clientRepository.create(clientMapper.mapToEntity((UserDTO)t));}
        if(t.getClass().equals(PaperDTO.class)){paperRepository.create(paperMapper.mapToEntity((PaperDTO)t));}
    }
    public <T, U> U find(T t, Long id){
        if(t.getClass().equals(UserDTO.class)){
            return (U)(clientRepository.findById(id));}
        if(t.getClass().equals(PaperDTO.class)){
            return (U)paperRepository.findById(id);}
        return null;
    }
}
