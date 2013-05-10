package mx.uv.syscred;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class GenerarReportePDF 
{
	static IUCredencial iucredencial;
    public static void main(String[] args) 
    {
    	iucredencial = new IUCredencial();
    	String nombre =iucredencial.getNombre();
    	String paterno =iucredencial.getPaterno();
    	String materno =iucredencial.getMaterno();
    	String seguro =iucredencial.getSeguro();
        //GenerarReportePDF reporte = new GenerarReportePDF();
        //reporte.generarReporte();
        ParticipantesDataSource dataSource = new ParticipantesDataSource();
        Alumnos alumno = new Alumnos("nombre", "paterno", "materno", "seguro");
        dataSource.addAlumno(alumno);
        
        try
        {
    	  	String fileJasper = "C:/Users/Luis Zavaleta/Desktop/reporte2.jasper";
            JasperPrint print = JasperFillManager.fillReport(fileJasper,null, dataSource);
            JasperViewer jviewer = new JasperViewer(print,false);
            jviewer.setVisible(true);    
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Se produjo un error al leer el archivo .jasper");
        } 
        
    }
    
    public void generarReporte()
    {
    	
    }

}