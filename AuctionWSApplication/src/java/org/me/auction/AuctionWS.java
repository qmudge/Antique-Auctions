/**
 * Document   : Web service
 * Created on : 15 Jun 2017, 9:03:11 AM
 * Author     : Quintin Mudge
 * Description: Web service that handles all operation requests from AntiqueAuctions web site.
 */
package org.me.auction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 * @author Quintin Mudge 
 * Web service class for Antique Auctions web site.
 */
@WebService(serviceName = "CalculatorWS")
@Stateless()
public class AuctionWS {

    //parameters to use when connecting to the database
    private Connection connection;
    private static final String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=AlphaAuctions;integratedSecurity=true";
    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    PreparedStatement preparedStatement;
    ResultSet result;

    /**
     * @author Quintin Mudge. 
     * Uses SQL driver to connect to database.
     */
    private void makeConnection() {

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(dbURL);
        } catch (SQLException sqle) {
            System.out.println("SQLError " + sqle);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFound " + cnfe);
        }
    }

    /**
     * Web service operation Create a new customer entry if username does not
     * already exist
     *
     * @param username users unique identification,min 3 - max 20 characters
     * @param email email address
     * @param password log in password
     * @param question Gets asked incase user forgets their password.
     * @param answer Must be answered correctly in order to change password.
     * @param telephone contact number
     * @return String value "inserted" if username does not exist else null.
     */
    @WebMethod(operationName = "insertUser")
    public String insertUser(@WebParam(name = "username") String username,
            @WebParam(name = "email") String email,
            @WebParam(name = "password") String password,
            @WebParam(name = "question") String question,
            @WebParam(name = "answer") String answer,
            @WebParam(name = "telephone") String telephone) {

        //query result for username.
        String valueUsername = null;
        makeConnection();

        try {
            // Prepared statement uses connection to make query.          
            preparedStatement = connection.prepareStatement("SELECT username FROM customer"
                    + " WHERE username = ? ");

            preparedStatement.setString(1, username); //set username value
            result = preparedStatement.executeQuery(); //get a result from execution.

            while (result.next()) { //Get all results while query still contains another value.
                valueUsername = result.getString("username");
            }

            preparedStatement.close();
        } catch (SQLException sqle) {
            // print an error if a bad SQL statement is sent 
            System.out.println(sqle);
        }

        if (valueUsername == null) { //user name does not already exist
            try {
                // Prepared statement uses connection to make query.
                preparedStatement = connection.prepareStatement("INSERT INTO customer"
                        + " (username, email, password, question, answer, telephone)"
                        + " VALUES (?, ?, ?, ?, ?, ?)");

                //set query values.
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, question);
                preparedStatement.setString(5, answer);
                preparedStatement.setString(6, telephone);

                preparedStatement.executeUpdate();
                preparedStatement.close();

            } catch (SQLException sqle) {
                // print an error if a bad SQL statement is sent
                System.out.println(sqle);
            }
            username = "inserted";
        }
        return username;
    }

    /**
     * Web service operation, Get all user information where username and
     * password match.
     *
     * @param user users unique login name.
     * @param passWd login password
     * @return String containing all users details.
     * @throws java.io.IOException interruption
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "userNm") String user,
            @WebParam(name = "passWd") String passWd) throws IOException {

        //initiate variables that will store users details. 
        String Username = null;
        String pass = null;
        String userEmail = null;
        String userQuest = null;
        String userAnswer = null;
        String userTel = null;

        makeConnection();

        try {
            // Prepared statement uses connection to make query.
            preparedStatement = connection.prepareStatement("SELECT * FROM customer"
                    + " WHERE username = ? AND password = ?");
            //set query values.
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, passWd);

            result = preparedStatement.executeQuery(); //get a result from execution.

            while (result.next()) { //Get all results while query still contains another value.

                Username = result.getString("username") + "_"; //seperate with underscore.
                pass = result.getString("password") + "_";
                userEmail = result.getString("email") + "_";
                userQuest = result.getString("question") + "_";
                userAnswer = result.getString("answer") + "_";
                userTel = result.getString("telephone") + "_";
            }

            if (Username == null) { //username did not match.
                return "notMatch";
            }

            preparedStatement.close();
        } catch (SQLException sqle) {
            // print an error if a bad SQL statement is sent.
            System.out.println(sqle);
        }
        return Username + pass + userEmail + userQuest + userAnswer + userTel;
    }

    /**
     * Web service operation, Retrieve secret question where users name matches.
     *
     * @param usersname users unique account name.
     * @return String with secret question.
     */
    @WebMethod(operationName = "SecretQuestion")
    public String SecretQuestion(@WebParam(name = "usersname") String usersname) {

        //initiate variable for secret question.
        String question = null;
        makeConnection();

        try {
            // Prepared statement uses connection to make query.
            preparedStatement = connection.prepareStatement("SELECT username, question FROM customer"
                    + " WHERE username = ? ");

            preparedStatement.setString(1, usersname); //set query value.

            result = preparedStatement.executeQuery(); //get a result from execution.

            while (result.next()) { //Get all results while query still contains another value.
                question = result.getString("question");
            }

            preparedStatement.close();
        } catch (SQLException sqle) {
            // print an error if a bad SQL statement is sent
            System.out.println(sqle);
        }
        return question;
    }

    /**
     * Web service operation, change users password if secret question is
     * correct.
     *
     * @param usename users unique login name.
     * @param answer answer to secret question.
     * @param newPassword new password to login to web site.
     * @return String "notSame" if answer is incorrect else null.
     */
    @WebMethod(operationName = "passwordChange")
    public String passwordChange(@WebParam(name = "usename") String usename,
            @WebParam(name = "answer") String answer,
            @WebParam(name = "newPassword") String newPassword) {

        //initiate variables for query result.
        String UsernameResult = null;
        String passResult = null;
        makeConnection();

        try {
            // Prepared statement uses connection to make query.
            preparedStatement = connection.prepareStatement("SELECT username, answer FROM customer"
                    + " WHERE username = ? AND answer = ?");

            preparedStatement.setString(1, usename); //set query values.
            preparedStatement.setString(2, answer);

            result = preparedStatement.executeQuery(); //get a result from execution.

            while (result.next()) { //Get all results while query still contains another value.

                UsernameResult = result.getString("username");
                passResult = result.getString("password");
            }

            preparedStatement.close();
        } catch (SQLException sqle) {
            // print an error if a bad SQL statement is sent
            System.out.println(sqle);
        }

        if (UsernameResult == null) { //answer does not match
            UsernameResult = "notSame";

        } else {
            try {
                // Prepared statement uses connection to make query.
                preparedStatement = connection.prepareStatement("UPDATE customer"
                        + " SET password = ? WHERE username = ?");

                preparedStatement.setString(1, newPassword); //set query values.
                preparedStatement.setString(2, usename);

                preparedStatement.executeUpdate(); //get a result from execution.

                preparedStatement.close();
            } catch (SQLException sqle) {
                // print an error if a bad SQL statement is sent
                System.out.println(sqle);
            }
        }
        return UsernameResult;
    }

    /**
     * Web service operation, insert a new product into database table products.
     *
     * @param productName //items name
     * @param description //short description of the item.
     * @param productPrice //price of the item
     * @param seller //who is the seller of the item.
     * @param dateEnd //closing date for the auction.
     * @return String value, not used.
     */
    @WebMethod(operationName = "product")
    public String product(@WebParam(name = "productName") String productName,
            @WebParam(name = "description") String description,
            @WebParam(name = "productPrice") String productPrice,
            @WebParam(name = "seller") String seller,
            @WebParam(name = "date") String dateEnd) {

        makeConnection();
        //initiate variables for query result.        
        String productID = "";
        int prodID = 0;
        int prodPrice;

        try {
            // change string to int value.
            prodPrice = Integer.parseInt(productPrice);

            // Prepared statement uses connection to make query.            
            preparedStatement = connection.prepareStatement("INSERT INTO product"
                    + " (product_name, description, price, seller, closing_date) VALUES (?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS); //Fetches auto generated id key.

            preparedStatement.setString(1, productName); //set query values.
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, prodPrice);
            preparedStatement.setString(4, seller);
            preparedStatement.setString(5, dateEnd);

            //get a result from execution.
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys(); //auto id field

            if (result.next()) { //selects next available id field value.
                prodID = (int) result.getInt(1);
                productID = String.valueOf(prodID);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            // print an error if a bad SQL statement is sent
            System.out.println(e.toString());
        }
        return productPrice;
    }

    /**
     * Web service operation, Change users account details.
     *
     * @param user users unique login name.
     * @param pass password used to login.
     * @param mail email address
     * @param quest question to ask incase of forgotten password.
     * @param questAnswer answer to secret question.
     * @param userTel contact number.
     * @return String users name.
     */
    @WebMethod(operationName = "updateUser")
    public String updateUser(@WebParam(name = "user") String user,
            @WebParam(name = "pass") String pass,
            @WebParam(name = "mail") String mail,
            @WebParam(name = "quest") String quest,
            @WebParam(name = "questAnswer") String questAnswer,
            @WebParam(name = "userTel") String userTel) {

        makeConnection();

        try {
            // Prepared statement uses connection to make query.
            preparedStatement = connection.prepareStatement("UPDATE customer SET email = ?,"
                    + " password = ?, question = ?, answer = ?, telephone = ? WHERE username = ?");

            preparedStatement.setString(1, mail); //set query values.
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, quest);
            preparedStatement.setString(4, questAnswer);
            preparedStatement.setString(5, userTel);
            preparedStatement.setString(6, user);

            preparedStatement.executeUpdate(); //get a result from execution.

            preparedStatement.close();
        } catch (SQLException sqle) {
            // print an error if a bad SQL statement is sent
            System.out.println(sqle);
        }
        return user;
    }

    /**
     * Web service operation, retrieve a list of products to display as
     * available for auctioning.
     *
     * @param items initiate product retrieval
     * @return String of product id's and product names.
     */
    @WebMethod(operationName = "fetchProducts")
    public String products(@WebParam(name = "products") String items) {

        ArrayList<String> products = new ArrayList<>(); //product names
        ArrayList<Integer> id = new ArrayList<>(); //product id's
        makeConnection();

        try {
            // Prepared statement uses connection to make query.
            preparedStatement = connection.prepareStatement("SELECT product_id, product_name"
                    + " FROM product");

            //get a result from execution.
            result = preparedStatement.executeQuery();

            while (result.next()) { //Get all results while query still contains another value.
                id.add(result.getInt(1));
                products.add(result.getString(2));
            }

            preparedStatement.close();
        } catch (SQLException sqle) {
            // print an error if a bad SQL statement is sent
            System.out.println(sqle);
        }
        return id.toString() + products.toString();
    }

    /**
     * Web service operation, Retrieve product details to display when an item
     * is selected.
     *
     * @param itemID the products unique identity value.
     * @return String containing all items details.
     */
    @WebMethod(operationName = "productDetails")
    public String productDetails(@WebParam(name = "itemID") String itemID) {

        //initiate variables for query result.
        String nameProduct = null;
        String descProduct = null;
        String priceProduct = null;
        String sellerProduct = null;
        String dateEnd = null;

        makeConnection();

        try {
            // Prepared statement uses connection to make query.
            preparedStatement = connection.prepareStatement("SELECT * FROM product"
                    + " WHERE product_id = ? ");

            preparedStatement.setString(1, itemID); //set query values.

            //get a result from execution.
            result = preparedStatement.executeQuery();

            while (result.next()) { //Get all results while query still contains another value.
                nameProduct = result.getString("product_name") + "_";
                descProduct = result.getString("description") + "_";
                priceProduct = result.getString("price") + "_";
                sellerProduct = result.getString("Seller") + "_";
                dateEnd = result.getString("closing_date") + "_";
            }

            preparedStatement.close();
        } catch (SQLException sqle) {
            // print an error if a bad SQL statement is sent
            System.out.println(sqle);
        }
        return itemID + "_" + nameProduct + descProduct + priceProduct + sellerProduct + dateEnd;
    }

    /**
     * Web service operation, Save product bid information into database and log
     * file.
     *
     * @param biddersName users unique login name.
     * @param productID unique identity value.
     * @param bidValue amount that has been bided.
     * @return String with bids information, not used.
     */
    @WebMethod(operationName = "bidMade")
    public String bidMade(@WebParam(name = "biddersName") String biddersName,
            @WebParam(name = "productID") String productID,
            @WebParam(name = "bidValue") String bidValue) {

        makeConnection();
        //initiate variables for query result.
        String bidID = "";
        int bidsID = 0;
        int prodPrice = 0;
        int addProdID = 0;

        try {
            //convert products price and id number into int values.
            prodPrice = Integer.parseInt(bidValue);
            addProdID = Integer.parseInt(productID);

            // Prepared statement uses connection to make query.
            //Fetches auto generated id key.
            preparedStatement = connection.prepareStatement("INSERT INTO bid_info"
                    + " (username, product_id, value) VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, biddersName); //set query values.
            preparedStatement.setInt(2, addProdID);
            preparedStatement.setInt(3, prodPrice);

            //get a result from execution.
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys(); //auto generated id field

            if (result.next()) { //selects next available id field value. 
                bidsID = (int) result.getInt(1);
                bidID = String.valueOf(bidsID);
            }

            preparedStatement.close();

            // Prepared statement uses connection to make query.
            preparedStatement = connection.prepareStatement("UPDATE product "
                    + "SET price = ? WHERE product_id = ? ");

            preparedStatement.setInt(1, prodPrice); //set query values.
            preparedStatement.setInt(2, addProdID);

            //get a result from execution.
            preparedStatement.executeUpdate();
            preparedStatement.close();

            /* Write bid details to log file.     
             */
            try {
                //Todays date at time of bid.
                String dateNow = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new Date());

                //Output appended to file.
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\AuctionWebProject"
                        + "\\AuctionWSApplication\\web\\Bid log file\\Auction.log", true)), true);
                out.println("-------------------------------------------------");
                out.println("Date: " + dateNow); //details to display.
                out.println("Bid ID: " + bidID);
                out.println("Username: " + biddersName);
                out.println("Product ID: " + productID);
                out.println("Bid amount = R" + bidValue);
                out.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (NumberFormatException ex) { // handle your exception
            System.out.println("error here");
        }
        return biddersName + "_" + addProdID + "_" + prodPrice;
    }
}
