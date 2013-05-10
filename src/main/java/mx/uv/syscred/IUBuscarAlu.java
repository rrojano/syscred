package mx.uv.syscred;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.csvreader.CsvReader;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;


/*public class IUBuscarAlu extends JFrame 
{

	private JPanel contentPane;
	private JTextField textTexto;
	CsvReader reader;
	private String e; 
	private static JFrame IUCredencial;
	
	public String CURP;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					IUBuscarAlu frame = new IUBuscarAlu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public IUBuscarAlu() 
	{						
		ButtonGroup grupo = new ButtonGroup();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		final JLabel lblPruebaDatos = new JLabel("");
		lblPruebaDatos.setBounds(226, 97, 172, 14);
		contentPane.add(lblPruebaDatos);
		
		final JRadioButton rdMatricula = new JRadioButton("Por Matr�cula", true);
		rdMatricula.setBounds(10, 22, 109, 23);
		contentPane.add(rdMatricula);
		
		final JRadioButton rdCurp = new JRadioButton("Por CURP", false);
		rdCurp.setBounds(138, 22, 109, 23);
		contentPane.add(rdCurp);
		
		final JRadioButton rdApellido = new JRadioButton("Por Apellido Paterno", false);
		rdApellido.setBounds(269, 22, 109, 23);
		contentPane.add(rdApellido);
		
		grupo.add(rdApellido);
		grupo.add(rdCurp);
		grupo.add(rdMatricula);
		
		textTexto = new JTextField();
		textTexto.setBounds(10, 52, 237, 20);
		contentPane.add(textTexto);
		textTexto.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		btnCancelar.setBounds(127, 93, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(rdApellido.isSelected())
				{
					//REALIZA BUSQUEDA POR APELLIDO
					try 
					{   							
						CsvReader reader = new CsvReader("C:\\Users\\Luis Zavaleta\\Dropbox\\10° Semestre UV\\Taller de Integración 2\\prueba.csv");
						
						while (reader.readRecord())
						{							
							String Nombre = reader.get(0);
							String Apaterno = reader.get(1);
							String Amaterno = reader.get(2);
							CURP = reader.get(3);
							String Nseguro = reader.get(4);
						 
							if (Apaterno.equals(textTexto.getText()))
							{
								lblPruebaDatos.setText(CURP);	
							}
							else
							{
								lblPruebaDatos.setText("no se encontro");	
							}

						}
						
						} catch (IOException e) 
						{
							e.printStackTrace();							
						}
						reader.close();
					
				}
				else
				{
					if(rdCurp.isSelected())
					{
						//REALIZA BUSQUEDA POR CURP
						textTexto.setText("CURP");
					}
					else
					{
						//REALIZA BUSQUEDA POR MATRICULA
						textTexto.setText("MATRICULA");
					}
				}
			}
		});
		btnBuscar.setBounds(10, 93, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnAgregar = new JButton("Agregar Datos del Alumno");
		btnAgregar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				IUCredencial jf1 = new IUCredencial();
				jf1.setVisible(true);
				jf1.setL(CURP);
				dispose();
			}
		});
		btnAgregar.setBounds(10, 128, 206, 23);
		contentPane.add(btnAgregar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 388, 76);
		contentPane.add(panel);
		
		
	}
}*/
public class IUBuscarAlu extends JFrame {

