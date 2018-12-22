package play.spring.dualdatasource.foo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import play.spring.dualdatasource.foo.domain.Color;

public interface ColorRepository extends JpaRepository<Color, Integer> {

}
 