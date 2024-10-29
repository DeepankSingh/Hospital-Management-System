package hospital.management.system;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public class conn {

    Connection connection;
    Statement statement;

    public conn(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital_management_system","postgres","123456789");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
