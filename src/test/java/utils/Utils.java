package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import pojo.Claim;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    private final static org.apache.logging.log4j.Logger logger = LogManager.getLogger();

    public static List<Map<String,Object>> executeQuery(String query) {

        String url = "jdbc:postgresql://192.168.189.11:5432/postgres";
        String user = "postgres";
        String password = "postgres";
        List<Map<String,Object>> result = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Map<String, Object> resMap = new HashMap<>();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    resMap.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
                }
                result.add(resMap);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return result;
    }

    public static Claim[] getClaimsFromFile(){
        String fileData;
        Claim[] claims;
        ObjectMapper objectMapper = new ObjectMapper();
        try(BufferedReader br = new BufferedReader(new FileReader("src\\test\\resources\\listOfClaims.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line.trim());
                line = br.readLine();
            }

            fileData = sb.toString();
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
        try {
            claims = objectMapper.readValue(fileData, Claim[].class);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return claims;
    }
}
