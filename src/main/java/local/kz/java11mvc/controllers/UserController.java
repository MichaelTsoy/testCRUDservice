package local.kz.java11mvc.controllers;

import local.kz.java11mvc.models.Client;
import local.kz.java11mvc.models.Paper;
import local.kz.java11mvc.repository.PaperDAORepository;
import local.kz.java11mvc.repository.ClientDAORepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private ClientDAORepository clientRepository;
    private PaperDAORepository paperRepository;
    UserController(ClientDAORepository clientDAORepository, PaperDAORepository paperDAORepository){
        this.clientRepository = clientDAORepository;
        this.paperRepository = paperDAORepository;
    }
    @GetMapping("/insert")
    public void findAllUsers(){
        Client client1 = new Client();
        Client client2 = new Client();
        Paper paper1 = new Paper();
        paper1.setPaperContent("desc1");
        paper1.setPaperName("paper1");
        Paper paper2 = new Paper();
        paper2.setPaperContent("desc2");
        paper2.setPaperName("paper2");
        Paper paper3 = new Paper();
        paper3.setPaperContent("desc3");
        paper3.setPaperName("paper3");
        List<Paper> arr1 = new ArrayList<>();
        List<Paper> arr2 = new ArrayList<>();
        arr1.add(paper1);
        arr2.add(paper2);
        arr1.add(paper3);
        client1.setClientName("Клиент1");
        client1.setClientSurname("surname1");
        client1.setClientEmail("email1");;
        client1.setClientPapers(arr1);
        client2.setClientName("Клиент2");
        client2.setClientSurname("surname2");
        client2.setClientEmail("email2");
        client2.setClientPapers(arr2);
        clientRepository.save(client1);
        clientRepository.save(client2);
        List<Paper> papers = paperRepository.findAll();
        clientRepository.findAll()
                .forEach((c)-> {
                    System.out.println("client id" + c.getClientId());
                    System.out.println("client name" + c.getClientName());
                    System.out.println("client surname" + c.getClientSurname());
                    System.out.println("client email" + c.getClientEmail());
                    for (Paper clientPaper : c.getClientPapers()) {
                        System.out.println("SUER " + c.getClientName() + "papeR  " + clientPaper.getPaperName());
                    }
    });
    }
}
