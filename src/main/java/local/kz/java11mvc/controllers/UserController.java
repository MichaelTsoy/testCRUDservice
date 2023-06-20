package local.kz.java11mvc.controllers;

import local.kz.java11mvc.dto.UserDTO;
import local.kz.java11mvc.facade.ObjectAccessFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
}
