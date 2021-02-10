package pe.gob.segdi.wsiotramite.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.rpc.ServiceException;



public class ClienteSamplePOLI {

	public static void main(String[] args) {
	        System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        Tramite_Service service1 = new Tramite_ServiceLocator();
	        System.out.println("Create Web Service...");
	        Tramite_PortType port1 = null;
			try {
				port1 = service1.getTramitePort();
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        RecepcionTramite recepcionRequest= new RecepcionTramite();
	        
	        /**Datos del Remitente**/
	        recepcionRequest.setVrucentrem("20168999926");	        
	        recepcionRequest.setVuniorgrem("ORH");
	        recepcionRequest.setCtipdociderem("1");
	        recepcionRequest.setVnumdociderem("443436857");			
	        recepcionRequest.setVnomentemi("PRESIDENCIA DEL CONSEJO DE MINISTROS -PCM");
	        
			
	        GregorianCalendar unGregorianCalendar = new GregorianCalendar();
	        Date elTimeStamp = new Date();
			unGregorianCalendar.setTime(elTimeStamp );
	        XMLGregorianCalendar fecha;
	        
	        java.util.Calendar dfecdoc =  Calendar.getInstance();
	        
			/**Datos Destinatario SERVIR*/
	        recepcionRequest.setVrucentrec("20477906461"); //Autoridad Nacional del Servicio Civil
	        
	        recepcionRequest.setVuniorgdst("GERENTA DE POLÍTICAS DE GESTIÓN DEL SERVICIO CIVIL");
			recepcionRequest.setVnomdst("CYNTHIA CHEENYI SÚ	LAY");
			recepcionRequest.setVnomcardst("GERENCIA DE POLITICAS DE GESTION DEL SERVICIO CIVIL");
			recepcionRequest.setVasu("Prueba Mesa de Partes Virtual");
			
			/**Datos Documento***/
			recepcionRequest.setSnumanx(6);
			recepcionRequest.setSnumfol(5);
			recepcionRequest.setVurldocanx("http://172.16.19.164:8080/VerificaDocumentoSERVIR/consultasMPV?codigo=BA581E135E9C54CAA7567F7CB82260FC");
	        recepcionRequest.setVcuo("0000008179");
	       // recepcionRequest.setVcuoref("000000202");			
	        recepcionRequest.setCcodtipdoc("01"); //01 Oficio 02 Carta
	        recepcionRequest.setVnumdoc("OFICO-R4-2020-GG-OAJ-TNR");
			recepcionRequest.setVnomdoc("OFICO-R4-2020-GG-OAJ-TNR.pdf");
			
			byte[] bFile = readBytesFromFile("D:\\samplePE.pdf");
			recepcionRequest.setBpdfdoc(Base64.getEncoder().encode(bFile));
			
			//Anexos 1
		    DocumentoAnexo documentoanexo= new  DocumentoAnexo();
		    documentoanexo.setVnomdoc("Anexo1 Enviado 01");
		    DocumentoAnexo documentoanexo2= new  DocumentoAnexo();
		    documentoanexo2.setVnomdoc("Anexo1 Enviado 02");

			
			try {
				fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(unGregorianCalendar);
				recepcionRequest.setDfecdoc(dfecdoc);				
				documentoanexo.setDfecreg(dfecdoc);
				documentoanexo2.setDfecreg(dfecdoc);
				
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DocumentoAnexo[] lstanexos = new DocumentoAnexo[6] ;
			lstanexos[0]=documentoanexo;
			lstanexos[1]=documentoanexo2;	
			lstanexos[2]=documentoanexo;
			lstanexos[3]=documentoanexo2;	
			lstanexos[4]=documentoanexo;
			lstanexos[5]=documentoanexo2;	
			recepcionRequest.setLstanexos(lstanexos);
			
			try {
				RespuestaTramite respuesta = port1.recepcionarTramiteResponse(recepcionRequest);
				 System.out.println("Server said: " +respuesta.getVcodres() );
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

	       
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Call Over!");
	}
	
	
	private static byte[] readBytesFromFile(String filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {

            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return bytesArray;

    }
}