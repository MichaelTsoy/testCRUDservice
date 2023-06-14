package local.kz.java11mvc.models;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "client")
@Transactional
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="clientId")
    public long clientId;
    @NotNull
    @Column(name="clientName")
    public String clientName;
    @NotNull
    @Column(name="clientSurname")
    public String clientSurname;
    @NotNull
    @Column(name="clientEmail")
    public String clientEmail;
    @Column(name="clientPapers")
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "client")
    public List<Paper> clientPapers = new ArrayList<>();
    public Client(){
    }public Client(String clientName, String clientSurname, String clientEmail){
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public List<Paper> getClientPapers() {
        return clientPapers;
    }

    public void setClientPapers(List<Paper> clientPapers) {
        this.clientPapers = clientPapers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientName.equals(client.clientName) && clientSurname.equals(client.clientSurname) && clientEmail.equals(client.clientEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientName, clientSurname, clientEmail);
    }
}