	private JPanel contentPane;
	private JTextField textTexto;
	CsvReader reader;
	private String e; 
	private static JFrame IUCredencial;
	public String Nombre, Apaterno, Amaterno, CURP, Nseguro;
	public String Nombre1, Apaterno1, Amaterno1, CURP1, Nseguro1;

	
	private JTextField textField;
	private JTextField textField_1;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					IUBuscarAlu frame = new IUBuscarAlu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public IUBuscarAlu() 
	{						
		ButtonGroup grupo = new ButtonGroup();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		final JLabel lblPruebaDatos = new JLabel("");
		lblPruebaDatos.setBounds(226, 124, 172, 14);
		contentPane.add(lblPruebaDatos);
		
		final JRadioButton rdMatricula = new JRadioButton("Por N. Seguro", true);
		rdMatricula.setBounds(10, 22, 109, 23);
		contentPane.add(rdMatricula);
		
		final JRadioButton rdCurp = new JRadioButton("Por CURP", false);
		rdCurp.setBounds(138, 22, 109, 23);
		contentPane.add(rdCurp);
		
		final JRadioButton rdApellido = new JRadioButton("Por Nombre completo", false);
		rdApellido.setBounds(269, 22, 109, 23);
		contentPane.add(rdApellido);
		
		grupo.add(rdApellido);
		grupo.add(rdCurp);
		grupo.add(rdMatricula);
		
		textTexto = new JTextField();
		textTexto.setBounds(10, 52, 237, 20);
		contentPane.add(textTexto);
		textTexto.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		
		textField = new JTextField();
		textField.setBounds(236, 97, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		btnCancelar.setBounds(127, 93, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(rdApellido.isSelected())
				{
					//REALIZA BUSQUEDA POR APELLIDO
					try 
					{   boolean band= false;							
						CsvReader reader = new CsvReader("C:\\Users\\Luis Zavaleta\\Dropbox\\10° Semestre UV\\Taller de Integración 2\\prueba.csv");
						
						while (reader.readRecord())
						{							
							Nombre = reader.get(0);
							Apaterno = reader.get(1);
							Amaterno = reader.get(2);
							CURP = reader.get(3);
							Nseguro = reader.get(4);
						 
							if ((Nombre.equals(textTexto.getText()))&& (Apaterno.equals(textField.getText()))&& (Amaterno.equals(textField_1.getText())))
							{  
							
								JOptionPane.showMessageDialog(null, "Alumno encontrado");
								Nombre1=Nombre;
								Apaterno1=Apaterno;
								Amaterno1=Amaterno;
								Nseguro1=Nseguro;
								band = true;						
							}
							
							else
							{
								
							}
						}
						
						} catch (IOException e) 
						{
							e.printStackTrace();							
						}
						reader.close();
					
				}
				else
				{
					if(rdCurp.isSelected())
					{
						try 
						{   boolean band= false;							
							CsvReader reader = new CsvReader("C:\\Users\\Luis Zavaleta\\Dropbox\\10° Semestre UV\\Taller de Integración 2\\prueba.csv");
							
							while (reader.readRecord())
							{							
								Nombre = reader.get(0);
								Apaterno = reader.get(1);
								Amaterno = reader.get(2);
								CURP = reader.get(3);
								Nseguro = reader.get(4);
							 
								if (CURP.equals(textTexto.getText())){  
								
									JOptionPane.showMessageDialog(null, "Alumno encontrado");
									Nombre1=Nombre;
									Apaterno1=Apaterno;
									Amaterno1=Amaterno;
									Nseguro1=Nseguro;
									band = true;						
								}
								
								else
								{
									
								}
							}
							
							} catch (IOException e) 
							{
								e.printStackTrace();							
							}
							reader.close();
						
					}
					else
					{
						try 
						{   boolean band= false;							
							CsvReader reader = new CsvReader("C:\\Users\\Luis Zavaleta\\Dropbox\\10° Semestre UV\\Taller de Integración 2\\prueba.csv");
							
							while (reader.readRecord())
							{							
								Nombre = reader.get(0);
								Apaterno = reader.get(1);
								Amaterno = reader.get(2);
								CURP = reader.get(3);
								Nseguro = reader.get(4);
							 
								if (Nseguro.equals(textTexto.getText()))
								{  
								
									JOptionPane.showMessageDialog(null, "Alumno encontrado");
									Nombre1=Nombre;
									Apaterno1=Apaterno;
									Amaterno1=Amaterno;
									Nseguro1=Nseguro;
									band = true;						
								}
								
								else
								{
									
								}
							}
							
							} catch (IOException e) 
							{
								e.printStackTrace();							
							}
							reader.close();
						
					}
					}
				
			}
		});
		btnBuscar.setBounds(10, 93, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnAgregar = new JButton("Agregar Datos del Alumno");
		btnAgregar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				IUCredencial jf1 = new IUCredencial();
				jf1.setVisible(true);
				jf1.setL(Nseguro1);
				jf1.setL2(Nombre1);
				jf1.setL3(Apaterno1);
				jf1.setL4(Amaterno1);
				dispose();
			}
		});
		btnAgregar.setBounds(10, 128, 206, 23);
		contentPane.add(btnAgregar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 514, 74);
		contentPane.add(panel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(365, 91, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
	}
}

