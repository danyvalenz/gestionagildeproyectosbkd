package com.gan.gestionagildenegociobkd.config;

import com.gan.gestionagildenegociobkd.entities.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.gan.gestionagildenegociobkd.repositories.postgresql", entityManagerFactoryRef = "postgreSqlEntityManagerFactory")
public class PostgreSqlConfig {

    @Bean(name = "dsPostgreSql")
    @ConfigurationProperties(prefix = "postgresql.datasource")
    public DataSource conexionPostgreSql(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcPostgreSql")
    public NamedParameterJdbcTemplate jdbcTemplatePostgreSql(@Qualifier("dsPostgreSql") DataSource dsPostgreSql){
        return new NamedParameterJdbcTemplate(dsPostgreSql);
    }

    @Bean(name = "postgreSqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgreSql(EntityManagerFactoryBuilder builder
            , @Qualifier("dsPostgreSql") DataSource dataSource){
        return builder.dataSource(conexionPostgreSql()).packages(Cajas.class).build();
    }
}
