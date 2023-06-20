package local.kz.java11mvc.controllers;

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
    @PostMapping("/createPaper")
    public ResponseEntity createPaper(@RequestBody PaperDTO paperDTO){
        facade.create(new PaperDTO(paperDTO.getPaperName(), paperDTO.getPaperContent(), paperDTO.getClientId()));
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @ResponseBody
    @PostMapping("/readPaper")
    public ResponseEntity readPaper(@RequestBody PaperDTO paperDTO){
        return new ResponseEntity(facade.find(new PaperDTO()), HttpStatus.OK);
    }
    @PostMapping("/updatePaper")
    public ResponseEntity updatePaper(@RequestBody PaperDTO paperDTO){
        facade.update(paperDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping("/deletePaper")
    public ResponseEntity deletePaper(@RequestBody PaperDTO paperDTO){
        facade.delete(paperDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
