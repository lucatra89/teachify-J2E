
package it.univaq.disim.mwt.teachify.presentation.webservice.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per TLesson complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="TLesson">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="subject" type="{http://www.univaq.it/mwt/soa/Teachify.xsd1}TSubject"/>
 *         &lt;element name="typeOfEducation" type="{http://www.univaq.it/mwt/soa/Teachify.xsd1}TTypeOfEducation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TLesson", propOrder = {
    "id",
    "subject",
    "typeOfEducation"
})
public class TLesson {

    protected long id;
    @XmlElement(required = true)
    protected TSubject subject;
    protected TTypeOfEducation typeOfEducation;

    /**
     * Recupera il valore della proprietà id.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Imposta il valore della proprietà id.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Recupera il valore della proprietà subject.
     * 
     * @return
     *     possible object is
     *     {@link TSubject }
     *     
     */
    public TSubject getSubject() {
        return subject;
    }

    /**
     * Imposta il valore della proprietà subject.
     * 
     * @param value
     *     allowed object is
     *     {@link TSubject }
     *     
     */
    public void setSubject(TSubject value) {
        this.subject = value;
    }

    /**
     * Recupera il valore della proprietà typeOfEducation.
     * 
     * @return
     *     possible object is
     *     {@link TTypeOfEducation }
     *     
     */
    public TTypeOfEducation getTypeOfEducation() {
        return typeOfEducation;
    }

    /**
     * Imposta il valore della proprietà typeOfEducation.
     * 
     * @param value
     *     allowed object is
     *     {@link TTypeOfEducation }
     *     
     */
    public void setTypeOfEducation(TTypeOfEducation value) {
        this.typeOfEducation = value;
    }

}
