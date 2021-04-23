package Ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import persona.PersonaVO;

public class Ven extends JFrame implements ActionListener {

	
	private JPanel panelV;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtDireccion;
	
	private JButton btnRegistrar, btnBuscar, btnEliminar, btnConsultar;
	HashMap<String, PersonaVO> mapaPersonas;
	

	public Ven() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650,386);
		setLocationRelativeTo(null);
		panelV = new JPanel();
		panelV.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelV);
		panelV.setLayout(null);
		panelV.setBackground(Color.pink);
		iniciarComponentes();
		
		mapaPersonas = new HashMap <String, PersonaVO>();
       
       
	}
	private void iniciarComponentes() {

		JLabel titleRegistroP = new JLabel("Registrar persona");
		titleRegistroP.setFont(new Font("Tahoma", Font.BOLD, 25));
		titleRegistroP.setBounds(228, 13, 272, 47);
		panelV.add(titleRegistroP);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(238, 110, 79, 16);
		panelV.add(lblNombre);
		
		JLabel lblDocumento = new JLabel("Documento: ");
		lblDocumento.setBounds(35, 110, 167, 16);
		panelV.add(lblDocumento);
		
		JLabel lblEdad = new JLabel("edad: ");
		lblEdad.setBounds(35, 181, 148, 22);
		panelV.add(lblEdad);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(251, 184, 115, 16);
		panelV.add(lblDireccion);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(110, 107, 116, 22);
		panelV.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(294, 107, 319, 22);
		panelV.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(98, 184, 116, 22);
		panelV.add(txtEdad);
		txtEdad.setColumns(10);
	
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(316, 184, 116, 22);
		panelV.add(txtDireccion);
		
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(35, 258, 120, 25);
		btnRegistrar.addActionListener((ActionListener) this);
		panelV.add(btnRegistrar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(191, 258, 120, 25);
		btnBuscar.addActionListener((ActionListener) this);
		panelV.add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(348, 258, 120, 25);
		btnEliminar.addActionListener((ActionListener) this);
		panelV.add(btnEliminar);	
		
		btnConsultar = new JButton("Consultar lista");
		btnConsultar.setBounds(498, 258, 120, 25);
		btnConsultar.addActionListener((ActionListener) this);
		panelV.add(btnConsultar);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnRegistrar) {
			registrarPersona(mapaPersonas);
			
		}
		if (e.getSource()==btnBuscar) {
			consultarPersona(mapaPersonas);
		}
		if (e.getSource()==btnEliminar) {
			eliminarPersona(mapaPersonas);
			
		}
		if (e.getSource()==btnConsultar) {
			VentanaConsulta ventanaConsulta = new VentanaConsulta(this, true, mapaPersonas);
			ventanaConsulta.setVisible(true);
			
		}
		
	}
	
	private void registrarPersona(HashMap<String, PersonaVO> mapaPersonas) {
		PersonaVO miPersona = new PersonaVO();
		miPersona.setDocumento(txtDocumento.getText());
		miPersona.setNombre(txtNombre.getText());
		miPersona.setEdad(Integer.parseInt(txtEdad.getText()));
		miPersona.setDireccion(txtDireccion.getText());
		
		if(mapaPersonas.containsKey(miPersona.getDocumento())==false){
			mapaPersonas.put(miPersona.getDocumento(), miPersona);
			System.out.println("almacena");
			limpiarCampos();
			JOptionPane.showMessageDialog(null,"usuario registrado con exito","Advertencia", JOptionPane.WARNING_MESSAGE);
		
		}else {
			JOptionPane.showMessageDialog(null, "el documento ya es existente","Advertencia", JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
	
	private void consultarPersona(HashMap<String, PersonaVO> mapaPersonas) {
		String msj="Datos de la persona";
		String documento=JOptionPane.showInputDialog("ingrese el documento de la persona ");
		
		if(mapaPersonas.containsKey(documento)== true) {
			PersonaVO persona= mapaPersonas.get(documento);
			msj+="Documento: "+persona.getDocumento()+"\n";
			msj+="nombre: "+persona.getNombre()+"\n";
			msj+="edad: "+persona.getEdad()+"\n";
			msj+="direccion: "+persona.getDireccion()+"\n";
			
			JOptionPane.showMessageDialog(null, msj);
			
		}
		else {
			JOptionPane.showMessageDialog(null, "el documento no existe","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void eliminarPersona(HashMap<String, PersonaVO> mapaPersonas2) {
		String documento=JOptionPane.showInputDialog("ingrese el documento de la persona a eliminar");
		if(mapaPersonas.containsKey(documento)) {
			mapaPersonas.remove(documento);
			System.out.println("persona eliminada");
			JOptionPane.showMessageDialog(null, "se elimino la persona","advertencia", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "el documento no existe","Error", JOptionPane.ERROR_MESSAGE);
		}
				
		
	}
	private void limpiarCampos() {
		txtDocumento.setText("");
		txtNombre.setText("");
		txtEdad.setText("");
		txtDireccion.setText("");
	}

}
