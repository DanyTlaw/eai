
package ch.fhnw.wi.eai.bankjd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for holeKontoKorrentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="holeKontoKorrentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vorname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nachname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="land" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ranking" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ibanKontonummer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kontostand" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="bic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "holeKontoKorrentResponse", propOrder = {
    "vorname",
    "nachname",
    "adresse",
    "land",
    "ranking",
    "ibanKontonummer",
    "kontostand",
    "bic"
})
public class HoleKontoKorrentResponse {

    protected String vorname;
    protected String nachname;
    protected String adresse;
    protected String land;
    protected Integer ranking;
    protected String ibanKontonummer;
    protected Float kontostand;
    protected String bic;

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
     * Gets the value of the adresse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Sets the value of the adresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse(String value) {
        this.adresse = value;
    }

    /**
     * Gets the value of the land property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLand() {
        return land;
    }

    /**
     * Sets the value of the land property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLand(String value) {
        this.land = value;
    }

    /**
     * Gets the value of the ranking property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRanking() {
        return ranking;
    }

    /**
     * Sets the value of the ranking property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRanking(Integer value) {
        this.ranking = value;
    }

    /**
     * Gets the value of the ibanKontonummer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIbanKontonummer() {
        return ibanKontonummer;
    }

    /**
     * Sets the value of the ibanKontonummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIbanKontonummer(String value) {
        this.ibanKontonummer = value;
    }

    /**
     * Gets the value of the kontostand property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getKontostand() {
        return kontostand;
    }

    /**
     * Sets the value of the kontostand property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setKontostand(Float value) {
        this.kontostand = value;
    }

    /**
     * Gets the value of the bic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBic() {
        return bic;
    }

    /**
     * Sets the value of the bic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBic(String value) {
        this.bic = value;
    }

}
