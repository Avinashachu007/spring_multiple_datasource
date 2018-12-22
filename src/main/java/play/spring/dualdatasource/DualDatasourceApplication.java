package play.spring.dualdatasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class DualDatasourceApplication {
	@Autowired
    private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(DualDatasourceApplication.class, args);
	}
	
//	@Bean
//	@Primary
//	@ConfigurationProperties(prefix="spring.datasource")
//	public DataSource primaryDataSource() {
//		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		    dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
//		    dataSource.setUrl(env.getProperty("spring.datasource.url"));
//		    dataSource.setUsername(env.getProperty("spring.datasource.username"));
//		    dataSource.setPassword(env.getProperty("spring.datasource.password"));
//
//		    return dataSource;
//	}
//
//	@Bean
//	@ConfigurationProperties(prefix="bar.datasource")
//	public DataSource secondaryDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(env.getProperty("bar.datasource.driverClassName"));
//	    dataSource.setUrl(env.getProperty("bar.datasource.url"));
//	    dataSource.setUsername(env.getProperty("bar.datasource.username"));
//	    dataSource.setPassword(env.getProperty("bar.datasource.password"));
//
//	    return dataSource;
//	}
}
