package user.sumanth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Setter
@Getter
class StudentResource implements Serializable {
	private static final long SerialVersionUID = 1l;

	@JsonIgnore
	@Id
	ObjectId _id;

	String name;
	String address;
	String cls;

	public StudentResource(String name, String address, String cls) {
		super();
		this.name = name;
		this.address = address;
		this.cls = cls;
	}

}

