package local.kz.java11mvc.controllers;

import local.kz.java11mvc.facade.ObjectFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private ObjectFacade facade;

    public MainController(ObjectFacade facade){
        this.facade = facade;
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("showAll", facade.getAll());
//        facade.getAll().stream().forEach((e)-> System.out.println(e.getClientName() + e.getPaperName()));
        return "show";
    }
}
