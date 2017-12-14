
package org.me.auction;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "AuctionWS", targetNamespace = "http://auction.me.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AuctionWS {


    /**
     * 
     * @param mail
     * @param pass
     * @param userTel
     * @param questAnswer
     * @param user
     * @param quest
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateUser", targetNamespace = "http://auction.me.org/", className = "org.me.auction.UpdateUser")
    @ResponseWrapper(localName = "updateUserResponse", targetNamespace = "http://auction.me.org/", className = "org.me.auction.UpdateUserResponse")
    @Action(input = "http://auction.me.org/AuctionWS/updateUserRequest", output = "http://auction.me.org/AuctionWS/updateUserResponse")
    public String updateUser(
        @WebParam(name = "user", targetNamespace = "")
        String user,
        @WebParam(name = "pass", targetNamespace = "")
        String pass,
        @WebParam(name = "mail", targetNamespace = "")
        String mail,
        @WebParam(name = "quest", targetNamespace = "")
        String quest,
        @WebParam(name = "questAnswer", targetNamespace = "")
        String questAnswer,
        @WebParam(name = "userTel", targetNamespace = "")
        String userTel);

    /**
     * 
     * @param userNm
     * @param passWd
     * @return
     *     returns java.lang.String
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://auction.me.org/", className = "org.me.auction.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://auction.me.org/", className = "org.me.auction.LoginResponse")
    @Action(input = "http://auction.me.org/AuctionWS/loginRequest", output = "http://auction.me.org/AuctionWS/loginResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://auction.me.org/AuctionWS/login/Fault/IOException")
    })
    public String login(
        @WebParam(name = "userNm", targetNamespace = "")
        String userNm,
        @WebParam(name = "passWd", targetNamespace = "")
        String passWd)
        throws IOException_Exception
    ;

    /**
     * 
     * @param usersname
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "SecretQuestion")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "SecretQuestion", targetNamespace = "http://auction.me.org/", className = "org.me.auction.SecretQuestion")
    @ResponseWrapper(localName = "SecretQuestionResponse", targetNamespace = "http://auction.me.org/", className = "org.me.auction.SecretQuestionResponse")
    @Action(input = "http://auction.me.org/AuctionWS/SecretQuestionRequest", output = "http://auction.me.org/AuctionWS/SecretQuestionResponse")
    public String secretQuestion(
        @WebParam(name = "usersname", targetNamespace = "")
        String usersname);

    /**
     * 
     * @param answer
     * @param newPassword
     * @param usename
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "passwordChange", targetNamespace = "http://auction.me.org/", className = "org.me.auction.PasswordChange")
    @ResponseWrapper(localName = "passwordChangeResponse", targetNamespace = "http://auction.me.org/", className = "org.me.auction.PasswordChangeResponse")
    @Action(input = "http://auction.me.org/AuctionWS/passwordChangeRequest", output = "http://auction.me.org/AuctionWS/passwordChangeResponse")
    public String passwordChange(
        @WebParam(name = "usename", targetNamespace = "")
        String usename,
        @WebParam(name = "answer", targetNamespace = "")
        String answer,
        @WebParam(name = "newPassword", targetNamespace = "")
        String newPassword);

    /**
     * 
     * @param products
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "fetchProducts", targetNamespace = "http://auction.me.org/", className = "org.me.auction.FetchProducts")
    @ResponseWrapper(localName = "fetchProductsResponse", targetNamespace = "http://auction.me.org/", className = "org.me.auction.FetchProductsResponse")
    @Action(input = "http://auction.me.org/AuctionWS/fetchProductsRequest", output = "http://auction.me.org/AuctionWS/fetchProductsResponse")
    public String fetchProducts(
        @WebParam(name = "products", targetNamespace = "")
        String products);

    /**
     * 
     * @param productID
     * @param bidValue
     * @param biddersName
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "bidMade", targetNamespace = "http://auction.me.org/", className = "org.me.auction.BidMade")
    @ResponseWrapper(localName = "bidMadeResponse", targetNamespace = "http://auction.me.org/", className = "org.me.auction.BidMadeResponse")
    @Action(input = "http://auction.me.org/AuctionWS/bidMadeRequest", output = "http://auction.me.org/AuctionWS/bidMadeResponse")
    public String bidMade(
        @WebParam(name = "biddersName", targetNamespace = "")
        String biddersName,
        @WebParam(name = "productID", targetNamespace = "")
        String productID,
        @WebParam(name = "bidValue", targetNamespace = "")
        String bidValue);

    /**
     * 
     * @param itemID
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "productDetails", targetNamespace = "http://auction.me.org/", className = "org.me.auction.ProductDetails")
    @ResponseWrapper(localName = "productDetailsResponse", targetNamespace = "http://auction.me.org/", className = "org.me.auction.ProductDetailsResponse")
    @Action(input = "http://auction.me.org/AuctionWS/productDetailsRequest", output = "http://auction.me.org/AuctionWS/productDetailsResponse")
    public String productDetails(
        @WebParam(name = "itemID", targetNamespace = "")
        String itemID);

    /**
     * 
     * @param seller
     * @param date
     * @param description
     * @param productName
     * @param productPrice
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "product", targetNamespace = "http://auction.me.org/", className = "org.me.auction.Product")
    @ResponseWrapper(localName = "productResponse", targetNamespace = "http://auction.me.org/", className = "org.me.auction.ProductResponse")
    @Action(input = "http://auction.me.org/AuctionWS/productRequest", output = "http://auction.me.org/AuctionWS/productResponse")
    public String product(
        @WebParam(name = "productName", targetNamespace = "")
        String productName,
        @WebParam(name = "description", targetNamespace = "")
        String description,
        @WebParam(name = "productPrice", targetNamespace = "")
        String productPrice,
        @WebParam(name = "seller", targetNamespace = "")
        String seller,
        @WebParam(name = "date", targetNamespace = "")
        String date);

    /**
     * 
     * @param password
     * @param question
     * @param answer
     * @param telephone
     * @param email
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertUser", targetNamespace = "http://auction.me.org/", className = "org.me.auction.InsertUser")
    @ResponseWrapper(localName = "insertUserResponse", targetNamespace = "http://auction.me.org/", className = "org.me.auction.InsertUserResponse")
    @Action(input = "http://auction.me.org/AuctionWS/insertUserRequest", output = "http://auction.me.org/AuctionWS/insertUserResponse")
    public String insertUser(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "question", targetNamespace = "")
        String question,
        @WebParam(name = "answer", targetNamespace = "")
        String answer,
        @WebParam(name = "telephone", targetNamespace = "")
        String telephone);

}