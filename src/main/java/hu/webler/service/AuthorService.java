package hu.webler.service;

import hu.webler.entity.Author;

import java.sql.*;

public class AuthorService implements DatabaseService<Author> {


    @Override
    public Author save(Author entity, Connection connection) {
        String sql = "INSERT INTO author (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entity.getName());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        entity.setId(generatedKeys.getLong(1));
                    }
                }
                System.out.println("Data inserted successfully.");
                return entity;
            } else {
                System.out.println("Data insertion failed.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}