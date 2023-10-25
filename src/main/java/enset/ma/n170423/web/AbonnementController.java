package enset.ma.n170423.web;

import enset.ma.n170423.entities.Abonnement;
import enset.ma.n170423.repositories.AbonnementRepository;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

public class AbonnementController {
    private AbonnementRepository abonnementRepository;
    @GetMapping("/admin/consulterAbonnements")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String consulterAbonnements(@RequestParam(name = "abonnements") Collection<Abonnement> abonnements, Model model){
        model.addAttribute("ListAbonnements", abonnements);
        return "consulterAbonnements";
    }
    @GetMapping("/admin/deleteAbonnement")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(Long id) {
        abonnementRepository.deleteById(id);
        return "redirect:/admin/consulterAbonnements";
    }
    @GetMapping("/admin/formAbonnement")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String formAbonnement(Model model) {
        model.addAttribute("abonnement", new Abonnement());
        return "formAbonnement";
    }
    @PostMapping("/admin/saveAbonnement")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveAbonnement(@Valid Abonnement abonnement, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "formAbonnement";
        abonnementRepository.save(abonnement);
        return "formAbonnement";
    }
    @GetMapping("/admin/editAbonnement")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editAbonnement(@RequestParam(name = "id") Long id, Model model){
        Abonnement abonnement = abonnementRepository.findById(id).get();
        model.addAttribute("abonnement", abonnement);
        return "editAbonnement";
    }
}
