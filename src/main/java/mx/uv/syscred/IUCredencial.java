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


public class IUCredencial extends JFrame
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
	
}
