
package it.univaq.disim.mwt.teachify.presentation.webservice.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per TTutorInfoList complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="TTutorInfoList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tutors" type="{http://www.univaq.t/mwt/soa/Teachify.xsd1}TTutorInfo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TTutorInfoList", propOrder = {
    "tutors"
})
public class TTutorInfoList {

    @XmlElement(required = true)
    protected List<TTutorInfo> tutors;

    /**
     * Gets the value of the tutors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tutors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTutors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TTutorInfo }
     * 
     * 
     */
    public List<TTutorInfo> getTutors() {
        if (tutors == null) {
            tutors = new ArrayList<TTutorInfo>();
        }
        return this.tutors;
    }

}
