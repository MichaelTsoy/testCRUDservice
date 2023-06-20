package local.kz.java11mvc.controllers;

import local.kz.java11mvc.dto.PaperDTO;
import local.kz.java11mvc.dto.UserDTO;
import local.kz.java11mvc.facade.ObjectAccessFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    private ObjectAccessFacade facade;

    public MainController(ObjectAccessFacade facade){
        this.facade = facade;
    }
    @ResponseBody
    @GetMapping("/Users")
    public ResponseEntity listUsers() {
        return new ResponseEntity(facade.getAll(new UserDTO()), HttpStatus.OK);
    }
    @ResponseBody
    @GetMapping("/Papers")
    public ResponseEntity listPapers() {

        return new ResponseEntity(facade.getAll(new PaperDTO()), HttpStatus.OK);
    }

}
