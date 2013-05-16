package mx.uv.syscred;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


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
		setBounds(50, 10, 1200, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 0, 1164, 464);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblImgFrente = new JLabel("");
		lblImgFrente.setBounds(0, 11, 556, 442);
		panel_1.add(lblImgFrente);
		ImageIcon imgFrente = new ImageIcon("Img/i12.jpg");
		Icon icono1 = new ImageIcon(imgFrente.getImage().getScaledInstance(lblImgFrente.getWidth(), lblImgFrente.getHeight(), Image.SCALE_DEFAULT));
		lblImgFrente.setIcon(icono1);
		this.repaint();
		
		JLabel lblImgAtras = new JLabel("");
		lblImgAtras.setBounds(560, 11, 594, 442);
		panel_1.add(lblImgAtras);
		ImageIcon imgAtras = new ImageIcon("Img/i22.jpg");
		Icon icono2 = new ImageIcon(imgAtras.getImage().getScaledInstance(lblImgAtras.getWidth(), lblImgAtras.getHeight(), Image.SCALE_DEFAULT));
		lblImgAtras.setIcon(icono2);
		this.repaint();
		
		
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
		
		JButton btnBuscarAlu = new JButton();
		btnBuscarAlu.setBounds(10, 475, 136, 76);
		ImageIcon imgbutton1 = new ImageIcon("Img/lupa.png");
		Icon imgicon1 = new ImageIcon(imgbutton1.getImage().getScaledInstance(btnBuscarAlu.getWidth(), btnBuscarAlu.getHeight(), Image.SCALE_DEFAULT));
		btnBuscarAlu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				IUBuscarAlu IUBA = new IUBuscarAlu();
				IUBA.show();	
				dispose();
			}
		});		
		btnBuscarAlu.setIcon(imgicon1);
		contentPane.add(btnBuscarAlu);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(1010, 475, 136, 76);
		contentPane.add(btnNewButton_1);
		
		JButton btnImprimir = new JButton("");
		btnImprimir.setBounds(156, 475, 136, 76);
		ImageIcon imgbutton2 = new ImageIcon("Img/impresora.png");
		Icon imgicon2 = new ImageIcon(imgbutton2.getImage().getScaledInstance(btnImprimir.getWidth(), btnImprimir.getHeight(), Image.SCALE_DEFAULT));
		btnImprimir.addActionListener(new ActionListener() 
		{
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
		btnImprimir.setIcon(imgicon2);
		contentPane.add(btnImprimir);
		
		JButton btnSalir = new JButton("");
		btnSalir.setBounds(302, 475, 136, 76);
		ImageIcon imgbutton3 = new ImageIcon("Img/salir.png");
		Icon imgicon3 = new ImageIcon(imgbutton3.getImage().getScaledInstance(btnSalir.getWidth(), btnSalir.getHeight(), Image.SCALE_DEFAULT));
		btnSalir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{				
				dispose();
			}
		});
		btnSalir.setIcon(imgicon3);
		contentPane.add(btnSalir);
		
		JLabel lblBuscar = new JLabel("Buscar alumno");
		lblBuscar.setBounds(10, 562, 136, 14);
		contentPane.add(lblBuscar);
		
		JLabel lblImprimir = new JLabel("Imprimir credencial");
		lblImprimir.setBounds(156, 562, 136, 14);
		contentPane.add(lblImprimir);
		
		JLabel lblModi = new JLabel("Modificar datos institución.");
		lblModi.setBounds(1010, 562, 164, 14);
		contentPane.add(lblModi);
		
		JLabel lblSalir = new JLabel("Salir");
		lblSalir.setBounds(302, 562, 136, 14);
		contentPane.add(lblSalir);
		
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

