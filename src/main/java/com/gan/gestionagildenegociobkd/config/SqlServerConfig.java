package com.gan.gestionagildenegociobkd.config;

import com.gan.gestionagildenegociobkd.entities.Almacen;
import com.gan.gestionagildenegociobkd.entities.Categorias;
import com.gan.gestionagildenegociobkd.entities.Existencias;
import com.gan.gestionagildenegociobkd.entities.Items;
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
@EnableJpaRepositories(basePackages = "com.gan.gestionagildenegociobkd.repositories.SQLServer", entityManagerFactoryRef = "sqlServerEntityManagerFactory")
public class SqlServerConfig {

    @Bean(name = "dsSqlServer")
    @ConfigurationProperties(prefix = "sqlserver.datasource")
    @Primary
    public DataSource conexionSqlServer(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcSqlServer")
    @Primary
    public NamedParameterJdbcTemplate jdbcTemplateSqlServer(@Qualifier("dsSqlServer") DataSource dsSqlServer){
        return new NamedParameterJdbcTemplate(dsSqlServer);
    }

    @Bean(name = "sqlServerEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean sqlServer(EntityManagerFactoryBuilder builder
    ,@Qualifier("dsSqlServer") DataSource dataSource){
        return builder.dataSource(conexionSqlServer()).packages(Almacen.class, Categorias.class, Existencias.class, Items.class).build();
    }

}
