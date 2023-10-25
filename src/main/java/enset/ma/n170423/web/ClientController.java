package enset.ma.n170423.web;

import enset.ma.n170423.entities.Client;
import enset.ma.n170423.repositories.ClientRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientController {
    private ClientRepository clientRepository;
    @GetMapping(path = "/client/index")
    public String clients(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "7") int size,
                               @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Client> pageClients = clientRepository.findByUsernameContains(keyword, PageRequest.of(page, size));
        model.addAttribute("ListClients", pageClients.getContent());
        model.addAttribute("pages", new int[pageClients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "clients";
    }
    @GetMapping("/admin/deleteClient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(Long id, String keyword, int page) {
        clientRepository.deleteById(id);
        return "redirect:/client/index?page=" + page + "&keyword=" + keyword;
    }
    @GetMapping("/")
    public String home() {
        return "redirect:/client/index";
    }
    @GetMapping("/clients")
    @ResponseBody
    public List<Client> listClients() {
        return clientRepository.findAll();
    }
    @GetMapping("/admin/formClient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String formClient(Model model) {
        model.addAttribute("client", new Client());
        return "formClient";
    }
    @PostMapping("/admin/saveClient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveClient(@Valid Client client, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "formClient";
        clientRepository.save(client);
        return "formClient";
    }
    @GetMapping("/admin/editClient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editClient(@RequestParam(name = "id") Long id, Model model){
        Client client = clientRepository.findById(id).get();
        model.addAttribute("client", client);
        return "editClient";
    }
}
