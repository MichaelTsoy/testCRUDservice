package local.kz.java11mvc.mapper;

import local.kz.java11mvc.dto.ShowDTO;
import local.kz.java11mvc.dto.UserDTO;
import local.kz.java11mvc.models.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client mapToEntity(ShowDTO showDTO){
        return new Client(showDTO.getClientName(), showDTO.getClientSurname(), showDTO.getClientEmail());
    }
    public UserDTO mapToDTO(Client client){
        return new UserDTO(client.getClientName(), client.getClientSurname(), client.getClientEmail());
    }
}
