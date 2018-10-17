import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads {
    private Connection connection;
    Config config=new Config();

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection=DriverManager.getConnection(
               config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads=new ArrayList<>();
        try {
            String query="select * from ads";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                ads.add(new Ad(rs.getLong("user_id"),rs.getString("title"),rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        String query=String.format("insert into ads(user_id,Title,Description) values ('%d','%s','%s')",ad.getUserId(),ad.getTitle(),ad.getDescription());
        try {
            Statement stmt=connection.createStatement();
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
