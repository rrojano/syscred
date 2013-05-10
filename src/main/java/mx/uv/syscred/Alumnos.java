package mx.uv.syscred;
public class Alumnos 
{
	/*private int clave;
	private String nombre;
	private String contrasena;*/
	
	private String Apaterno;
	private String Amaterno;
	private String Nombre;
	private String NSeguro;
	
	public Alumnos()
	{
		
	}
	
	/*public Alumnos(int clave, String nombre, String contrasena)
	{
		this.clave = clave;
		this.nombre = nombre;
		this.contrasena = contrasena;
	}*/
	
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

	/*public int getClave() 
	{
		return clave;
	}

	public void setClave(int clave) 
	{
		this.clave = clave;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getContrasena() 
	{
		return contrasena;
	}

	public void setContrasena(String contrasena) 
	{
		this.contrasena = contrasena;
	}*/
	
	

}
