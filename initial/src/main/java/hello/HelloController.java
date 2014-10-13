package hello;

// NOTA: La anotación @RestController NO vale para mostrar vistas

// Uploading files
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;

// MVC
import org.springframework.web.bind.annotation.RestController; // incluye: import org.springframework.stereotype.Controller 
import org.springframework.web.bind.annotation.RequestMapping;

// Uploading files
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// Consuming a RESTful Web Service
import org.springframework.web.client.RestTemplate;

// Uploading files
import org.springframework.web.multipart.MultipartFile;

// Building a RESTful Web Service
import java.util.concurrent.atomic.AtomicLong;
// MVC
import org.springframework.web.bind.annotation.RequestParam;

// MVC
import org.springframework.ui.Model;

import java.util.Collection;





@RestController // NO vale para mostrar vistas
public class HelloController {
    
    // JPA
    @Autowired
    BookingRepository bookingRepository;
    
    @Autowired
    CustomerRepository customerRepository;
    
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
 

    
    
    
// Consuming a RESTful Web Service
@RequestMapping("/rest")
public String rest() {
	RestTemplate restTemplate = new RestTemplate();
        Page page = restTemplate.getForObject("http://graph.facebook.com/pivotalsoftware", Page.class);
        StringBuilder salida=new StringBuilder();
        String salto= System.getProperty("line.separator"); // salto de linea
        salida=salida.append("Name: ");
        salida=salida.append(page.getName());
        salida=salida.append(salto);
        salida=salida.append("About:   ");
        salida=salida.append(page.getAbout());
        salida=salida.append(salto);
        salida=salida.append("Phone:   ");
        salida=salida.append(page.getPhone());
        salida=salida.append(salto);
        salida=salida.append("Website: " );
        salida=salida.append(page.getWebsite());

        return salida.toString();
    }

   
    

    // Accessing Data with JPA
    @RequestMapping("/booking")
    Collection<Booking> booking(){
        
        
        Collection<Booking> books = this.bookingRepository.findAll();
                
        return books;
    }
    
    
    
    
    // Accessing Data with JPA
    @RequestMapping("/customer")
    Collection<Customer> customer(){
        
        Collection<Customer> customer = this.customerRepository.findAll();
               
        return customer;
    }
    
    
    
    
    // Building a RESTful Web Service
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    // Building a RESTful Web Service
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    
    
   
    // Building a RESTful Web Service with Spring Boot Actuator
    @RequestMapping(value="/greeting2", method=RequestMethod.GET)
    public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    
    /*
    // Serving Web Content with Spring MVC
    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
    
    
    
    
    // Uploading files
    @RequestMapping("/index")
    public String index() {
        return "index.html";
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
    */
    
}
