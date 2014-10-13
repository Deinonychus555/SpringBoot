package hello;

// NOTA: La anotación @Controller es para mostrar vistas

// Serving Web Content with Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Serving Web Content with Spring MVC
public class GreetingController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="MVC") String name, Model model) {
        model.addAttribute("name", name);
        return "mvc";
    }

}
