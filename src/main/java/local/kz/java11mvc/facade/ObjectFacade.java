package local.kz.java11mvc.facade;

import local.kz.java11mvc.dto.ShowDTO;
import java.util.List;

public interface ObjectFacade {
    List<ShowDTO> getAll();
}