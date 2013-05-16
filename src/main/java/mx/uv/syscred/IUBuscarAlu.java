package mx.uv.syscred;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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

public class IUBuscarAlu extends JFrame 
{

	private JPanel contentPane;
	
	private JTextField textNombres;
	private JTextField textPaterno;
	private JTextField textMaterno;
	private JTextField textNseguro;
	private JTextField textCURP;	
	CsvReader reader;
	private String e; 
	private static JFrame IUCredencial;
	public String Nombre, Apaterno, Amaterno, CURP, Nseguro;
	public String Nombre1, Apaterno1, Amaterno1, CURP1, Nseguro1;

	
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
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		final JLabel lblN1 = new JLabel("");
		lblN1.setBounds(10, 151, 89, 14);
		contentPane.add(lblN1);
		
		final JLabel lblN2 = new JLabel("");
		lblN2.setBounds(10, 195, 89, 14);
		contentPane.add(lblN2);
		
		final JLabel lblN3 = new JLabel("");
		lblN3.setBounds(10, 252, 89, 14);
		contentPane.add(lblN3);
		
		textNombres = new JTextField();
		textNombres.setBounds(119, 145, 190, 20);
		contentPane.add(textNombres);
		textNombres.setColumns(10);
		textNombres.setVisible(false);					
		
		textMaterno = new JTextField();
		textMaterno.setBounds(119, 246, 190, 20);
		contentPane.add(textMaterno);
		textMaterno.setColumns(10);
		textMaterno.setVisible(false);					
		
		textPaterno = new JTextField();
		textPaterno.setBounds(119, 189, 190, 20);
		contentPane.add(textPaterno);
		textPaterno.setColumns(10);
		textPaterno.setVisible(false);
		
		textNseguro = new JTextField();
		textNseguro.setBounds(119, 145, 190, 20);
		contentPane.add(textNseguro);
		textNseguro.setColumns(10);
		textNseguro.setVisible(false);
		
		textCURP = new JTextField();
		textCURP.setBounds(119, 145, 190, 20);
		contentPane.add(textCURP);
		textCURP.setColumns(10);
		textCURP.setVisible(false);
		
		lblN1.setVisible(false);
		lblN2.setVisible(false);
		lblN3.setVisible(false);
		
		
		
		
		
		final JRadioButton rdNSeguro = new JRadioButton("Por número de seguro", false);
		this.repaint();
		rdNSeguro.setBounds(20, 63, 289, 23);
		contentPane.add(rdNSeguro);
		
		final JRadioButton rdCurp = new JRadioButton("Por CURP", false);
		this.repaint();
		rdCurp.setBounds(20, 89, 289, 23);
		contentPane.add(rdCurp);
		
		final JRadioButton rdNombre = new JRadioButton("Por Nombre completo", false);
		rdNombre.setBounds(20, 115, 289, 23);
		contentPane.add(rdNombre);
		
		grupo.add(rdNombre);
		grupo.add(rdCurp);
		grupo.add(rdNSeguro);
		
	
		
		JButton btnCancelar = new JButton("");
		btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				IUCredencial jf1 = new IUCredencial();
				jf1.setVisible(true);				
				dispose();
			}
		});
		btnCancelar.setBounds(425, 216, 99, 50);
		ImageIcon imgbutton2 = new ImageIcon("Img/cancel.png");
		Icon imgicon2 = new ImageIcon(imgbutton2.getImage().getScaledInstance(btnCancelar.getWidth(), btnCancelar.getHeight(), Image.SCALE_DEFAULT));
		btnCancelar.setIcon(imgicon2);
		contentPane.add(btnCancelar);
		
		
		rdNombre.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rdNombre.isSelected())
				{					
					textNombres.setVisible(true);					
					textMaterno.setVisible(true);										
					textPaterno.setVisible(true);
					textNseguro.setVisible(false);
					textCURP.setVisible(false);
					
					lblN1.setText("Nombre (s)");
					lblN1.setVisible(true);
					lblN2.setText("A Paterno");
					lblN2.setVisible(true);
					lblN3.setText("A Materno");
					lblN3.setVisible(true);					
				}
			}
		});
		this.repaint();
		rdCurp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rdCurp.isSelected())
				{
					textNombres.setVisible(false);					
					textMaterno.setVisible(false);										
					textPaterno.setVisible(false);
					textNseguro.setVisible(false);
					textCURP.setVisible(true);
					
					lblN1.setText("CURP");
					lblN1.setVisible(true);
					lblN2.setText("");
					lblN2.setVisible(true);
					lblN3.setText("");
					lblN3.setVisible(true);	
				}
			}
		});		
		rdNSeguro.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rdNSeguro.isSelected())
				{
					textNombres.setVisible(false);					
					textMaterno.setVisible(false);										
					textPaterno.setVisible(false);
					textNseguro.setVisible(true);
					textCURP.setVisible(false);
					
					lblN1.setText("N Seguro");
					lblN1.setVisible(true);
					lblN2.setText("");
					lblN2.setVisible(true);
					lblN3.setText("");
					lblN3.setVisible(true);	
				}				
			}			
		});
		
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(rdNombre.isSelected())
				{
					//REALIZA BUSQUEDA POR NOMBRES			
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
						 
							if ((Nombre.equals(textNombres.getText()))&& (Apaterno.equals(textPaterno.getText()))&& (Amaterno.equals(textMaterno.getText())))
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
							 
								if (CURP.equals(textCURP.getText())){  
								
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
							 
								if (Nseguro.equals(textNseguro.getText()))
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
		btnBuscar.setBounds(425, 16, 99, 50);
		ImageIcon imgbutton1 = new ImageIcon("Img/lupa.png");
		Icon imgicon1 = new ImageIcon(imgbutton1.getImage().getScaledInstance(btnBuscar.getWidth(), btnBuscar.getHeight(), Image.SCALE_DEFAULT));
		btnBuscar.setIcon(imgicon1);
		contentPane.add(btnBuscar);
		
		JButton btnAgregar = new JButton("");
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
		btnAgregar.setBounds(425, 115, 99, 50);
		contentPane.add(btnAgregar);
		
		JLabel lblNewLabel = new JLabel("BUSCAR ALUMNO POR:");
		lblNewLabel.setBounds(10, 22, 299, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar al alumnno");
		lblNewLabel_1.setBounds(396, 73, 128, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Agregar los datos");
		lblNewLabel_2.setBounds(396, 174, 128, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Regresar");
		lblNewLabel_3.setBounds(396, 277, 99, 14);
		contentPane.add(lblNewLabel_3);
		
		
	}
}

