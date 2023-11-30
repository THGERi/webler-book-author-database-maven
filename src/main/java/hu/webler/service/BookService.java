package hu.webler.service;

import hu.webler.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BookService implements DatabaseService<Book> {


    @Override
    public Book save(Book entity, Connection connection) {
        String sql = "INSERT INTO book (title, author_id) VALUES (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entity.getTitle());
            statement.setLong(2, entity.getAuthor().getId());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Book inserted successfully.");
                return entity;
            } else {
                System.out.println("Book insertion failed.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}