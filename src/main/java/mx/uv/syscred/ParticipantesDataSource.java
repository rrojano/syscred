package mx.uv.syscred;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
public class ParticipantesDataSource implements JRDataSource
{
	private List<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
	private int indice = -1;
	
	public Object getFieldValue(JRField jrf) throws JRException
	{
		 Object valor = null;
		 
		 if("nombre".equals(jrf.getName()))
		 {
			 valor = listaAlumnos.get(indice).getNombre();
		 }
		 else
		 {
			 if("paterno".equals(jrf.getName()))
			 {
				 valor = listaAlumnos.get(indice).getApaterno();
			 }
			 else
			 {
				 if("materno".equals(jrf.getName()))
				 {
					 valor = listaAlumnos.get(indice).getAmaterno();
				 }
				 else
				 {
					 if("nseguro".equals(jrf.getName()))
					 {
						 valor = listaAlumnos.get(indice).getNSeguro();
					 }
				 }
			 }
		 }		 
		 return valor;
    }
	
	public boolean next() throws JRException
	{
		return ++indice < listaAlumnos.size();
	}
	
	public void addAlumno (Alumnos alumnos)
	{
		this.listaAlumnos.add(alumnos);
	}
}
