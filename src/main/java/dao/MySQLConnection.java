package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

    public static void main(String[] args) {
        // MySQL 데이터베이스 연결 정보
        String url = "jdbc:mysql://127.0.0.1:3305/babyDB?useSSL=false";
        String username = "5ey";
        String password = "1234";

        // JDBC 연결 객체
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // MySQL 드라이버 로딩
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            connection = DriverManager.getConnection(url, username, password);

            // SQL 쿼리 실행
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM your_table");

            // 결과 출력
            while (resultSet.next()) {
                // 결과 처리
                // 예시: int id = resultSet.getInt("id");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 연결 해제
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

