package local.kz.java11mvc.mapper;

import local.kz.java11mvc.dto.UserDTO;
import local.kz.java11mvc.models.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client mapToEntity(UserDTO userDTO){
        return new Client(userDTO.getClientId(), userDTO.getClientName(), userDTO.getClientSurname(), userDTO.getClientEmail());
    }
    public UserDTO mapToDTO(Client client){
        return new UserDTO(client.getClientId(), client.getClientName(), client.getClientSurname(), client.getClientEmail());
    }
}
