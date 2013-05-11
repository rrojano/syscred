package mx.uv.syscred;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/*public class IUCredencial extends JFrame
{

	private JPanel contentPane;	
	private JLabel labelP;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					IUCredencial frame = new IUCredencial();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}


	public IUCredencial() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 574, 193);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 281, 171);
		panel_1.add(lblNewLabel);
		File cred = new File("Img/i1.jpg");
		lblNewLabel.setIcon(new ImageIcon(cred.getPath()));
		
		JLabel label = new JLabel("");
		label.setBounds(283, 11, 281, 171);
		panel_1.add(label);
		File cred2 = new File("Img/i2.jpg");
		label.setIcon(new ImageIcon(cred2.getPath()));
		
		JButton btnNewButton = new JButton("Buscar Alumno");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				IUBuscarAlu IUBA = new IUBuscarAlu();
				IUBA.show();	
				dispose();
			}
		});
		btnNewButton.setBounds(34, 204, 188, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar Datos Institucion");
		btnNewButton_1.setBounds(236, 204, 188, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Imprimir");
		btnNewButton_2.setBounds(34, 239, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{				
				dispose();
			}
		});
		btnNewButton_3.setBounds(133, 239, 89, 23);
		contentPane.add(btnNewButton_3);
				
		
		labelP = new JLabel("");
		labelP.setBounds(246,238,89,23);contentPane.add(labelP);
		
	}
	
	public void setL (String cadena)
	{		
		labelP.setText(cadena);		
	}
	
}*/

public class IUCredencial extends JFrame
{

	private JPanel contentPane;	
	private JLabel labelP,lblNombre,lblPaterno,lblMaterno; 
	private GenerarReportePDF reporte;
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					IUCredencial frame = new IUCredencial();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}


	public IUCredencial() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 574, 193);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 281, 171);
		panel_1.add(lblNewLabel);
		//File cred = new File("Img/i1.jpg");
		//lblNewLabel.setIcon(new ImageIcon(cred.getPath()));
		
		JLabel label = new JLabel("");
		label.setBounds(283, 11, 281, 171);
		panel_1.add(label);
		//File cred2 = new File("Img/i2.jpg");
		//label.setIcon(new ImageIcon(cred2.getPath()));
		
		
		labelP = new JLabel("");
		labelP.setBounds(10, 159, 89, 23);
		panel_1.add(labelP);
		
		lblNombre = new JLabel("");
		lblNombre.setBounds(20, 11, 89, 23);
		panel_1.add(lblNombre);
		
		lblPaterno = new JLabel("");
		lblPaterno.setBounds(10, 57, 111, 23);
		panel_1.add(lblPaterno);
		
		lblMaterno = new JLabel("");
		lblMaterno.setBounds(10, 107, 89, 21);
		panel_1.add(lblMaterno);
		
		JButton btnNewButton = new JButton("Buscar Alumno");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				IUBuscarAlu IUBA = new IUBuscarAlu();
				IUBA.show();	
				dispose();
			}
		});
		btnNewButton.setBounds(34, 204, 188, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar Datos Institucion");
		btnNewButton_1.setBounds(236, 204, 188, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Imprimir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String nombre = lblNombre.getText();
				String paterno = lblPaterno.getText();
				String materno = lblMaterno.getText();
				String seguro = labelP.getText();				
				reporte = new GenerarReportePDF();
				reporte.generarReporte(nombre, paterno, materno, seguro);
			}
		});
		btnNewButton_2.setBounds(34, 239, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{				
				dispose();
			}
		});
		btnNewButton_3.setBounds(133, 239, 89, 23);
		contentPane.add(btnNewButton_3);
		
	}
	
	public void setL (String Nseguro1)
	{		
		labelP.setText(Nseguro1);	
		
	}
	public void setL2 (String Nombre1)
	{		
			
		lblNombre.setText(Nombre1);
	}
	public void setL3 (String Apaterno1)
	{		
			
		
		lblPaterno.setText(Apaterno1);
	}
	public void setL4 (String Amaterno1)
	{		
			
		lblMaterno.setText(Amaterno1);
	}
}

