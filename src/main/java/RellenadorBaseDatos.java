import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RellenadorBaseDatos {
    Faker faker ;

    public RellenadorBaseDatos() {
        faker = new Faker();
        for (int i = 0; i < 5; i++) {
            fillFutbolista(i);
        }

    }
    private void fillEqipo(int i){
        Connection con = connect();
        PreparedStatement st;

        try {

            st = con.prepareStatement("insert into alumnos values (?,?,?,?,?,?,?)");
            st.setInt(1,i);
            st.setInt(2,faker.number().numberBetween(1966,2002));
            st.setString(3,faker.name().lastName());
            st.setInt(4,faker.number().numberBetween(0,10));
            st.setFloat(5,faker.number().numberBetween(1,1000));
            st.setString(6,faker.name().username());
            st.setString(7,faker.name().firstName());

            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        finally {
            closeConnection(con);
        }
    }
    private void fillSocio(int i){
        Connection con = connect();
        PreparedStatement st = null;

        try {
            st = con.prepareStatement("insert into alumnos values (?,?,?,?,?,?,?)");
            st.setInt(1,i);
            st.setInt(2,faker.number().numberBetween(1966,2002));
            st.setString(3,faker.name().lastName());
            st.setInt(4,faker.number().numberBetween(0,10));
            st.setFloat(5,faker.number().numberBetween(1,1000));
            st.setString(6,faker.name().username());
            st.setString(7,faker.name().firstName());

            st.executeUpdate();

            st.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        finally {
            closeConnection(con);
        }
    }

    private void fillFutbolista(int i){
        Connection con = connect();
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO futbolista values (?,?,?,?,?,?,?)");

            st.setInt(1,i);
            st.setInt(3,faker.number().numberBetween(1966,2002));
            st.setString(4,faker.name().lastName());
            st.setInt(6,faker.number().numberBetween(0,10));
            st.setFloat(5,faker.number().numberBetween(1,1000));
            st.setString(7,faker.name().username());
            st.setString(2,faker.name().firstName());

            st.executeUpdate();
            st.close();
        } catch (SQLException|NullPointerException ex) {
            System.err.println(ex.getMessage());
        }
        finally {
            closeConnection(con);
        }
    }

    private void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connect(){
        try {
            Connection connect = DriverManager.getConnection("jdbc:sqlite:futbolistas.db");
            if (connect!=null) {
                System.out.println("Conectado");
            }
            return connect;
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
            return null;
        }
    }
}
