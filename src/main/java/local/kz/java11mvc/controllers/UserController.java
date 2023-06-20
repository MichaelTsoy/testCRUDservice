package local.kz.java11mvc.controllers;

import local.kz.java11mvc.dto.UserDTO;
import local.kz.java11mvc.facade.ObjectAccessFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private ObjectAccessFacade facade;
    public UserController(ObjectAccessFacade facade){
        this.facade = facade;
    }
    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody UserDTO userDTO){
        facade.create(new UserDTO(userDTO.getClientName(), userDTO.getClientSurname(), userDTO.getClientEmail()));
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @ResponseBody
    @PostMapping("/readUser")
    public ResponseEntity<UserDTO> readUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity(facade.find(new UserDTO()), HttpStatus.OK);
    }
    @PostMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO){
        facade.update(userDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @PostMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestBody UserDTO userDTO){
        facade.delete(userDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
//
//    @GetMapping("/insert")
//    public void findAllUsers(){
//        Client client1 = new Client();
//        Client client2 = new Client();
//        client1.setClientName("Клиент1");
//        client1.setClientSurname("surname1");
//        client1.setClientEmail("email1");;
//        client2.setClientName("Клиент2");
//        client2.setClientSurname("surname2");
//        client2.setClientEmail("email2");
//        clientRepository.create(client1);
//        clientRepository.create(client2);
//        Client client3 = clientRepository.findAll().get(0);
//        Client client4 = clientRepository.findAll().get(1);
//
//        Paper paper1 = new Paper();
//        paper1.setPaperContent("desc1");
//        paper1.setPaperName("paper1");
//        paper1.setClientId(client3.getClientId());
//        Paper paper2 = new Paper();
//        paper2.setPaperContent("desc2");
//        paper2.setPaperName("paper2");
//        paper2.setClientId(client4.getClientId());
//        Paper paper3 = new Paper();
//        paper3.setPaperContent("desc3");
//        paper3.setPaperName("paper3");
//        paper3.setClientId(client3.getClientId());
//        paperRepository.create(paper1);
//        paperRepository.create(paper2);
//        paperRepository.create(paper3);
//    }
}
