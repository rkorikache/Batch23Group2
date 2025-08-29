package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    public static void main(String[] args) {
        fetch("SELECT * FROM person;");
    }

    // Fetch method to execute any query and return list of rows as maps
    public static List<Map<String, String>> fetch(String query) {
        String dbURL = ConfigReader.read("dbURL");
        String userName = ConfigReader.read("dbUserName");
        String password = ConfigReader.read("dbPassword");

        List<Map<String, String>> tableData = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(dbURL, userName, password)) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsm = rs.getMetaData();

            while (rs.next()) {
                Map<String, String> rowMap = new LinkedHashMap<>();
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    String key = rsm.getColumnLabel(i);
                    String value = rs.getString(i);
                    rowMap.put(key, value);
                }
                tableData.add(rowMap);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return tableData;
    }

    // Returns employee ID if found, null otherwise
    public static String getEmployeeId(String firstName, String lastName) {
        // Escape single quotes to avoid SQL injection
        String escapedFirstName = firstName.replace("'", "''");
        String escapedLastName = lastName.replace("'", "''");

        String query = String.format(
                "SELECT id FROM person WHERE first_name = '%s' AND last_name = '%s';",
                escapedFirstName,
                escapedLastName
        );

        List<Map<String, String>> results = fetch(query);
        if (!results.isEmpty()) {
            return results.get(0).get("id");
        }
        return null;
    }

    // Convenience method to check if employee exists (returns true/false)
    public static boolean isEmployeeInDB(String firstName, String lastName) {
        return getEmployeeId(firstName, lastName) != null;
    }
}
