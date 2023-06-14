package local.kz.java11mvc.facade;

import local.kz.java11mvc.mapper.ClientMapper;
import local.kz.java11mvc.mapper.CombinatedMapper;
import local.kz.java11mvc.mapper.PaperMapper;
import local.kz.java11mvc.dto.PaperDTO;
import local.kz.java11mvc.dto.ShowDTO;
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
    private CombinatedMapper combinatedMapper;
    private ClientMapper clientMapper;
    private PaperMapper paperMapper;
    public ObjectFacadeImpl(ClientRepository clientRepository, PaperRepository paperRepository, CombinatedMapper combinatedMapper, ClientMapper clientMapper, PaperMapper paperMapper){
        this.clientRepository = clientRepository;
        this.paperRepository = paperRepository;
        this.combinatedMapper = combinatedMapper;
        this.clientMapper = clientMapper;
        this.paperMapper = paperMapper;
    }
    public List<ShowDTO> getAll(){

        List<UserDTO> list1 = new ArrayList<>();
        List<PaperDTO> list2 = new ArrayList<>();

        clientRepository.findAll().stream().forEach((e)-> list1.add(clientMapper.mapToDTO(e)));
        paperRepository.findAll().stream().forEach((e)-> list2.add(paperMapper.mapToDTO(e)));


        return combinatedMapper.map(list1, list2);
    }
}
