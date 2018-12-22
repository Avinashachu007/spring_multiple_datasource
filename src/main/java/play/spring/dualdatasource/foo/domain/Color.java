package play.spring.dualdatasource.foo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "color")
public class Color {

	@Id
	@Column(name = "Code")
//	@org.hibernate.annotations.Type(type = "nstring")
	public String code;

	@Column(name = "Name")
//	@org.hibernate.annotations.Type(type = "nstring")
	public String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
