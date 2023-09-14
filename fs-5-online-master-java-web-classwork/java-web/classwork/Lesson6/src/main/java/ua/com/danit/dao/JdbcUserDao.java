package ua.com.danit.dao;

import ua.com.danit.domain.User;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class JdbcUserDao implements UserDao{
    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public Optional<User> read(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByLoginPass(String login, String password) {
        return null;
    }

    @Override
    public void uploadImage(Long id, InputStream image) {

    }

    @Override
    public byte[] getImage(Long id) {
        return new byte[0];
    }
}
