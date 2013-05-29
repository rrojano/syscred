package mx.uv.syscred;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import au.com.bytecode.opencsv.CSVWriter;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class IUModificarI extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel Ventana;
	private JTextField textNinstitucion;
	private JTextField textClave;
	private JTextField textNomcord;
	private JTextField textPweb, texttel;
	CsvReader reader;
	CsvWriter write;
	public String Telefono,Pweb,claveCl,Ninstitucion,Nombrecord;
	
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try
				{
					IUModificarI frame = new IUModificarI();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public IUModificarI() 
	{
	try 
	{
		CsvReader reader = new CsvReader("C:\\Users\\Luis Zavaleta\\git\\syscred\\BD\\institucion.csv");
		try 
		{
			while (reader.readRecord())
			{							
				Telefono = reader.get(0);
				Pweb = reader.get(1);
				claveCl = reader.get(2);
				Ninstitucion = reader.get(3);
				Nombrecord = reader.get(4);
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
		
		//Deficion de ventana
		setTitle("Modificar Datos Institucion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 390);
		Ventana = new JPanel();
		Ventana.setBorder(new EmptyBorder(35, 55, 35, 55));
		Ventana.setLayout(null);
		setContentPane(Ventana);
		//Termina definicion de Ventana
		
		//Definicion de Label's
		final JLabel lblNinstitucion = new JLabel("Institucion");
		lblNinstitucion.setBounds(10, 44, 80, 14);
		Ventana.add(lblNinstitucion);
		
		final JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(10, 91, 80, 14);
		Ventana.add(lblClave);
		
		final JLabel lblNomcord = new JLabel("Coordinador(a)");
		lblNomcord.setBounds(10, 136, 90, 14);
		Ventana.add(lblNomcord);
		
		final JLabel lblPweb = new JLabel("Web");
		lblPweb.setBounds(10, 224, 80, 14);
		Ventana.add(lblPweb);
		
		final JLabel lbltel = new JLabel("Telefono");
		lbltel.setBounds(10, 186, 80, 14);
		Ventana.add(lbltel);
		
		final JLabel lblIDfirma1 = new JLabel("Firma de Coordinador(a)");
		lblIDfirma1.setBounds(420, 12, 200, 30);
		Ventana.add(lblIDfirma1);
		
		final JLabel lblIDfirma = new JLabel();
        lblIDfirma.setBounds(384, 85, 200, 100);
        Ventana.add(lblIDfirma);
        ImageIcon imgfirma = new ImageIcon("Img/firma.jpg");
        Icon icono1 = new ImageIcon(imgfirma.getImage().getScaledInstance(lblIDfirma.getWidth(), lblIDfirma.getHeight(), Image.SCALE_DEFAULT));
        lblIDfirma.setIcon(icono1);
        this.repaint();
		
		//Termina deficinion de label's
		
		//Definicion de cuadros de texto
		textNomcord = new JTextField();
		textNomcord.setBounds(100, 133, 243, 20);
		textNomcord.setText(Nombrecord);
		Ventana.add(textNomcord);
		
		textPweb = new JTextField();
		textPweb.setBounds(100, 221, 243, 20);
		textPweb.setText(Pweb);
		Ventana.add(textPweb);
		
		textClave = new JTextField();
		textClave.setBounds(100, 88, 243, 20);
		textClave.setText(claveCl);
		Ventana.add(textClave);
		
		textNinstitucion = new JTextField();
		textNinstitucion.setBounds(100, 41, 243, 20);
		textNinstitucion.setText(Ninstitucion);
		Ventana.add(textNinstitucion);
		textNinstitucion.setColumns(10);
		
		texttel = new JTextField();
		texttel.setBounds(100, 180, 243, 20);
		texttel.setText(Telefono);
		Ventana.add(texttel);
		texttel.setColumns(10);
		//asignacion de datos
		
		//Definicon de Botonos y Acciones
		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		btnCancelar.setBounds(119, 283, 99, 50);
		Ventana.add(btnCancelar);
		
		final JButton btnBuscar = new JButton("Cambiar firma");
		btnBuscar.setBounds(420, 283, 99, 50);
		Ventana.add(btnBuscar);
		
		final JButton btnAceptar = new JButton("Modificar");
		btnAceptar.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e) 
			{
				String outputFile = "institucion.csv";
				boolean alreadyExists = new File(outputFile).exists();
				try {
					
					CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
					if (!alreadyExists)
					{
						
						csvOutput.endRecord();
					}
					String csv = "C:\\Users\\Luis Zavaleta\\git\\syscred\\BD\\institucion.csv";
					CSVWriter writer = new CSVWriter(new FileWriter(csv));
					Pweb=textPweb.getText();
					Telefono=texttel.getText();
					claveCl=textClave.getText();
					Ninstitucion=textNinstitucion.getText();
					Nombrecord=textNomcord.getText();
					List<String[]> data = new ArrayList<String[]>();
					data.add(new String[] { "Telefono", "Pweb","claveCl", "Ninstitucion","Nombrecord" });
					data.add(new String[] { Telefono, Pweb,claveCl, Ninstitucion,Nombrecord });
					writer.writeAll(data);					
					repaint();
					writer.close();
					csvOutput.close();
					JOptionPane.showMessageDialog(null, "Informacion Guardada");
					dispose();
				
				
				}catch (IOException e1) {
					e1.printStackTrace();
					
				}}
		});
		btnAceptar.setBounds(10, 283, 99, 50);
		Ventana.add(btnAceptar);
	}}


