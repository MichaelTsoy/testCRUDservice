package local.kz.java11mvc.controllers;

import local.kz.java11mvc.dto.FrontendParametersPOJO;
import local.kz.java11mvc.dto.PaperDTO;
import local.kz.java11mvc.facade.ObjectAccessFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaperController {
    private ObjectAccessFacade facade;
    public PaperController(ObjectAccessFacade facade){
        this.facade = facade;
    }

    @ResponseBody
    @GetMapping("/Papers")
    public ResponseEntity listPapers() {
        return new ResponseEntity(facade.getAll(new PaperDTO()), HttpStatus.OK);
    }
    @PostMapping("/createPaper")
    public ResponseEntity createPaper(@RequestBody PaperDTO paperDTO){
        facade.create(paperDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @ResponseBody
    @GetMapping("/readPaper")
    public ResponseEntity readPaper(@RequestBody FrontendParametersPOJO pojo){
        return new ResponseEntity(facade.find(new PaperDTO(), pojo.getId()), HttpStatus.OK);
    }
    @PostMapping("/updatePaper")
    public ResponseEntity updatePaper(@RequestBody PaperDTO paperDTO){
        facade.update(paperDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/deletePaper")
    public ResponseEntity deleteUser(@RequestBody FrontendParametersPOJO pojo){
        facade.delete(new PaperDTO(), pojo.getId());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
