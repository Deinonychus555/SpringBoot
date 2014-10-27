package com.hello.web;

// NOTA: La anotación @Controller es para mostrar vistas

// NOTA: La anotación @RestController NO vale para mostrar vistas (*.html)

/* NOTA: Si no existiese un controlador @RequestMapping("/") ni tampoco
existiese un index.html en el paquete static, se devolvería un archivo con 
las direcciones apara acceder a contenido JPA vía REST, es decir, aquellos repositorios 
(interfaces) con anotación @RepositoryRestResource(collectionResourceRel = "*", path = "*")*/

// Serving Web Content with Spring WebServerController
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// Uploading files
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// Uploading files
import org.springframework.web.multipart.MultipartFile;

// Uploading files
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.springframework.web.bind.annotation.RestController;


// Serving Web Content with Spring WebServerController
@Controller // Se utiliza para devolver vistas ¡NO funciona con @RestContoller!
public class WebServerController {

    
    
    
    // Serving Web Content with Spring WebServerController
    @RequestMapping("/hello")
    public String hello(@RequestParam(value="var", required=false, defaultValue="MVC") String var, Model model) {
        model.addAttribute("var", var);
        return "hello";
        // con 'name' como nombre de la variable, mostraba el nombre del proyecto
    }
    
    
    
    
     // Uploading files
    @RequestMapping("/file")
    public String file() {
        return "file";
    }
    
    // Uploading files
     @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }
    
    // Uploading files
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name, 
            @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = 
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }
}
