package test.java.dbtojson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.databaseutil.DBManager;
import main.java.databaseutil.DBUtility;
import main.java.pojo.CustomerDetailsDBpojo;
import org.apache.commons.lang3.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DbJsonTest {

         ArrayList<CustomerDetailsDBpojo> customerDetailsList = new ArrayList<>();

        @Test(enabled=false)
        public void test() throws SQLException, ClassNotFoundException {
           // Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Business","root","root");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from CustomerInfo");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }

    @Test(enabled=false)
    public void test1() throws SQLException, ClassNotFoundException, IOException {
        ResultSet rs = DBUtility.SelectQueryResult("Select * from CustomerInfo");
        while(rs.next()){
            CustomerDetailsDBpojo cd = new CustomerDetailsDBpojo();
            cd.setCourseName(rs.getString(1));
            cd.setPurchaseDate(rs.getString(2));
            cd.setAmount(rs.getInt(3));
            cd.setLocation(rs.getString(4));
            customerDetailsList.add(cd);
        }

        for(int i=0;i<customerDetailsList.size();i++) {
            ObjectMapper om = new ObjectMapper();
            try {
                om.writeValue(new File("C:\\IRepo\\fullstack\\src\\main\\resources\\testjson"+i+".json"), customerDetailsList.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test(enabled=false)
    public void mergeintosingle() throws SQLException, ClassNotFoundException, IOException {
        ResultSet rs = DBUtility.SelectQueryResult("Select * from CustomerInfo");
        while(rs.next()){
            CustomerDetailsDBpojo cd = new CustomerDetailsDBpojo();
            cd.setCourseName(rs.getString(1));
            cd.setPurchaseDate(rs.getString(2));
            cd.setAmount(rs.getInt(3));
            cd.setLocation(rs.getString(4));
            customerDetailsList.add(cd);
        }
        JSONArray jarray = new JSONArray();

        for(int i=0;i<customerDetailsList.size();i++) {
            ObjectMapper om = new ObjectMapper();
            try {
                om.writeValue(new File("C:\\IRepo\\fullstack\\src\\main\\resources\\testjson"+i+".json"), customerDetailsList.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }

            String jsonString = om.writeValueAsString(customerDetailsList.get(i));
            jarray.add(jsonString);
        }
        JSONObject jsobobj =  new JSONObject();
        jsobobj.put("data",jarray);
        System.out.println(StringEscapeUtils.unescapeJson(jsobobj.toJSONString()));

    }

    @Test(enabled = true)
    public void testjsonString() throws JsonProcessingException {
        CustomerDetailsDBpojo cd = new CustomerDetailsDBpojo();
            String json = "{\"courseName\":\"selenium\",\"purchaseDate\":\"2021-03-28\",\"amount\":120,\"location\":\"Africa\"}";
            ObjectMapper om = new ObjectMapper();
        try {
           cd = om.readValue(json,CustomerDetailsDBpojo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        cd.setCourseName("newcourse");
        String jsonString = om.writeValueAsString(cd);
        System.out.println(jsonString);
    }

    @AfterTest
    public void closeConnection() throws SQLException {
        DBManager.closeConnection();
    }
    }

