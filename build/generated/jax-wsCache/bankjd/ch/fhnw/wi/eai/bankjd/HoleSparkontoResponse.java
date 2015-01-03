
package ch.fhnw.wi.eai.bankjd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for holeSparkontoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="holeSparkontoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vorname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nachname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="strasse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plzOrt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zinsen" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="kontonummer" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="kontostand" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "holeSparkontoResponse", propOrder = {
    "vorname",
    "nachname",
    "strasse",
    "plzOrt",
    "zinsen",
    "kontonummer",
    "kontostand"
})
public class HoleSparkontoResponse {

    protected String vorname;
    protected String nachname;
    protected String strasse;
    protected String plzOrt;
    protected Float zinsen;
    protected Long kontonummer;
    protected Long kontostand;

    /**
     * Gets the value of the vorname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Sets the value of the vorname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVorname(String value) {
        this.vorname = value;
    }

    /**
     * Gets the value of the nachname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * Sets the value of the nachname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNachname(String value) {
        this.nachname = value;
    }

    /**
     * Gets the value of the strasse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrasse() {
        return strasse;
    }

    /**
     * Sets the value of the strasse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrasse(String value) {
        this.strasse = value;
    }

    /**
     * Gets the value of the plzOrt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlzOrt() {
        return plzOrt;
    }

    /**
     * Sets the value of the plzOrt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlzOrt(String value) {
        this.plzOrt = value;
    }

    /**
     * Gets the value of the zinsen property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getZinsen() {
        return zinsen;
    }

    /**
     * Sets the value of the zinsen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setZinsen(Float value) {
        this.zinsen = value;
    }

    /**
     * Gets the value of the kontonummer property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getKontonummer() {
        return kontonummer;
    }

    /**
     * Sets the value of the kontonummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setKontonummer(Long value) {
        this.kontonummer = value;
    }

    /**
     * Gets the value of the kontostand property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getKontostand() {
        return kontostand;
    }

    /**
     * Sets the value of the kontostand property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setKontostand(Long value) {
        this.kontostand = value;
    }

}
