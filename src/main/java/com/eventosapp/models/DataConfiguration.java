package com.eventosapp.models;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdb:mysql:localhost:3306/listatoeventapp");
		dataSource.setUsername("root");
		dataSource.setPassword("wander27");
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.MySQLDialect");
		adapter.setPrepareConnection(true);
		return adapter;
	}
}
