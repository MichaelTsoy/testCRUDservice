package local.kz.java11mvc.models;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "clients")
@Transactional
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="clientId")
    public Long clientId;
    @NotNull
    @Column(name="clientName")
    public String clientName;
    @NotNull
    @Column(name="clientSurname")
    public String clientSurname;
    @NotNull
    @Column(name="clientEmail")
    public String clientEmail;
    public Client(){
    }
    public Client(String clientName, String clientSurname, String clientEmail){
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientEmail = clientEmail;
    }
    public Client(Long clientId, String clientName, String clientSurname, String clientEmail){
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientEmail = clientEmail;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId.equals(client.clientId) && clientName.equals(client.clientName) && clientSurname.equals(client.clientSurname) && clientEmail.equals(client.clientEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientName, clientSurname, clientEmail);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                '}';
    }
}
