
package org.me.auction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for login complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="login"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="userNm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="passWd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "login", propOrder = {
    "userNm",
    "passWd"
})
public class Login {

    protected String userNm;
    protected String passWd;

    /**
     * Gets the value of the userNm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserNm() {
        return userNm;
    }

    /**
     * Sets the value of the userNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserNm(String value) {
        this.userNm = value;
    }

    /**
     * Gets the value of the passWd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassWd() {
        return passWd;
    }

    /**
     * Sets the value of the passWd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassWd(String value) {
        this.passWd = value;
    }

}
