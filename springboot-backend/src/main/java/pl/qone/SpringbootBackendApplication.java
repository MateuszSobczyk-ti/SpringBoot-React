package pl.qone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.qone.model.Phone;
import pl.qone.repository.PhoneRepository;

@SpringBootApplication
public class SpringbootBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootBackendApplication.class, args);
		
		//Employee ew = new Employee("James","Bond","myNameIs@gmail.com");
		//PhoneRepository employeeRepository = ctx.getBean(PhoneRepository.class);
		//employeeRepository.save(ew);
		
	}

}
