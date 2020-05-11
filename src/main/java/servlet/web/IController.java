package servlet.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface IController {
    void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException;
    void updatee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException;
    void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException;
    void deletee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException;
    void home(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException;
}
