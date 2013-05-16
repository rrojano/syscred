package mx.uv.syscred;
import java.awt.Color;
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
		btnBuscarAlu.setBackground(Color.WHITE);
		contentPane.add(btnBuscarAlu);
		
		JButton btnModificar = new JButton("");
		btnModificar.setBounds(1010, 475, 136, 76);
		ImageIcon imgbutton5 = new ImageIcon("Img/modificar.png");
		Icon imgicon5 = new ImageIcon(imgbutton5.getImage().getScaledInstance(btnModificar.getWidth(), btnModificar.getHeight(), Image.SCALE_DEFAULT));
		btnModificar.setIcon(imgicon5);
		btnModificar.setBackground(Color.WHITE);
		contentPane.add(btnModificar);
		
		JButton btnImprimir = new JButton("");
		btnImprimir.setBounds(156, 475, 136, 76);
		ImageIcon imgbutton2 = new ImageIcon("Img/atras.png");
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
				reporte.generarDelantera(nombre, paterno, materno, seguro);
			}
		});
		btnImprimir.setIcon(imgicon2);
		btnImprimir.setBackground(Color.WHITE);
		contentPane.add(btnImprimir);
		
		
		JButton btnImprimir2 = new JButton("");
		btnImprimir2.setBounds(302, 475, 136, 76);
		ImageIcon imgbutton4 = new ImageIcon("Img/atras.png");
		Icon imgicon4 = new ImageIcon(imgbutton2.getImage().getScaledInstance(btnImprimir2.getWidth(), btnImprimir2.getHeight(), Image.SCALE_DEFAULT));
		btnImprimir2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String nombre = lblNombre.getText();
				String paterno = lblPaterno.getText();
				String materno = lblMaterno.getText();
				String seguro = labelP.getText();				
				reporte = new GenerarReportePDF();
				reporte.generarTrasera(nombre, paterno, materno, seguro);
			}
		});
		btnImprimir2.setIcon(imgicon4);
		btnImprimir2.setBackground(Color.WHITE);
		contentPane.add(btnImprimir2);
		
		JButton btnSalir = new JButton("");
		btnSalir.setBounds(448, 475, 136, 76);
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
		btnSalir.setBackground(Color.WHITE);
		contentPane.add(btnSalir);
		
		
		
		JLabel label = new JLabel("Imprimir parte trasera");
		label.setBounds(302, 562, 136, 14);
		contentPane.add(label);
		
		JLabel lblBuscar = new JLabel("Buscar alumno");
		lblBuscar.setBounds(10, 562, 136, 14);
		contentPane.add(lblBuscar);
		
		JLabel lblImprimir = new JLabel("Imprimir parte frontal");
		lblImprimir.setBounds(156, 562, 136, 14);
		contentPane.add(lblImprimir);
		
		JLabel lblModi = new JLabel("Modificar datos institución.");
		lblModi.setBounds(1010, 562, 164, 14);
		contentPane.add(lblModi);
		
		JLabel lblSalir = new JLabel("Salir");
		lblSalir.setBounds(448, 562, 136, 14);
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

