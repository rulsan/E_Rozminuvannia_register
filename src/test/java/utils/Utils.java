package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Claim;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    public static List<Map<String, Object>> executeQuery(String query) {

        String url = "jdbc:postgresql://192.168.189.11:5432/postgres";
        String user = "postgres";
        String password = "postgres";
        List<Map<String, Object>> result = new ArrayList<>();

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
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Utils.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
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
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            claims = objectMapper.readValue(fileData, Claim[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return claims;
    }
}