package mx.uv.syscred;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;


public class IUAutenticacion extends JFrame {

	private JPanel Contenedor;
	private JTextField textUsuario;
	private JPasswordField textContrasena;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try
				{
					IUAutenticacion frame = new IUAutenticacion();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}


	public IUAutenticacion() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		Contenedor = new JPanel();
		Contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		Contenedor.setLayout(null);
		setContentPane(Contenedor);
		
		final JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 44, 80, 14);
		Contenedor.add(lblUsuario);
		
		final JLabel lblContrasena = new JLabel("Contrase�a");
		lblContrasena.setBounds(10, 78, 80, 14);
		Contenedor.add(lblContrasena);
		
		textContrasena = new JPasswordField();
		textContrasena.setBounds(100, 75, 130, 20);
		Contenedor.add(textContrasena);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(100, 41, 130, 20);
		Contenedor.add(textUsuario);
		textUsuario.setColumns(10);
		
		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		btnCancelar.setBounds(141, 106, 89, 23);
		Contenedor.add(btnCancelar);
		
		final JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e) 
			{
				if((textUsuario.getText().equals("Admin")) && (textContrasena.getText().equals("Admin")))
				{				
					IUCredencial IUC = new IUCredencial(); 
					IUC.show();
					dispose();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error de autenticaci�n");
					textUsuario.setText("");
					textContrasena.setText("");					
				}
			}
		});
		btnAcceder.setBounds(42, 106, 89, 23);
		Contenedor.add(btnAcceder);
	}	
}
