package web.service;


import web.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void createUser(User user);

    void deleteUser(long id);

    void updateUser(User user, long id);

    List<User> getAllUsers();

    User getUser(long id);

    UserDetails loadUserByUsername(String email);

}
