package local.kz.java11mvc.services.Impl;

import local.kz.java11mvc.models.Paper;
import local.kz.java11mvc.repository.PaperDAORepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaperRepositoryImpl implements PaperRepository{
    private PaperDAORepository paperDAORepository;

    public PaperRepositoryImpl(PaperDAORepository paperDAORepository) {
        this.paperDAORepository = paperDAORepository;
    }
    public List<Paper> findAll() {
        return paperDAORepository.findAll();
    }
}
