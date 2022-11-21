package common;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConnectDB {
   public static DataSource mysqlDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      // dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://localhost/one");
      dataSource.setUsername("root");
      dataSource.setPassword("root");
      return dataSource;
  }
}
