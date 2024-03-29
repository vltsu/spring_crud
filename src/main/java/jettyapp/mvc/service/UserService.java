package jettyapp.mvc.service;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import jettyapp.mvc.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private SimpleJdbcTemplate jdbcTemplate;

    public void setDataSource(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_SELECT_ALL_USERS = "select name, email, image from users";
    public List<User> getAllUsers() {
        return jdbcTemplate.query(
                SQL_SELECT_ALL_USERS,
                new UserMapper()
        );
    }

    private static final String SQL_SELECT_USER_BY_EMAIL = "select name, email, image from users where email = ?";
    public User getUserByEmail(String email) {
        return jdbcTemplate.queryForObject(
                SQL_SELECT_USER_BY_EMAIL,
                new UserMapper(),
                email
        );
    }

    private static final String SQL_CREATE_USER = "insert into users (name, email, image) values (?,?,?)";
    public void createUser(User user) {
        jdbcTemplate.update(SQL_CREATE_USER,
                new Object[] { user.getName(), user.getEmail(), user.getImage() });
    }

    private static final String SQL_UPDATE_USER = "update users set name = ?, email = ?, image =? where email = ?";
    public void updateUser(User user, String email) {
        jdbcTemplate.update(SQL_UPDATE_USER,
                new Object[] { user.getName(), user.getEmail(), user.getImage(), email });
    }

    private static final String SQL_DELETE_USER = "delete from users where email = ?";
    public void deleteUser(String email) {
        jdbcTemplate.update(SQL_DELETE_USER,
                new Object[] { email });
    }

    private static final class UserMapper implements ParameterizedRowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setName(rs.getString("Name"));
            user.setEmail(rs.getString("Email"));
            user.setImage(rs.getString("Image"));
            return user;
        }
    }

}
