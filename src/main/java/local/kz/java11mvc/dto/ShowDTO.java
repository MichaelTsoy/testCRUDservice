package local.kz.java11mvc.dto;

public class ShowDTO {
    private String clientName;
    private String clientSurname;
    private String clientEmail;
    private String paperName;
    private String paperContent;
    public ShowDTO(){}
    public ShowDTO(String clientName, String clientSurname, String clientEmail, String paperName, String paperContent){
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientEmail = clientEmail;
        this.paperName = paperName;
        this.paperContent = paperContent;
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

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getPaperContent() {
        return paperContent;
    }

    public void setPaperContent(String paperContent) {
        this.paperContent = paperContent;
    }
}
