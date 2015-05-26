
package it.univaq.disim.mwt.teachify.presentation.webservice.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per TRequest complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="TRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="user" type="{http://www.univaq.t/mwt/soa/Teachify.xsd1}TUser"/>
 *         &lt;element name="tutor" type="{http://www.univaq.t/mwt/soa/Teachify.xsd1}TTutor"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.univaq.t/mwt/soa/Teachify.xsd1}TStatusRequest" minOccurs="0"/>
 *         &lt;element name="createdAt" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRequest", propOrder = {
    "id",
    "user",
    "tutor",
    "description",
    "status",
    "createdAt"
})
public class TRequest {

    protected Long id;
    @XmlElement(required = true)
    protected TUser user;
    @XmlElement(required = true)
    protected TTutor tutor;
    protected String description;
    protected TStatusRequest status;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar createdAt;

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
     * Recupera il valore della proprietà user.
     * 
     * @return
     *     possible object is
     *     {@link TUser }
     *     
     */
    public TUser getUser() {
        return user;
    }

    /**
     * Imposta il valore della proprietà user.
     * 
     * @param value
     *     allowed object is
     *     {@link TUser }
     *     
     */
    public void setUser(TUser value) {
        this.user = value;
    }

    /**
     * Recupera il valore della proprietà tutor.
     * 
     * @return
     *     possible object is
     *     {@link TTutor }
     *     
     */
    public TTutor getTutor() {
        return tutor;
    }

    /**
     * Imposta il valore della proprietà tutor.
     * 
     * @param value
     *     allowed object is
     *     {@link TTutor }
     *     
     */
    public void setTutor(TTutor value) {
        this.tutor = value;
    }

    /**
     * Recupera il valore della proprietà description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Imposta il valore della proprietà description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Recupera il valore della proprietà status.
     * 
     * @return
     *     possible object is
     *     {@link TStatusRequest }
     *     
     */
    public TStatusRequest getStatus() {
        return status;
    }

    /**
     * Imposta il valore della proprietà status.
     * 
     * @param value
     *     allowed object is
     *     {@link TStatusRequest }
     *     
     */
    public void setStatus(TStatusRequest value) {
        this.status = value;
    }

    /**
     * Recupera il valore della proprietà createdAt.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedAt() {
        return createdAt;
    }

    /**
     * Imposta il valore della proprietà createdAt.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedAt(XMLGregorianCalendar value) {
        this.createdAt = value;
    }

}
