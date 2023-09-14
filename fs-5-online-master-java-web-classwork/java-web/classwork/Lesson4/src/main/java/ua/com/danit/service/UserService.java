package ua.com.danit.service;



import ua.com.danit.domain.User;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean create(User user);
    Optional<User> read(Long id);
    void update(User user);
    boolean delete(long id);
    List<User> findAll();
    User findByLoginPass(String login,String password);
    void uploadImage(Long id, InputStream image);
    byte[] getImage(Long id);
}
