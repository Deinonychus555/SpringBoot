package hello;

// NOTA: Las librerías deben estar en orden para que compilen o almenos el orden influye

/* NOTA: Si no existiese un controlador @RequestMapping("/") ni tampoco
existiese un index.html en el paquete static, se devolvería un archivo con 
las direcciones apara acceder a contenido JPA vía REST, es decir, aquellos repositorios 
(interfaces) con anotación @RepositoryRestResource(collectionResourceRel = "*", path = "*")*/

// Uploading Files 
import javax.servlet.MultipartConfigElement;

import java.util.List;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

// Uploading Files 
import org.springframework.boot.context.embedded.MultipartConfigFactory;
////
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Uploading Files 
import org.springframework.context.annotation.Bean;

// Accessing JPA Data with REST
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@EnableAutoConfiguration //Spring Boot - JPA - MVC
@ComponentScan
// Accessing JPA Data with REST
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
// end: Accessing JPA Data with REST

// Uploading Files 



// end: Uploading Files 

public class Application {
    
    /*
    // Uploading Files 
    @Bean
    public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("128KB");
        factory.setMaxRequestSize("128KB");
        return factory.createMultipartConfig();
    }
    */
    public static void main(String[] args) {
        /*
        //si no queremos hacer nada:
         SpringApplication.run(Application.class, args);
        */
        
        //gps-spring-boot
        //ApplicationContext cxt = SpringApplication.run(Application.class, args);
        
        // Accessing Data with JPA
         ConfigurableApplicationContext context = SpringApplication.run(Application.class);
         
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        
        //gps-spring-boot
        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        // end:gs-spring-boot
        
        // Accessing Data with JPA
        CustomerRepository repository = context.getBean(CustomerRepository.class);
        repository.save(new Customer("Jack", "Bauer"));
        /*
        // save a couple of customers
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));

        // fetch all customers
        Iterable<Customer> customers = repository.findAll();
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer by ID
        Customer customer = repository.findOne(1L);
        System.out.println("Customer found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(customer);
        System.out.println();

        // fetch customers by last name
        List<Customer> bauers = repository.findByLastName("Bauer");
        System.out.println("Customer found with findByLastName('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Customer bauer : bauers) {
            System.out.println(bauer);
        }

        context.close();
         // end:gs-accesing-data-jpa
        */
        
        
        
    }// main

}// Application
