package mx.uv.syscred;
public class Alumnos 
{
	
	private String Apaterno;
	private String Amaterno;
	private String Nombre;
	private String NSeguro;
	
	public Alumnos()
	{
		
	}
	
	public Alumnos(String Apaterno, String Amaterno, String Nombre, String NSeguro)
	{
		this.Amaterno = Amaterno;
		this.Apaterno = Apaterno;
		this.Nombre = Nombre;
		this.NSeguro = NSeguro;
	}

	public String getApaterno() 
	{
		return Apaterno;
	}

	public void setApaterno(String apaterno) 
	{
		Apaterno = apaterno;
	}

	public String getAmaterno() 
	{
		return Amaterno;
	}

	public void setAmaterno(String amaterno) 
	{
		Amaterno = amaterno;
	}

	public String getNombre() 
	{
		return Nombre;
	}

	public void setNombre(String nombre) 
	{
		Nombre = nombre;
	}

	public String getNSeguro() 
	{
		return NSeguro;
	}

	public void setNSeguro(String nSeguro) 
	{
		NSeguro = nSeguro;
	}
	
	

}
