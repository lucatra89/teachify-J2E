
package it.univaq.disim.mwt.teachify.presentation.webservice.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per TAvailability complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="TAvailability">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="from" type="{http://www.univaq.t/mwt/soa/Teachify.xsd1}THour"/>
 *         &lt;element name="to" type="{http://www.univaq.t/mwt/soa/Teachify.xsd1}THour"/>
 *         &lt;element name="day" type="{http://www.univaq.t/mwt/soa/Teachify.xsd1}TDay"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAvailability", propOrder = {
    "id",
    "from",
    "to",
    "day"
})
public class TAvailability {

    protected Long id;
    @XmlElement(required = true)
    protected THour from;
    @XmlElement(required = true)
    protected THour to;
    @XmlElement(required = true)
    protected TDay day;

    /**
     * Recupera il valore della proprietà id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta il valore della proprietà id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Recupera il valore della proprietà from.
     * 
     * @return
     *     possible object is
     *     {@link THour }
     *     
     */
    public THour getFrom() {
        return from;
    }

    /**
     * Imposta il valore della proprietà from.
     * 
     * @param value
     *     allowed object is
     *     {@link THour }
     *     
     */
    public void setFrom(THour value) {
        this.from = value;
    }

    /**
     * Recupera il valore della proprietà to.
     * 
     * @return
     *     possible object is
     *     {@link THour }
     *     
     */
    public THour getTo() {
        return to;
    }

    /**
     * Imposta il valore della proprietà to.
     * 
     * @param value
     *     allowed object is
     *     {@link THour }
     *     
     */
    public void setTo(THour value) {
        this.to = value;
    }

    /**
     * Recupera il valore della proprietà day.
     * 
     * @return
     *     possible object is
     *     {@link TDay }
     *     
     */
    public TDay getDay() {
        return day;
    }

    /**
     * Imposta il valore della proprietà day.
     * 
     * @param value
     *     allowed object is
     *     {@link TDay }
     *     
     */
    public void setDay(TDay value) {
        this.day = value;
    }

}
