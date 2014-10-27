package com.hello.web;

// NOTA: La anotación @RestController NO vale para mostrar vistas (*.html)

/* NOTA: Si no existiese un controlador @RequestMapping("/") ni tampoco
existiese un index.html en el paquete static, se devolvería un archivo con 
las direcciones apara acceder a contenido JPA vía REST, es decir, aquellos repositorios 
(interfaces) con anotación @RepositoryRestResource(collectionResourceRel = "*", path = "*")*/


import com.hello.domain.Booking;
import com.hello.domain.BookingRepository;
import com.hello.domain.Customer;
import com.hello.domain.CustomerRepository;
import com.hello.domain.Greeting;
import com.hello.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;

// MVC
import org.springframework.web.bind.annotation.RestController; // incluye: import org.springframework.stereotype.Controller 
import org.springframework.web.bind.annotation.RequestMapping;

// Building a RESTful Web Service with Spring Boot Actuator
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// Consuming a RESTful Web Service
import org.springframework.web.client.RestTemplate;

// Building a RESTful Web Service
import java.util.concurrent.atomic.AtomicLong;
// MVC
import org.springframework.web.bind.annotation.RequestParam;

// MVC
import org.springframework.ui.Model;
//Spring Web MVC framework
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;






@RestController // Se utiliza para devolver JSON y REST, ¡NO devuelve vistas!
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
    
    @RequestMapping(value="/bookingName" , method=RequestMethod.GET)
    Collection<Booking> bookingName(@RequestParam(value="name") String name ){
                                       
        Collection<Booking> books = this.bookingRepository.findByBookingName(name);
               
        return books;
    }
    
    
    @RequestMapping(value="/bookingNameId" , method=RequestMethod.GET)
    Collection<Booking> bookingNameId(@RequestParam(value="bookingName", required = true) String bookingName, 
                                      @RequestParam(value="id", required = true)  Long id ){
        
        Collection<Booking> books = this.bookingRepository.findByBookName(bookingName, id);
               
        return books;
    }
    
    @RequestMapping(value="/bookingIds" , method=RequestMethod.GET)// ".../bookingIds?ids=1,2,3"
    public Collection<Booking> getUsers(@RequestParam("ids") Collection<Long> ids) {
        return this.bookingRepository.findAll(ids);
    }
    
    
    // Accessing Data with JPA
    @RequestMapping("/customer")
    Collection<Customer> customer(){
        
        Collection<Customer> customers = this.customerRepository.findAll();
               
        return customers;
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
    
    
    //Spring Web MVC framework
    @RequestMapping(value="/customer/{lastName}", method=RequestMethod.GET)
    public Collection <Customer>  getCostumer(@PathVariable String lastName) {
        
        Collection <Customer> customers = this.customerRepository.findByLastName(lastName);
               
        return customers;
    }
    
    
    @RequestMapping(value="/booking/{name}", method=RequestMethod.GET)
    public Collection <Booking>  getBooking(@PathVariable String name) {
        
        Collection <Booking> bookings = this.bookingRepository.findByBookingName(name);
               
        return bookings;
    }
    
   
    
}
