package local.kz.java11mvc.mapper;

import local.kz.java11mvc.dto.PaperDTO;
import local.kz.java11mvc.models.Paper;
import org.springframework.stereotype.Component;

@Component
public class PaperMapper {
    public Paper mapToEntity(PaperDTO paperDTO){
        return new Paper(paperDTO.getPaperName(), paperDTO.getPaperContent(), paperDTO.getClientId());
    }
    public PaperDTO mapToDTO(Paper paper){
        return new PaperDTO(paper.getPaperId(), paper.getPaperName(), paper.getPaperContent(), paper.getClientId());
    }
}
