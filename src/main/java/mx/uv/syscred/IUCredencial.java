package mx.uv.syscred;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.csvreader.CsvReader;


public class IUCredencial extends JFrame
{

	private JPanel contentPane, panel_Credencial;	
	private JLabel 
		lblSeguro,lblNombre,lblPaterno,lblMaterno, lblFoto, lblImgFrente, lblImgAtras, lblLocalidad,
		lblVigencia, lblClave, lblInstitucion, lblCoordinador, lblTelefono, lblWeb, lblFirma; 
	
	private String Telefono, Web, Clave, Institucion, NombreCord;
	private String Path_foto;
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
		try 
		{
			CsvReader reader = new CsvReader("C:\\Users\\Luis Zavaleta\\git\\syscred\\BD\\institucion.csv");
			try 
			{
				while (reader.readRecord())
				{							
					Telefono = reader.get(0);
					Web = reader.get(1);
					Clave = reader.get(2);
					Institucion = reader.get(3);
					NombreCord = reader.get(4);
				}
			}
			catch (IOException e1) 
			{
				e1.printStackTrace();
				}
			}
			 
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 10, 1250, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		panel_Credencial = new JPanel();
		panel_Credencial.setBounds(10, 0, 1200, 464);
		contentPane.add(panel_Credencial);
		panel_Credencial.setLayout(null);
		
		
		lblImgFrente = new JLabel("");
		lblImgFrente.setBounds(0, 11, 600, 442);
		panel_Credencial.add(lblImgFrente);
		ImageIcon imgFrente = new ImageIcon("Img/i222.png");
		Icon icono1 = new ImageIcon(imgFrente.getImage().getScaledInstance(lblImgFrente.getWidth(), lblImgFrente.getHeight(), Image.SCALE_DEFAULT));
		lblImgFrente.setIcon(icono1);
		this.repaint();
		
		lblImgAtras = new JLabel("");
		lblImgAtras.setBounds(601, 11, 600, 442);
		panel_Credencial.add(lblImgAtras);
		//ImageIcon imgAtras = new ImageIcon("Img/i111.png");
		ImageIcon imgAtras = new ImageIcon("i111.png");
		Icon icono2 = new ImageIcon(imgAtras.getImage().getScaledInstance(lblImgAtras.getWidth(), lblImgAtras.getHeight(), Image.SCALE_DEFAULT));
		lblImgAtras.setIcon(icono2);
		this.repaint();
		
		lblNombre = new JLabel("");
		lblNombre.setBounds(380, 135, 100, 23);
		panel_Credencial.add(lblNombre);
		
		lblPaterno = new JLabel("");
		lblPaterno.setBounds(380, 173, 150, 23);
		panel_Credencial.add(lblPaterno);
		
		lblMaterno = new JLabel("");
		lblMaterno.setBounds(380, 213, 200, 23);
		panel_Credencial.add(lblMaterno);
		
		lblSeguro = new JLabel("");
		panel_Credencial.add(lblSeguro);
		lblSeguro.setBounds(380,255,150,30);
		
		lblLocalidad = new JLabel("");
		panel_Credencial.add(lblLocalidad);
		lblLocalidad.setBounds(380, 295, 200, 30);

		
		/**DATOS DE LA INSTITUCIÓN QUE PUEDEN SER MODIFICADOS DESDE LA VENTANA MODIFICAR DATOS DE LA INSTITUCIÓN*/
		Calendar c1 = Calendar.getInstance();
		String annio1 = Integer.toString(c1.get(Calendar.YEAR));
		String annio2 = Integer.toString(c1.get(Calendar.YEAR)+1);
		
		lblVigencia = new JLabel();
		lblVigencia.setBounds(160, 385, 118, 23);
		lblVigencia.setText((annio1+" - "+annio2));
		lblVigencia.setFont(new java.awt.Font("Tahoma", 0, 20));
		panel_Credencial.add(lblVigencia);
		
		lblClave = new JLabel();
		lblClave.setBounds(135, 186, 118, 23);
		lblClave.setText(Clave);
		lblClave.setFont(new java.awt.Font("Tahoma", 0, 20));
		panel_Credencial.add(lblClave);
		
