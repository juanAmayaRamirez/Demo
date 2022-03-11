package com.API;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource getDataSource() {
		DataSource dataSource=null;
		
		DataSourceBuilder builder = DataSourceBuilder.create();
		
		builder.url("jdbc:mysql://localhost:3306/pruebas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		builder.username("root");
		builder.password("12345678");
		builder.driverClassName("com.mysql.cj.jdbc.Driver");
		
		dataSource=builder.build();
		return dataSource;
	}
}
