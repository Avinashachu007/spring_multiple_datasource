package play.spring.dualdatasource.bar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import play.spring.dualdatasource.bar.domain.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
