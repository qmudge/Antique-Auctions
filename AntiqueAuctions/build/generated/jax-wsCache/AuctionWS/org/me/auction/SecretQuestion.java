
package org.me.auction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SecretQuestion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecretQuestion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usersname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecretQuestion", propOrder = {
    "usersname"
})
public class SecretQuestion {

    protected String usersname;

    /**
     * Gets the value of the usersname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsersname() {
        return usersname;
    }

    /**
     * Sets the value of the usersname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsersname(String value) {
        this.usersname = value;
    }

}
