/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hello;

// Externalized Configuration 
import org.springframework.beans.factory.annotation.Value;

// Using the CommandLineRunner
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

/**
 *
 * @author juanan
 */

// clase con ejemplos varios
@Component
public class myBean implements CommandLineRunner{ // Using the CommandLineRunner
    
// Externalized Configuration   
// en application.properties deberá aparecer 'propiedad='    
@Value("${propiedad:     }") // los ':' significan que tomará por defecto valor vacío
private String propiedad;

@Value("${my.secret}") // definido en application.properties
private String aleatorio;

// Using the CommandLineRunner    
@Override
// método de la interfaz CommandLineRunner que se ejecutará al iniciarse El SpingApplication
public void run(String... args) { 
        
        System.out.println("Propiedad: "+propiedad);   
        System.out.println("Valor aleatorio: "+aleatorio);
        System.out.println("Implemento la interfaz CommandLineRunner y estos son los argumentos: ");
        for (String s : args) {
            System.out.println(s);
        }
    }
    
}
