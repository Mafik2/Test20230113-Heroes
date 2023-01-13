import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;

@Named
@RequestScoped
public class SuperHeroPublisher {
    public ArrayList<String> publisher() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost/superhero?user=root&password=");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("""
                    select p.publisher_name
                    from publisher as p;  
                      """);
            ArrayList<String> getpublisher = new ArrayList<>();
            while (resultSet.next()) {
                getpublisher.add(resultSet.getString(1));
            }
            return getpublisher;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Hero> heroes() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost/superhero?user=root&password=");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("""
                    select s.superhero_name, s.full_name, s.gender_id, s.race_id, a.alignment
                    from superhero as s
                        join alignment as a on(s.alignment_id = a.id);
                                        
                    """);

            ArrayList<Hero> getHeroes = new ArrayList<>();
            while (resultSet.next()) {
                getHeroes.add(new Hero(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(5)));
            }
            return getHeroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
