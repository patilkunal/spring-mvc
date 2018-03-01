package com.inovisionsoftware.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@PropertySource(value = "classpath:app.properties") - to read and inject property values
public class HibernateConfig {

	private static final String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	/*
	private static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/test";
	private static final String DATABASE_DRIVER = "org.h2.Driver";
	private static final String DATABASE_USER = "sa";
	private static final String DATABASE_PASSWORD = "";
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USER);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
	*/
	
	
	@Bean
    public DataSource getDataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = dsLookup.getDataSource("jdbc/H2DS");
        return dataSource;
    }
	/*
	@Bean
	public DataSource getDataSource() throws Exception {
		Context ctx = new InitialContext();
		return (DataSource) ctx.lookup("jdbc/H2DS");
	}
	*/
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.inovisionsoftware");
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", DATABASE_DIALECT);
		props.put("hibernate.show_sql",true);
		props.put("hibernate.format_sql", true);
		
		return props;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager tm = new HibernateTransactionManager(sessionFactory);
		
		return tm;
	}
	
	
}
