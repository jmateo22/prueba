/**
 * Tramite_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.segdi.wsiotramite.ws;

public interface Tramite_PortType extends java.rmi.Remote {
    public pe.gob.segdi.wsiotramite.ws.RespuestaCargoTramite cargoResponse(pe.gob.segdi.wsiotramite.ws.CargoTramite cargoRequest) throws java.rmi.RemoteException;
    public pe.gob.segdi.wsiotramite.ws.RespuestaConsultaTramite consultarTramiteResponse(java.lang.String request) throws java.rmi.RemoteException;
    public pe.gob.segdi.wsiotramite.ws.RespuestaTramite recepcionarTramiteResponse(pe.gob.segdi.wsiotramite.ws.RecepcionTramite recepcionRequest) throws java.rmi.RemoteException;
}
