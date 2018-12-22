package play.spring.dualdatasource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "barEntityManagerFactory",
  transactionManagerRef = "barTransactionManager",
  basePackages = { "play.spring.dualdatasource.bar.repo" }
)
public class BarDbConfig {
	
	@Autowired
    private Environment env;
 
  @Bean(name = "barDataSource")
  @ConfigurationProperties(prefix = "bar.datasource")
  public DataSource dataSource() {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("bar.datasource.driverClassName"));
	    dataSource.setUrl(env.getProperty("bar.datasource.url"));
	    dataSource.setUsername(env.getProperty("bar.datasource.username"));
	    dataSource.setPassword(env.getProperty("bar.datasource.password"));

	    return dataSource;
  }
  
  @Bean(name = "barEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean 
  barEntityManagerFactory(
    EntityManagerFactoryBuilder builder,
    @Qualifier("barDataSource") DataSource dataSource
  ) {
    return
      builder
        .dataSource(dataSource)
        .packages("play.spring.dualdatasource.bar.domain")
        .persistenceUnit("bar")
        .build();
  }
  @Bean(name = "barTransactionManager")
  public PlatformTransactionManager barTransactionManager(
    @Qualifier("barEntityManagerFactory") EntityManagerFactory
    barEntityManagerFactory
  ) {
    return new JpaTransactionManager(barEntityManagerFactory);
  }
}