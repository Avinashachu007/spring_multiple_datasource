package play.spring.dualdatasource.bar.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

	@Id
	public Integer id;
	
	public String name;
	
	public String password;
}
