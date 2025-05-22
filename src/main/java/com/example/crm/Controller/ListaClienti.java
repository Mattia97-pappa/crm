package com.example.crm.Controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.crm.entity.Cliente;
import com.example.crm.entity.Operatore;
import com.example.crm.repository.ClienteRepository;
import com.example.crm.repository.OperatoreRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/clienti")
public class ListaClienti {
    
@Autowired
private OperatoreRepository operatorerepository;


@Autowired 
private ClienteRepository clienterepository;


@GetMapping("/all")
public String listClienti(Model model)
{
Authentication auth=SecurityContextHolder.getContext().getAuthentication();
String username=auth.getName();
    Operatore operatore=operatorerepository.findByUsername(username);
if (operatore == null) {
    throw new RuntimeException("Operatore non trovato");
}

    List<Cliente> cliente=clienterepository.findByOperatore(operatore);
model.addAttribute("cliente", cliente);
return "clienti";

}


@GetMapping("/new")
public String aggiungiCliente(Model model)
{
model.addAttribute("cliente", new Cliente());
return "newCliente";

}


@PostMapping(path="/add")
public String addCliente(@ModelAttribute Cliente cliente, RedirectAttributes redirectAttributes){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    Operatore operatore = operatorerepository.findByUsername(username);

    cliente.setOperatore(operatore); 
    clienterepository.save(cliente);

redirectAttributes.addFlashAttribute("successo", "hai inserito il cliente "+cliente.getCognome()+" "+cliente.getNome()+ " con successo");

    return "redirect:/clienti/all";
}




@GetMapping("/delete/{id}")
public String deleteCliente(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
    if (clienterepository.existsById(id)) {
        clienterepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Cliente eliminato correttamente");
    } else {
        redirectAttributes.addFlashAttribute("error", "Cliente non trovato");
    }

    return "redirect:/clienti/all";
}




@GetMapping("/edit/{id}")
public String edit(@PathVariable("id") int id,Model model){
Cliente cliente= clienterepository.findById(id)
.orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
model.addAttribute("cliente", cliente);
return "edit";


}

@PostMapping("/upd")
public String updateCliente(@ModelAttribute("cliente") Cliente cliente){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    Operatore operatore = operatorerepository.findByUsername(username);

    cliente.setOperatore(operatore); 
    clienterepository.save(cliente);
    return "redirect:/clienti/all";
}




}


