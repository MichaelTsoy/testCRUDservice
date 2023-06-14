package local.kz.java11mvc.services.Impl;

import local.kz.java11mvc.models.Client;
import local.kz.java11mvc.repository.ClientDAORepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ClientRepositoryImpl implements ClientRepository {
    private ClientDAORepository clientDAORepository;

    public ClientRepositoryImpl(ClientDAORepository clientDaoRepository) {
        this.clientDAORepository = clientDaoRepository;
    }

    public List<Client> findAll() {
        return clientDAORepository.findAll();
    }

}


