package user.sumanth;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<StudentResource,String> {
	StudentResource findByFirstName(String firstName);
	StudentResource findById(int id);
	StudentResource findByLastName(String lastName);

}
