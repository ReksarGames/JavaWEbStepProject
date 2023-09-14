package Tinder.dao;

import Tinder.model.UserProfile;
import Tinder.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserProfileDAO {
    public List<UserProfile> getAllProfiles() {
        List<UserProfile> profiles = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_profiles");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String photoUrl = resultSet.getString("photo_url");
                UserProfile profile = new UserProfile(id, name, photoUrl);
                profiles.add(profile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profiles;
    }
    public UserProfile getUserByUsername(String username) {
        UserProfile userProfile = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM user_profiles WHERE name = ?")) {

            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String photoUrl = resultSet.getString("photo_url");
                    userProfile = new UserProfile(id, name, photoUrl);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userProfile;
    }


    public void saveUserChoice(int profileId, String choice) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO user_choices (profile_id, choice) VALUES (?, ?)")) {

            statement.setInt(1, profileId);
            statement.setString(2, choice);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<UserProfile> getLikedProfiles() {
        List<UserProfile> likedProfiles = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT p.* FROM user_profiles p JOIN user_choices c ON p.id = c.profile_id WHERE c.choice = 'yes'");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String photoUrl = resultSet.getString("photo_url");
                UserProfile profile = new UserProfile(id, name, photoUrl);
                likedProfiles.add(profile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return likedProfiles;
    }
}
