package local.kz.java11mvc.dto;

import local.kz.java11mvc.models.Client;

public class PaperDTO {
    private String name;
    private String content;
    private Client client;
    public PaperDTO(){}
    public PaperDTO(String name, String content, Client client){
        this.name = name;
        this.content = content;
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
