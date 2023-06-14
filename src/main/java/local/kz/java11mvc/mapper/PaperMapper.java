package local.kz.java11mvc.mapper;

import local.kz.java11mvc.dto.PaperDTO;
import local.kz.java11mvc.dto.ShowDTO;
import local.kz.java11mvc.models.Paper;
import org.springframework.stereotype.Component;

@Component
public class PaperMapper {
    public Paper mapToEntity(ShowDTO showDTO){
        return new Paper(showDTO.getPaperName(), showDTO.getPaperContent());
    }
    public PaperDTO mapToDTO(Paper paper){
        return new PaperDTO(paper.getPaperName(), paper.getPaperContent(), paper.getClient());
    }
}
