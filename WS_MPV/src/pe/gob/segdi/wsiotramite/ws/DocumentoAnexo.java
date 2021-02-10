/**
 * DocumentoAnexo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsiotramite.ws;

public class DocumentoAnexo  implements java.io.Serializable {
    private java.util.Calendar dfecreg;

    private int siddocanx;

    private int siddocext;

    private java.lang.String vnomdoc;

    public DocumentoAnexo() {
    }

    public DocumentoAnexo(
           java.util.Calendar dfecreg,
           int siddocanx,
           int siddocext,
           java.lang.String vnomdoc) {
           this.dfecreg = dfecreg;
           this.siddocanx = siddocanx;
           this.siddocext = siddocext;
           this.vnomdoc = vnomdoc;
    }


    /**
     * Gets the dfecreg value for this DocumentoAnexo.
     * 
     * @return dfecreg
     */
    public java.util.Calendar getDfecreg() {
        return dfecreg;
    }


    /**
     * Sets the dfecreg value for this DocumentoAnexo.
     * 
     * @param dfecreg
     */
    public void setDfecreg(java.util.Calendar dfecreg) {
        this.dfecreg = dfecreg;
    }


    /**
     * Gets the siddocanx value for this DocumentoAnexo.
     * 
     * @return siddocanx
     */
    public int getSiddocanx() {
        return siddocanx;
    }


    /**
     * Sets the siddocanx value for this DocumentoAnexo.
     * 
     * @param siddocanx
     */
    public void setSiddocanx(int siddocanx) {
        this.siddocanx = siddocanx;
    }


    /**
     * Gets the siddocext value for this DocumentoAnexo.
     * 
     * @return siddocext
     */
    public int getSiddocext() {
        return siddocext;
    }


    /**
     * Sets the siddocext value for this DocumentoAnexo.
     * 
     * @param siddocext
     */
    public void setSiddocext(int siddocext) {
        this.siddocext = siddocext;
    }


    /**
     * Gets the vnomdoc value for this DocumentoAnexo.
     * 
     * @return vnomdoc
     */
    public java.lang.String getVnomdoc() {
        return vnomdoc;
    }


    /**
     * Sets the vnomdoc value for this DocumentoAnexo.
     * 
     * @param vnomdoc
     */
    public void setVnomdoc(java.lang.String vnomdoc) {
        this.vnomdoc = vnomdoc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocumentoAnexo)) return false;
        DocumentoAnexo other = (DocumentoAnexo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dfecreg==null && other.getDfecreg()==null) || 
             (this.dfecreg!=null &&
              this.dfecreg.equals(other.getDfecreg()))) &&
            this.siddocanx == other.getSiddocanx() &&
            this.siddocext == other.getSiddocext() &&
            ((this.vnomdoc==null && other.getVnomdoc()==null) || 
             (this.vnomdoc!=null &&
              this.vnomdoc.equals(other.getVnomdoc())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDfecreg() != null) {
            _hashCode += getDfecreg().hashCode();
        }
        _hashCode += getSiddocanx();
        _hashCode += getSiddocext();
        if (getVnomdoc() != null) {
            _hashCode += getVnomdoc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocumentoAnexo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.wsiotramite.segdi.gob.pe/", "documentoAnexo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dfecreg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dfecreg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siddocanx");
        elemField.setXmlName(new javax.xml.namespace.QName("", "siddocanx"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siddocext");
        elemField.setXmlName(new javax.xml.namespace.QName("", "siddocext"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vnomdoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vnomdoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
