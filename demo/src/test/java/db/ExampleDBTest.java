package db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.ConnectDB;

public class ExampleDBTest {
   private JdbcTemplate jdbcTemplate;

    @Test
    public void checkCountryCode()
    {
      jdbcTemplate = new JdbcTemplate(ConnectDB.mysqlDataSource());

      String name = jdbcTemplate.queryForObject("SELECT name FROM country WHERE code='BY';", String.class);

      
      Assert.assertEquals(name, "Belarus"); //pass
      // Assert.assertEquals(name, "Germany"); //fail
    }

}
