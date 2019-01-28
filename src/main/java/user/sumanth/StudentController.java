package user.sumanth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/firstName/{name}")
	public ResponseEntity<StudentResource> getStudent(@PathVariable(name = "name") String name,@RequestHeader String apiKey) {

		String response  = restTemplate.exchange("https://Conumser-Details/api/consumer/apikey/"+apiKey, HttpMethod.GET,null,String.class).getBody();
		if(response=="false"){
			return new ResponseEntity<>(new StudentResource(null,null,null), HttpStatus.UNAUTHORIZED);
		}
		StudentResource s = studentRepository.findByFirstName(name);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<String> getStudentDetails(@RequestBody Student student,@RequestHeader String apiKey) {
		studentRepository.save(new StudentResource(student.name,student.address,student.cls));
		return new ResponseEntity<>("Saved to Database", HttpStatus.CREATED);
	}

}

