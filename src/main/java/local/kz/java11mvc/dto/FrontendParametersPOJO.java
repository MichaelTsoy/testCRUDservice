package local.kz.java11mvc.dto;

import org.springframework.stereotype.Component;
@Component
public class FrontendParametersPOJO {
    Long id;

    public FrontendParametersPOJO() {
    }
    public FrontendParametersPOJO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
