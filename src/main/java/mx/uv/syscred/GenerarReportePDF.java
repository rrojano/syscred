package mx.uv.syscred;
import java.util.HashMap;
import java.util.Map;

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
	//private final String foto = "Rep/123456789.jpg";
	private final String logotipo="reportes/logo.jpg";
    
    public void generarDelantera(String nombre, String paterno, String materno, String seguro, String foto)
    {    	
    	this.nombre = nombre;
    	this.paterno = paterno;
    	this.materno = materno;
    	this.seguro = seguro;
    	//this.foto = foto;
        ParticipantesDataSource dataSource = new ParticipantesDataSource();
        Alumnos alumno = new Alumnos(paterno, nombre,materno, seguro);        
        dataSource.addAlumno(alumno);
                
        try
        
        {
            
            Map<String, Object> p = new HashMap<String, Object>();        
            p.put("logo", this.getClass().getResourceAsStream("logo.jpg"));            
        	System.out.println(p.toString());
    	  	String fileJasper = "jcReport_Logo.jasper";
            JasperPrint print = JasperFillManager.fillReport(fileJasper, p, dataSource);
            JasperViewer jviewer1 = new JasperViewer (print,false);
            jviewer1.setBounds(0,0,700,600);
            jviewer1.setVisible(true);
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Se produjo un error al leer el archivo .jasper");
        }
    }
    
    public void generarTrasera(String nombre, String paterno, String materno, String seguro)
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
    	  	//String fileJasper = "C:/Users/Luis Zavaleta/Desktop/reporte2.jasper";
    	  	String fileJasper = "Rep/reporte3.jasper";
            JasperPrint print = JasperFillManager.fillReport(fileJasper,null, dataSource);
            JasperViewer jviewer1 = new JasperViewer (print,false);
            jviewer1.setBounds(0,0,700,600);
            jviewer1.setVisible(true);
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Se produjo un error al leer el archivo .jasper");
        } 
    }

}