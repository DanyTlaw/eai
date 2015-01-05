
package ch.fhnw.wi.eai.bankjd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for holeKontoKorrent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="holeKontoKorrent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="queryVorname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="queryNachname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "holeKontoKorrent", propOrder = {
    "queryVorname",
    "queryNachname"
})
public class HoleKontoKorrent {

    protected String queryVorname;
    protected String queryNachname;

    /**
     * Gets the value of the queryVorname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryVorname() {
        return queryVorname;
    }

    /**
     * Sets the value of the queryVorname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryVorname(String value) {
        this.queryVorname = value;
    }

    /**
     * Gets the value of the queryNachname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryNachname() {
        return queryNachname;
    }

    /**
     * Sets the value of the queryNachname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryNachname(String value) {
        this.queryNachname = value;
    }

}
