
package ch.fhnw.wi.eai.bankjd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ch.fhnw.wi.eai.bankjd package. 
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

    private final static QName _PrintSparkontoResponse_QNAME = new QName("http://www.fhnw.ch/wi/eai/bankjd/", "printSparkontoResponse");
    private final static QName _PrintKontokorrent_QNAME = new QName("http://www.fhnw.ch/wi/eai/bankjd/", "printKontokorrent");
    private final static QName _HoleSparkontoResponse_QNAME = new QName("http://www.fhnw.ch/wi/eai/bankjd/", "holeSparkontoResponse");
    private final static QName _HoleSparkonto_QNAME = new QName("http://www.fhnw.ch/wi/eai/bankjd/", "holeSparkonto");
    private final static QName _PrintSparkonto_QNAME = new QName("http://www.fhnw.ch/wi/eai/bankjd/", "printSparkonto");
    private final static QName _PrintKontokorrentResponse_QNAME = new QName("http://www.fhnw.ch/wi/eai/bankjd/", "printKontokorrentResponse");
    private final static QName _ListeSparkontoNachnameResponse_QNAME = new QName("http://www.fhnw.ch/wi/eai/bankjd/", "listeSparkontoNachnameResponse");
    private final static QName _ListeSparkontoNachname_QNAME = new QName("http://www.fhnw.ch/wi/eai/bankjd/", "listeSparkontoNachname");
    private final static QName _HoleKontoKorrentResponse_QNAME = new QName("http://www.fhnw.ch/wi/eai/bankjd/", "holeKontoKorrentResponse");
    private final static QName _ListeKontokorrentNachname_QNAME = new QName("http://www.fhnw.ch/wi/eai/bankjd/", "listeKontokorrentNachname");
    private final static QName _ListeKontokorrentNachnameResponse_QNAME = new QName("http://www.fhnw.ch/wi/eai/bankjd/", "listeKontokorrentNachnameResponse");
    private final static QName _HoleKontoKorrent_QNAME = new QName("http://www.fhnw.ch/wi/eai/bankjd/", "holeKontoKorrent");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ch.fhnw.wi.eai.bankjd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PrintSparkonto }
     * 
     */
    public PrintSparkonto createPrintSparkonto() {
        return new PrintSparkonto();
    }

    /**
     * Create an instance of {@link HoleSparkonto }
     * 
     */
    public HoleSparkonto createHoleSparkonto() {
        return new HoleSparkonto();
    }

    /**
     * Create an instance of {@link ListeSparkontoNachnameResponse }
     * 
     */
    public ListeSparkontoNachnameResponse createListeSparkontoNachnameResponse() {
        return new ListeSparkontoNachnameResponse();
    }

    /**
     * Create an instance of {@link PrintKontokorrentResponse }
     * 
     */
    public PrintKontokorrentResponse createPrintKontokorrentResponse() {
        return new PrintKontokorrentResponse();
    }

    /**
     * Create an instance of {@link PrintSparkontoResponse }
     * 
     */
    public PrintSparkontoResponse createPrintSparkontoResponse() {
        return new PrintSparkontoResponse();
    }

    /**
     * Create an instance of {@link HoleSparkontoResponse }
     * 
     */
    public HoleSparkontoResponse createHoleSparkontoResponse() {
        return new HoleSparkontoResponse();
    }

    /**
     * Create an instance of {@link PrintKontokorrent }
     * 
     */
    public PrintKontokorrent createPrintKontokorrent() {
        return new PrintKontokorrent();
    }

    /**
     * Create an instance of {@link ListeKontokorrentNachnameResponse }
     * 
     */
    public ListeKontokorrentNachnameResponse createListeKontokorrentNachnameResponse() {
        return new ListeKontokorrentNachnameResponse();
    }

    /**
     * Create an instance of {@link HoleKontoKorrent }
     * 
     */
    public HoleKontoKorrent createHoleKontoKorrent() {
        return new HoleKontoKorrent();
    }

    /**
     * Create an instance of {@link ListeSparkontoNachname }
     * 
     */
    public ListeSparkontoNachname createListeSparkontoNachname() {
        return new ListeSparkontoNachname();
    }

    /**
     * Create an instance of {@link HoleKontoKorrentResponse }
     * 
     */
    public HoleKontoKorrentResponse createHoleKontoKorrentResponse() {
        return new HoleKontoKorrentResponse();
    }

    /**
     * Create an instance of {@link ListeKontokorrentNachname }
     * 
     */
    public ListeKontokorrentNachname createListeKontokorrentNachname() {
        return new ListeKontokorrentNachname();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintSparkontoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.fhnw.ch/wi/eai/bankjd/", name = "printSparkontoResponse")
    public JAXBElement<PrintSparkontoResponse> createPrintSparkontoResponse(PrintSparkontoResponse value) {
        return new JAXBElement<PrintSparkontoResponse>(_PrintSparkontoResponse_QNAME, PrintSparkontoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintKontokorrent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.fhnw.ch/wi/eai/bankjd/", name = "printKontokorrent")
    public JAXBElement<PrintKontokorrent> createPrintKontokorrent(PrintKontokorrent value) {
        return new JAXBElement<PrintKontokorrent>(_PrintKontokorrent_QNAME, PrintKontokorrent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HoleSparkontoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.fhnw.ch/wi/eai/bankjd/", name = "holeSparkontoResponse")
    public JAXBElement<HoleSparkontoResponse> createHoleSparkontoResponse(HoleSparkontoResponse value) {
        return new JAXBElement<HoleSparkontoResponse>(_HoleSparkontoResponse_QNAME, HoleSparkontoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HoleSparkonto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.fhnw.ch/wi/eai/bankjd/", name = "holeSparkonto")
    public JAXBElement<HoleSparkonto> createHoleSparkonto(HoleSparkonto value) {
        return new JAXBElement<HoleSparkonto>(_HoleSparkonto_QNAME, HoleSparkonto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintSparkonto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.fhnw.ch/wi/eai/bankjd/", name = "printSparkonto")
    public JAXBElement<PrintSparkonto> createPrintSparkonto(PrintSparkonto value) {
        return new JAXBElement<PrintSparkonto>(_PrintSparkonto_QNAME, PrintSparkonto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintKontokorrentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.fhnw.ch/wi/eai/bankjd/", name = "printKontokorrentResponse")
    public JAXBElement<PrintKontokorrentResponse> createPrintKontokorrentResponse(PrintKontokorrentResponse value) {
        return new JAXBElement<PrintKontokorrentResponse>(_PrintKontokorrentResponse_QNAME, PrintKontokorrentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeSparkontoNachnameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.fhnw.ch/wi/eai/bankjd/", name = "listeSparkontoNachnameResponse")
    public JAXBElement<ListeSparkontoNachnameResponse> createListeSparkontoNachnameResponse(ListeSparkontoNachnameResponse value) {
        return new JAXBElement<ListeSparkontoNachnameResponse>(_ListeSparkontoNachnameResponse_QNAME, ListeSparkontoNachnameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeSparkontoNachname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.fhnw.ch/wi/eai/bankjd/", name = "listeSparkontoNachname")
    public JAXBElement<ListeSparkontoNachname> createListeSparkontoNachname(ListeSparkontoNachname value) {
        return new JAXBElement<ListeSparkontoNachname>(_ListeSparkontoNachname_QNAME, ListeSparkontoNachname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HoleKontoKorrentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.fhnw.ch/wi/eai/bankjd/", name = "holeKontoKorrentResponse")
    public JAXBElement<HoleKontoKorrentResponse> createHoleKontoKorrentResponse(HoleKontoKorrentResponse value) {
        return new JAXBElement<HoleKontoKorrentResponse>(_HoleKontoKorrentResponse_QNAME, HoleKontoKorrentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeKontokorrentNachname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.fhnw.ch/wi/eai/bankjd/", name = "listeKontokorrentNachname")
    public JAXBElement<ListeKontokorrentNachname> createListeKontokorrentNachname(ListeKontokorrentNachname value) {
        return new JAXBElement<ListeKontokorrentNachname>(_ListeKontokorrentNachname_QNAME, ListeKontokorrentNachname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListeKontokorrentNachnameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.fhnw.ch/wi/eai/bankjd/", name = "listeKontokorrentNachnameResponse")
    public JAXBElement<ListeKontokorrentNachnameResponse> createListeKontokorrentNachnameResponse(ListeKontokorrentNachnameResponse value) {
        return new JAXBElement<ListeKontokorrentNachnameResponse>(_ListeKontokorrentNachnameResponse_QNAME, ListeKontokorrentNachnameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HoleKontoKorrent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.fhnw.ch/wi/eai/bankjd/", name = "holeKontoKorrent")
    public JAXBElement<HoleKontoKorrent> createHoleKontoKorrent(HoleKontoKorrent value) {
        return new JAXBElement<HoleKontoKorrent>(_HoleKontoKorrent_QNAME, HoleKontoKorrent.class, null, value);
    }

}