		lblInstitucion = new JLabel();
		lblInstitucion.setBounds(160, 120, 500, 23);
		lblInstitucion.setText(Institucion);
		lblInstitucion.setFont(new java.awt.Font("Tahoma", 0, 20));
		panel_Credencial.add(lblInstitucion);
		
		lblCoordinador = new JLabel("Coordinador");
		lblCoordinador.setBounds(300, 375, 400, 30);
		lblCoordinador.setText(NombreCord);
		lblCoordinador.setFont(new java.awt.Font("Tahoma", 0, 20));
		panel_Credencial.add(lblCoordinador);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(170, 258, 200, 23);
		lblTelefono.setText(Telefono);
		lblTelefono.setFont(new java.awt.Font("Tahoma", 0, 20));
		panel_Credencial.add(lblTelefono);
		
		lblWeb = new JLabel();
		lblWeb.setBounds(50, 340, 200, 23);
		lblWeb.setText(Web);
		lblWeb.setFont(new java.awt.Font("Tahoma", 0, 20));
		panel_Credencial.add(lblWeb);
		
		lblFirma = new JLabel();
		lblFirma.setBounds(320, 160, 150, 150);		
		ImageIcon imgfirma = new ImageIcon("Img/firma.jpg");
		Icon imgicon9 = new ImageIcon(imgfirma.getImage().getScaledInstance(lblFirma.getWidth(), lblFirma.getHeight(), Image.SCALE_DEFAULT));
		lblFirma.setIcon(imgicon9);
		panel_Credencial.add(lblFirma);
		
		
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
		btnModificar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				IUModificarI IUMI = new IUModificarI();
				IUMI.show();
			}
		});
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
				String seguro = lblSeguro.getText();
				String foto = Path_foto;
				reporte = new GenerarReportePDF();
				reporte.generarDelantera(nombre, paterno, materno, seguro, foto);
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
				String seguro = lblSeguro.getText();				
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
		
		/*lblVigencia, lblClave, lblInstitucion, lblCoordinador, lblTelefono, lblWeb, lblFirma;*/
		lblImgFrente.add(lblNombre);
		lblImgFrente.add(lblPaterno);
		lblImgFrente.add(lblMaterno);
		lblImgFrente.add(lblSeguro);
		lblImgFrente.add(lblLocalidad);
		
		lblImgAtras.add(lblCoordinador);
		lblImgAtras.add(lblClave);
		lblImgAtras.add(lblInstitucion);
		lblImgAtras.add(lblTelefono);
		lblImgFrente.add(lblWeb);
		lblImgAtras.add(lblFirma);
		lblImgFrente.add(lblVigencia);
		
	}
	
	public void setL (String Nseguro1)
	{
		lblSeguro.setText(Nseguro1);
		lblSeguro.setFont(new java.awt.Font("Tahoma", 0, 30));
	}
	public void setL2 (String Nombre1)
	{
		lblNombre.setText(Nombre1);
		lblNombre.setFont(new java.awt.Font("Tahoma", 0, 30));
	}
	public void setL3 (String Apaterno1)
	{
		lblPaterno.setText(Apaterno1);
		lblPaterno.setFont(new java.awt.Font("Tahoma", 0, 30));
	}
	public void setL4 (String Amaterno1)
	{
		lblMaterno.setText(Amaterno1);
		lblMaterno.setFont(new java.awt.Font("Tahoma", 0, 30));
	}	
	
	public void setLocalidad (String Localidad1)
	{
		lblLocalidad.setText(Localidad1);
		lblLocalidad.setFont(new java.awt.Font("Tahoma", 0, 30));
	}
	public void setFoto (String path)
	{
		lblFoto = new JLabel("");
		lblFoto.setBounds(30, 150, 150, 180);
		ImageIcon imgFoto = new ImageIcon("Img/"+path+".jpg");
		Path_foto = "Img/"+path+".jpg";
		Icon icono8 = new ImageIcon(imgFoto.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
		lblFoto.setIcon(icono8);
		panel_Credencial.add(lblFoto);
		lblImgFrente.add(lblFoto);
		
	}
}

