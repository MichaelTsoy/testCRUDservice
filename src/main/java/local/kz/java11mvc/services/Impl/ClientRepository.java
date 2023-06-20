package local.kz.java11mvc.services.Impl;

import local.kz.java11mvc.models.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository {
    List<Client> findAll();
    void create(Client client);
    Client findById(Long id);
    void update(Client client);
    void deleteById(Long id);
}
