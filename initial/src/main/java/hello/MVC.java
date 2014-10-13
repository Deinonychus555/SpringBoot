package hello;

// NOTA: La anotación @Controller es para mostrar vistas

// NOTA: La anotación @RestController NO vale para mostrar vistas (*.html)

/* NOTA: Si no existiese un controlador @RequestMapping("/") ni tampoco
existiese un index.html en el paquete static, se devolvería un archivo con 
las direcciones apara acceder a contenido JPA vía REST, es decir, aquellos repositorios 
(interfaces) con anotación @RepositoryRestResource(collectionResourceRel = "*", path = "*")*/

// Serving Web Content with Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Serving Web Content with Spring MVC
public class MVC {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="MVC") String name, Model model) {
        model.addAttribute("name", name);
        return "mvc";
    }

}
