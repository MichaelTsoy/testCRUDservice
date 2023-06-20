package local.kz.java11mvc.models;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Objects;

@Entity
@Table(name = "papers")
@Transactional
public class Paper {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="paperId")
    private Long paperId;
    @NotNull
    @Column(name="paperName")
    private String paperName;
    @NotNull
//    @Lob
    @Column(name="paperContent", columnDefinition = "TEXT")
    private String paperContent;
    @Column(name="clientId")
    private Long clientId;
    public Paper(String paperName, String paperContent, Long clientId){
        this.paperName = paperName;
        this.paperContent = paperContent;
        this.clientId = clientId;
    }
    public Paper(Long paperid, String paperName, String paperContent, Long clientId){
        this.paperId = paperid;
        this.paperName = paperName;
        this.paperContent = paperContent;
        this.clientId = clientId;
    }
    public Paper(){}

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
        Paper paper = (Paper) o;
        return paperId.equals(paper.paperId) && paperName.equals(paper.paperName) && paperContent.equals(paper.paperContent) && clientId.equals(paper.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperId, paperName, paperContent, clientId);
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paperName='" + paperName + '\'' +
                ", paperContent='" + paperContent + '\'' +
                '}';
    }
}
