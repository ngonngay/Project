package vn.edu.vtc.dal;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtil {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/SEM1_PJ_G4";
    private static String user = "group4";
    private static String password = "test";

    private DbUtil() {
        throw new IllegalStateException("Can't init DbUtil instance!");
    }

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static Connection getConnection(final String dbConfigFile) throws SQLException {
        try (FileInputStream f = new FileInputStream(dbConfigFile)) {
            // load the properties file
            final Properties pros = new Properties();
            pros.load(f);
            // assign db parameters
            url = pros.getProperty("url");
            user = pros.getProperty("user");
            password = pros.getProperty("password");
            // create a connection to the database
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (final IOException e) {
            throw new SQLException();
        }
    }

    public static Connection getConnection(final String url, final String user, final String password)
            throws SQLException {
        DbUtil.url = url;
        DbUtil.user = user;
        DbUtil.password = password;
        return getConnection();
    }

    public static boolean executeStatement(final String sql) {
        boolean exeResult = false;
        try (Statement stm = DbUtil.getConnection().createStatement();) {
            exeResult = stm.execute(sql);
        } catch (final SQLException e) {
            exeResult = false;
        }
        return exeResult;
    }

    public static int executeBatch(final String[] sqls) {
        int resultNo = 0;
        try (Statement stm = DbUtil.getConnection().createStatement();) {
            for (final String sql : sqls) {
                stm.addBatch(sql);
            }
            final int[] executeResult = stm.executeBatch();
            for (final int i : executeResult) {
                resultNo += i;
            }
        } catch (final Exception e) {
            resultNo = 0;
        }
        return resultNo;
    }
}