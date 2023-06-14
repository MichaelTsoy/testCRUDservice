package local.kz.java11mvc.models;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "paper")
@Transactional
public class Paper {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="paperId")
    private long paperId;
    @NotNull
    @Column(name="paperName")
    private String paperName;
    @NotNull
//    @Lob
    @Column(name="paperContent", columnDefinition = "TEXT")
    private String paperContent;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, targetEntity = Client.class)
    @JoinColumn(name = "clientId")
    private Client client;
    public Paper(String paperName, String paperContent){
        this.paperName = paperName;
        this.paperContent = paperContent;
    }
    public Paper(){}

    public long getPaperId() {
        return paperId;
    }

    public void setPaperId(long paperId) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paper paper = (Paper) o;
        return paperName.equals(paper.paperName) && paperContent.equals(paper.paperContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paperName, paperContent);
    }
}
