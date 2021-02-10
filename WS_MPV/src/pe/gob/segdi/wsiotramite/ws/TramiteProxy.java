package pe.gob.segdi.wsiotramite.ws;

public class TramiteProxy implements pe.gob.segdi.wsiotramite.ws.Tramite_PortType {
  private String _endpoint = null;
  private pe.gob.segdi.wsiotramite.ws.Tramite_PortType tramite_PortType = null;
  
  public TramiteProxy() {
    _initTramiteProxy();
  }
  
  public TramiteProxy(String endpoint) {
    _endpoint = endpoint;
    _initTramiteProxy();
  }
  
  private void _initTramiteProxy() {
    try {
      tramite_PortType = (new pe.gob.segdi.wsiotramite.ws.Tramite_ServiceLocator()).getTramitePort();
      if (tramite_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tramite_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tramite_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tramite_PortType != null)
      ((javax.xml.rpc.Stub)tramite_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.gob.segdi.wsiotramite.ws.Tramite_PortType getTramite_PortType() {
    if (tramite_PortType == null)
      _initTramiteProxy();
    return tramite_PortType;
  }
  
  public pe.gob.segdi.wsiotramite.ws.RespuestaCargoTramite cargoResponse(pe.gob.segdi.wsiotramite.ws.CargoTramite cargoRequest) throws java.rmi.RemoteException{
    if (tramite_PortType == null)
      _initTramiteProxy();
    return tramite_PortType.cargoResponse(cargoRequest);
  }
  
  public pe.gob.segdi.wsiotramite.ws.RespuestaConsultaTramite consultarTramiteResponse(java.lang.String request) throws java.rmi.RemoteException{
    if (tramite_PortType == null)
      _initTramiteProxy();
    return tramite_PortType.consultarTramiteResponse(request);
  }
  
  public pe.gob.segdi.wsiotramite.ws.RespuestaTramite recepcionarTramiteResponse(pe.gob.segdi.wsiotramite.ws.RecepcionTramite recepcionRequest) throws java.rmi.RemoteException{
    if (tramite_PortType == null)
      _initTramiteProxy();
    return tramite_PortType.recepcionarTramiteResponse(recepcionRequest);
  }
  
  
}