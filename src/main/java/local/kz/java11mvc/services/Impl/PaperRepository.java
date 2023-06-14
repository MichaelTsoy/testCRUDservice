package local.kz.java11mvc.services.Impl;

import local.kz.java11mvc.models.Paper;
import java.util.List;

public interface PaperRepository {
    List<Paper> findAll();
}
