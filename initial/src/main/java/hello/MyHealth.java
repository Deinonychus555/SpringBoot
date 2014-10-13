package hello;

import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Health.Builder;

import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator {

    
    
    @Override
    public Health health() {
        // perform some specific health check
        Health h = new Health.Builder().up().withDetail("nombre" ,"pepito").withDetail("estado", "XD").build();
        
       
        return h;
    }

}