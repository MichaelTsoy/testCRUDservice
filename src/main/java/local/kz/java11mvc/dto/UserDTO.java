package local.kz.java11mvc.dto;

import java.util.Objects;

public class UserDTO {
    private Long clientId;
    private String clientName;
    private String clientSurname;
    private String clientEmail;
    public UserDTO(){}
    public UserDTO(Long clientId){
        this.clientId = clientId;
    }
    public UserDTO(String clientName, String clientSurname, String clientEmail) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientEmail = clientEmail;
    }

    public UserDTO(Long clientId, String clientName, String clientSurname, String clientEmail) {
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

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return clientId.equals(userDTO.clientId) && clientName.equals(userDTO.clientName) && clientSurname.equals(userDTO.clientSurname) && clientEmail.equals(userDTO.clientEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientName, clientSurname, clientEmail);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                '}';
    }
}
