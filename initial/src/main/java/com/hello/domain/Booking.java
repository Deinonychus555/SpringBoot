package com.hello.domain;

// Accessing Data with JPA
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String bookingName;
    
    // los constructores p or defecto serán protegidos
    protected Booking() {}

    public Booking(String bookingName) {
        super();
        this.bookingName = bookingName;
       
    }
    
    public String getBookingName(){
        return this.bookingName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, BookingName='%s']",
                id, bookingName);
    }

}

