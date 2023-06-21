package local.kz.java11mvc.controllers;

import local.kz.java11mvc.dto.FrontendParametersPOJO;
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
    @ResponseBody
    @GetMapping("/Users")
    public ResponseEntity listUsers() {
        return new ResponseEntity(facade.getAll(new UserDTO()), HttpStatus.OK);
    }
    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody UserDTO userDTO){
        facade.create(userDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @ResponseBody
    @GetMapping("/readUser")
    public ResponseEntity readUser(@RequestBody FrontendParametersPOJO pojo){
        return new ResponseEntity(facade.find(new UserDTO(), pojo.getId()), HttpStatus.OK);
    }
    @PostMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO){
        facade.update(userDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestBody FrontendParametersPOJO pojo){
        facade.delete(new UserDTO(), pojo.getId());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
