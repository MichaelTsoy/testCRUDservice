package local.kz.java11mvc.dto;

import java.util.Objects;
public class PaperDTO {
    private Long paperId;
    private String paperName;
    private String paperContent;
    private Long clientId;
    public PaperDTO(){}
    public PaperDTO(Long paperId){
        this.paperId = paperId;
    }
    public PaperDTO(String paperName, String paperContent, Long clientId) {
        this.paperName = paperName;
        this.paperContent = paperContent;
        this.clientId = clientId;
    }

    public PaperDTO(Long paperId, String paperName, String paperContent, Long clientId) {
        this.paperId = paperId;
        this.paperName = paperName;
        this.paperContent = paperContent;
        this.clientId = clientId;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaperDTO paperDTO = (PaperDTO) o;
        return paperId.equals(paperDTO.paperId) && paperName.equals(paperDTO.paperName) && paperContent.equals(paperDTO.paperContent) && clientId.equals(paperDTO.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperId, paperName, paperContent, clientId);
    }

    @Override
    public String toString() {
        return "PaperDTO{" +
                "paperName='" + paperName + '\'' +
                ", paperContent='" + paperContent + '\'' +
                '}';
    }
}
