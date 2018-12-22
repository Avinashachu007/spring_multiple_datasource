package play.spring.dualdatasource.foo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import play.spring.dualdatasource.bar.domain.Login;
import play.spring.dualdatasource.bar.repo.LoginRepository;
import play.spring.dualdatasource.foo.domain.Color;
import play.spring.dualdatasource.foo.repo.ColorRepository;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ColorRepository colorRepo;
	
	@Autowired
	private LoginRepository loginRepo;
	
	@GetMapping("/greet")
	public String greet() {
		return "Hi!";
	}
	
	@GetMapping("/foo")
	public List<Color> getFoo() {
		return colorRepo.findAll();
	}
	
	@GetMapping("/bar")
	public List<Login> getBar() {
		return loginRepo.findAll();
	}
	
	
}
