package org.lessons.bestOfTheYear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//passo 1 - per dire a spring che questa classe è un controller dobbiamo usare un Annotations Controller
//passo 2 - possiamo dare qualche parametro in più dicendo che questa classe ha i metodi che
         // risponderanno ad una particolare rotta con l annotation requestMapping con parametri
//
@Controller // dice a Spring che questa classe è un Controller
@RequestMapping("/") // a quale rotta rispondono i metodi di questo Controller in questo caso alla root (pagina principale)
public class IndexController {

    //metodi controller
    @GetMapping // risponde a richieste di tipo HTTP GET
    //@ResponseBody // mette la stringa restituita direttamente nel body della response
    public String home(Model model) { //chiediamo a Spring di invocare questo metodo passandogli il Model
        String nome = "Lucia";
        model.addAttribute("nome", nome);
        return "index"; // ritorno il nome del tamplate index.html che si trova nella cartella resources/template
    }


}
