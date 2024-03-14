package org.acme.camelIntegracionFueradeLineaaparrab.Components;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceConfig {

    public static DataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://postgres:5432/postgres");
        dataSource.setUsername("camel");
        dataSource.setPassword("camel");
        return dataSource;
    }
}