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
public class ObjectAccessFacadeImpl implements ObjectAccessFacade {
    private ClientRepository clientRepository;
    private PaperRepository paperRepository;
    private ClientMapper clientMapper;
    private PaperMapper paperMapper;
    public ObjectAccessFacadeImpl(ClientRepository clientRepository, PaperRepository paperRepository, ClientMapper clientMapper, PaperMapper paperMapper){
        this.clientRepository = clientRepository;
        this.paperRepository = paperRepository;
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
    public <T> void update(T t){
        if(t.getClass().equals(UserDTO.class)){clientRepository.update(clientMapper.mapToEntity((UserDTO)t));}
        if(t.getClass().equals(PaperDTO.class)){paperRepository.update(paperMapper.mapToEntity((PaperDTO)t));}
    }
    public <T> void delete(T t){
        if(t.getClass().equals(UserDTO.class)){clientRepository.deleteById(((clientMapper.mapToEntity((UserDTO)t)).getClientId()));}
        if(t.getClass().equals(PaperDTO.class)){paperRepository.deleteById(((paperMapper.mapToEntity((PaperDTO)t)).getPaperId()));}
    }

    @Override
    public <T> void create(T t) {
        if(t.getClass().equals(UserDTO.class)){clientRepository.create(clientMapper.mapToEntity((UserDTO)t));}
        if(t.getClass().equals(PaperDTO.class)){paperRepository.create(paperMapper.mapToEntity((PaperDTO)t));}
    }
    public <T, U> U find(T t){
        if(t.getClass().equals(UserDTO.class)){
            return (U)(clientRepository.findById(clientMapper.mapToEntity((UserDTO)t).getClientId()));}
        if(t.getClass().equals(PaperDTO.class)){
            return (U)paperRepository.findById(paperMapper.mapToEntity((PaperDTO)t).getPaperId());}
        return null;
    }
}
