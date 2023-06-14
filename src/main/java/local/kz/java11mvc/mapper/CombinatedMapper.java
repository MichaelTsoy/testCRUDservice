package local.kz.java11mvc.mapper;

import local.kz.java11mvc.dto.PaperDTO;
import local.kz.java11mvc.dto.ShowDTO;
import local.kz.java11mvc.dto.UserDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class CombinatedMapper {
    public List<ShowDTO> map(List<UserDTO> clients, List<PaperDTO> papers){
        List<ShowDTO> list = new ArrayList<>();
        papers.forEach((e)-> {
            clients.forEach((c) -> {
//                if (c.getId() == e.getClient().getClientId()) {
                if (c.equals(e.getClient())) {
                    ShowDTO showDTO = new ShowDTO(c.getName(), c.getSurname(), c.getEmail(), e.getName(), e.getContent());
                    list.add(showDTO);
                }
            });
        });
        return list;
    }
}
