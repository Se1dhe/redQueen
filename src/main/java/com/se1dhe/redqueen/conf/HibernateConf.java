package com.se1dhe.redqueen.conf;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * project: bot
 * developed by: s1LenT
 * date: 11.03.2021 0:30
 */


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
class HibernateConf {
    @Bean
    public DriverManagerDataSource dataSource() {


        final DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUsername(Config.DB_USER);
        source.setPassword(Config.DB_PWD);
        source.setUrl(Config.DB_URL);

        return source;
    }
}
