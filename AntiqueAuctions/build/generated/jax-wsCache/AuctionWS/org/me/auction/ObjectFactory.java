
package org.me.auction;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.me.auction package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IOException_QNAME = new QName("http://auction.me.org/", "IOException");
    private final static QName _SecretQuestion_QNAME = new QName("http://auction.me.org/", "SecretQuestion");
    private final static QName _SecretQuestionResponse_QNAME = new QName("http://auction.me.org/", "SecretQuestionResponse");
    private final static QName _BidMade_QNAME = new QName("http://auction.me.org/", "bidMade");
    private final static QName _BidMadeResponse_QNAME = new QName("http://auction.me.org/", "bidMadeResponse");
    private final static QName _FetchProducts_QNAME = new QName("http://auction.me.org/", "fetchProducts");
    private final static QName _FetchProductsResponse_QNAME = new QName("http://auction.me.org/", "fetchProductsResponse");
    private final static QName _InsertUser_QNAME = new QName("http://auction.me.org/", "insertUser");
    private final static QName _InsertUserResponse_QNAME = new QName("http://auction.me.org/", "insertUserResponse");
    private final static QName _Login_QNAME = new QName("http://auction.me.org/", "login");
    private final static QName _LoginResponse_QNAME = new QName("http://auction.me.org/", "loginResponse");
    private final static QName _PasswordChange_QNAME = new QName("http://auction.me.org/", "passwordChange");
    private final static QName _PasswordChangeResponse_QNAME = new QName("http://auction.me.org/", "passwordChangeResponse");
    private final static QName _Product_QNAME = new QName("http://auction.me.org/", "product");
    private final static QName _ProductDetails_QNAME = new QName("http://auction.me.org/", "productDetails");
    private final static QName _ProductDetailsResponse_QNAME = new QName("http://auction.me.org/", "productDetailsResponse");
    private final static QName _ProductResponse_QNAME = new QName("http://auction.me.org/", "productResponse");
    private final static QName _UpdateUser_QNAME = new QName("http://auction.me.org/", "updateUser");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://auction.me.org/", "updateUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.me.auction
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link SecretQuestion }
     * 
     */
    public SecretQuestion createSecretQuestion() {
        return new SecretQuestion();
    }

    /**
     * Create an instance of {@link SecretQuestionResponse }
     * 
     */
    public SecretQuestionResponse createSecretQuestionResponse() {
        return new SecretQuestionResponse();
    }

    /**
     * Create an instance of {@link BidMade }
     * 
     */
    public BidMade createBidMade() {
        return new BidMade();
    }

    /**
     * Create an instance of {@link BidMadeResponse }
     * 
     */
    public BidMadeResponse createBidMadeResponse() {
        return new BidMadeResponse();
    }

    /**
     * Create an instance of {@link FetchProducts }
     * 
     */
    public FetchProducts createFetchProducts() {
        return new FetchProducts();
    }

    /**
     * Create an instance of {@link FetchProductsResponse }
     * 
     */
    public FetchProductsResponse createFetchProductsResponse() {
        return new FetchProductsResponse();
    }

    /**
     * Create an instance of {@link InsertUser }
     * 
     */
    public InsertUser createInsertUser() {
        return new InsertUser();
    }

    /**
     * Create an instance of {@link InsertUserResponse }
     * 
     */
    public InsertUserResponse createInsertUserResponse() {
        return new InsertUserResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link PasswordChange }
     * 
     */
    public PasswordChange createPasswordChange() {
        return new PasswordChange();
    }

    /**
     * Create an instance of {@link PasswordChangeResponse }
     * 
     */
    public PasswordChangeResponse createPasswordChangeResponse() {
        return new PasswordChangeResponse();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link ProductDetails }
     * 
     */
    public ProductDetails createProductDetails() {
        return new ProductDetails();
    }

    /**
     * Create an instance of {@link ProductDetailsResponse }
     * 
     */
    public ProductDetailsResponse createProductDetailsResponse() {
        return new ProductDetailsResponse();
    }

    /**
     * Create an instance of {@link ProductResponse }
     * 
     */
    public ProductResponse createProductResponse() {
        return new ProductResponse();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecretQuestion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "SecretQuestion")
    public JAXBElement<SecretQuestion> createSecretQuestion(SecretQuestion value) {
        return new JAXBElement<SecretQuestion>(_SecretQuestion_QNAME, SecretQuestion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecretQuestionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "SecretQuestionResponse")
    public JAXBElement<SecretQuestionResponse> createSecretQuestionResponse(SecretQuestionResponse value) {
        return new JAXBElement<SecretQuestionResponse>(_SecretQuestionResponse_QNAME, SecretQuestionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BidMade }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "bidMade")
    public JAXBElement<BidMade> createBidMade(BidMade value) {
        return new JAXBElement<BidMade>(_BidMade_QNAME, BidMade.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BidMadeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "bidMadeResponse")
    public JAXBElement<BidMadeResponse> createBidMadeResponse(BidMadeResponse value) {
        return new JAXBElement<BidMadeResponse>(_BidMadeResponse_QNAME, BidMadeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "fetchProducts")
    public JAXBElement<FetchProducts> createFetchProducts(FetchProducts value) {
        return new JAXBElement<FetchProducts>(_FetchProducts_QNAME, FetchProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "fetchProductsResponse")
    public JAXBElement<FetchProductsResponse> createFetchProductsResponse(FetchProductsResponse value) {
        return new JAXBElement<FetchProductsResponse>(_FetchProductsResponse_QNAME, FetchProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "insertUser")
    public JAXBElement<InsertUser> createInsertUser(InsertUser value) {
        return new JAXBElement<InsertUser>(_InsertUser_QNAME, InsertUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "insertUserResponse")
    public JAXBElement<InsertUserResponse> createInsertUserResponse(InsertUserResponse value) {
        return new JAXBElement<InsertUserResponse>(_InsertUserResponse_QNAME, InsertUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordChange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "passwordChange")
    public JAXBElement<PasswordChange> createPasswordChange(PasswordChange value) {
        return new JAXBElement<PasswordChange>(_PasswordChange_QNAME, PasswordChange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswordChangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "passwordChangeResponse")
    public JAXBElement<PasswordChangeResponse> createPasswordChangeResponse(PasswordChangeResponse value) {
        return new JAXBElement<PasswordChangeResponse>(_PasswordChangeResponse_QNAME, PasswordChangeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "product")
    public JAXBElement<Product> createProduct(Product value) {
        return new JAXBElement<Product>(_Product_QNAME, Product.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "productDetails")
    public JAXBElement<ProductDetails> createProductDetails(ProductDetails value) {
        return new JAXBElement<ProductDetails>(_ProductDetails_QNAME, ProductDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "productDetailsResponse")
    public JAXBElement<ProductDetailsResponse> createProductDetailsResponse(ProductDetailsResponse value) {
        return new JAXBElement<ProductDetailsResponse>(_ProductDetailsResponse_QNAME, ProductDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "productResponse")
    public JAXBElement<ProductResponse> createProductResponse(ProductResponse value) {
        return new JAXBElement<ProductResponse>(_ProductResponse_QNAME, ProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://auction.me.org/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

}
