package local.kz.java11mvc.services.Impl;

import local.kz.java11mvc.models.Client;
import java.util.List;
public interface ClientRepository {
    List<Client> findAll();
    void create(Client client);
    Client findById(Long id);
    void update(Client client);
    void deleteById(Long id);
}
