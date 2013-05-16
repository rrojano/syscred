package mx.uv.syscred;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class GenerarReportePDF 
{
	private String nombre;
	private String paterno;
	private String materno;
	private String seguro;
    
    public void generarReporte(String nombre, String paterno, String materno, String seguro)
    {    	
    	this.nombre = nombre;
    	this.paterno = paterno;
    	this.materno = materno;
    	this.seguro = seguro;
        ParticipantesDataSource dataSource = new ParticipantesDataSource();
        Alumnos alumno = new Alumnos(paterno, nombre,materno, seguro);
        dataSource.addAlumno(alumno);
        
        try
        {
    	  	String fileJasper = "C:/Users/Luis Zavaleta/Desktop/reporte2.jasper";
            JasperPrint print = JasperFillManager.fillReport(fileJasper,null, dataSource);
            String fileJasper2 = "C:/Users/Luis Zavaleta/Desktop/reporte2.jasper";
            JasperPrint print2 = JasperFillManager.fillReport(fileJasper2,null, dataSource);
            JasperViewer jviewer = new JasperViewer(print,false);
            jviewer.setVisible(true);    
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Se produjo un error al leer el archivo .jasper");
        } 
    }

}