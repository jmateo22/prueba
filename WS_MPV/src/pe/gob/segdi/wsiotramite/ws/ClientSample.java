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



public class ClientSample {

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
	        recepcionRequest.setVrucentrem("20537630222");	        
	        recepcionRequest.setVuniorgrem("OGETIC");
	        recepcionRequest.setCtipdociderem("1");
	        recepcionRequest.setVnumdociderem("443436857");			
	        recepcionRequest.setVnomentemi("MINISTERIO DE CULTURA");
	        
			
	        GregorianCalendar unGregorianCalendar = new GregorianCalendar();
	        Date elTimeStamp = new Date();
			unGregorianCalendar.setTime(elTimeStamp );
	        XMLGregorianCalendar fecha;
	        
	        java.util.Calendar dfecdoc =  Calendar.getInstance();
	        
			/**Datos Destinatario SERVIR*/
	        recepcionRequest.setVrucentrec("20477906461"); //Autoridad Nacional del Servicio Civil
	        
	        recepcionRequest.setVuniorgdst("GERENCIA DE DESARROLLO DE CAPACIDADES Y RENDIMIENTO DEL SERVICIO CIVIL");
			recepcionRequest.setVnomdst("ARANCEL BARRERA EMELYN");
			recepcionRequest.setVnomcardst("GERENTE DE DESARROLLO DE CAPACIDADES Y RENDIMIENTO DEL SERVICIO CIVIL");
			recepcionRequest.setVasu("REITERA SE EXPIDA RESOLUCIÓN FINAL EN EL PRESENTE EXP.36417-2019");
			
			/**Datos Documento***/
			recepcionRequest.setSnumanx(0);
			recepcionRequest.setSnumfol(5);
			recepcionRequest.setVurldocanx("http://172.16.19.36:8080/VerificaDocumentoSERVIR/consultasMPV?codigo=A7C083E37E381450E0D1A3DBCD6CF033");
	        recepcionRequest.setVcuo("000000299");
	       // recepcionRequest.setVcuoref("000000202");			
	        recepcionRequest.setCcodtipdoc("01"); //01 Oficio 02 Carta
	        recepcionRequest.setVnumdoc("17-2020/GRJ/ORAF/ORH");
			recepcionRequest.setVnomdoc("OFICIO-R3-2019-GG-OAJ-TNR.pdf");
			
			byte[] bFile = readBytesFromFile("D:\\sample01.pdf");
			recepcionRequest.setBpdfdoc(Base64.getEncoder().encode(bFile));
			
			
			try {
				fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(unGregorianCalendar);
				recepcionRequest.setDfecdoc(dfecdoc);				
				
				
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				RespuestaTramite respuesta = port1.recepcionarTramiteResponse(recepcionRequest);
				 System.out.println("Server said: " +respuesta.getVcodres() );
				 System.out.println("Server said: " +respuesta.getVdesres());
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