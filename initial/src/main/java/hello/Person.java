package hello;

// Accessing Data with JPA
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Validating Form Input 
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
        
        @Size(min=2, max=30)
	private String firstName;
        
	private String lastName;
        
        @NotNull
        @Min(18)
        private Integer age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
        
        public Integer getAge() {
            return age;
        }
        
        public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Person(First name: " + this.firstName + "Last name: " + this.lastName + ", Age: " + this.age + ")";
    }
}
