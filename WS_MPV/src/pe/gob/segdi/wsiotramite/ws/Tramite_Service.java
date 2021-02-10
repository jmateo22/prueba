/**
 * Tramite_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsiotramite.ws;

public interface Tramite_Service extends javax.xml.rpc.Service {
    public java.lang.String getTramitePortAddress();

    public pe.gob.segdi.wsiotramite.ws.Tramite_PortType getTramitePort() throws javax.xml.rpc.ServiceException;

    public pe.gob.segdi.wsiotramite.ws.Tramite_PortType getTramitePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
