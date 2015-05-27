
package it.univaq.disim.mwt.teachify.presentation.webservice.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per TTutor complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="TTutor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="location" type="{http://www.univaq.it/mwt/soa/Teachify.xsd1}TLocation" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.univaq.it/mwt/soa/Teachify.xsd1}TPrice" minOccurs="0"/>
 *         &lt;element name="availabilities" type="{http://www.univaq.it/mwt/soa/Teachify.xsd1}TAvailability" maxOccurs="unbounded"/>
 *         &lt;element name="lessons" type="{http://www.univaq.it/mwt/soa/Teachify.xsd1}TLesson" maxOccurs="unbounded"/>
 *         &lt;element name="contact" type="{http://www.univaq.it/mwt/soa/Teachify.xsd1}TContact" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TTutor", propOrder = {
    "id",
    "name",
    "surname",
    "rating",
    "location",
    "price",
    "availabilities",
    "lessons",
    "contact"
})
public class TTutor {

    protected Long id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String surname;
    protected Float rating;
    protected TLocation location;
    protected TPrice price;
    @XmlElement(required = true)
    protected List<TAvailability> availabilities;
    @XmlElement(required = true)
    protected List<TLesson> lessons;
    protected TContact contact;

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
     * Recupera il valore della proprietà name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il valore della proprietà name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Recupera il valore della proprietà surname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Imposta il valore della proprietà surname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Recupera il valore della proprietà rating.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRating() {
        return rating;
    }

    /**
     * Imposta il valore della proprietà rating.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRating(Float value) {
        this.rating = value;
    }

    /**
     * Recupera il valore della proprietà location.
     * 
     * @return
     *     possible object is
     *     {@link TLocation }
     *     
     */
    public TLocation getLocation() {
        return location;
    }

    /**
     * Imposta il valore della proprietà location.
     * 
     * @param value
     *     allowed object is
     *     {@link TLocation }
     *     
     */
    public void setLocation(TLocation value) {
        this.location = value;
    }

    /**
     * Recupera il valore della proprietà price.
     * 
     * @return
     *     possible object is
     *     {@link TPrice }
     *     
     */
    public TPrice getPrice() {
        return price;
    }

    /**
     * Imposta il valore della proprietà price.
     * 
     * @param value
     *     allowed object is
     *     {@link TPrice }
     *     
     */
    public void setPrice(TPrice value) {
        this.price = value;
    }

    /**
     * Gets the value of the availabilities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availabilities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailabilities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TAvailability }
     * 
     * 
     */
    public List<TAvailability> getAvailabilities() {
        if (availabilities == null) {
            availabilities = new ArrayList<TAvailability>();
        }
        return this.availabilities;
    }

    /**
     * Gets the value of the lessons property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lessons property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLessons().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TLesson }
     * 
     * 
     */
    public List<TLesson> getLessons() {
        if (lessons == null) {
            lessons = new ArrayList<TLesson>();
        }
        return this.lessons;
    }

    /**
     * Recupera il valore della proprietà contact.
     * 
     * @return
     *     possible object is
     *     {@link TContact }
     *     
     */
    public TContact getContact() {
        return contact;
    }

    /**
     * Imposta il valore della proprietà contact.
     * 
     * @param value
     *     allowed object is
     *     {@link TContact }
     *     
     */
    public void setContact(TContact value) {
        this.contact = value;
    }

}
