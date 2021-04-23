package Ventana;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import persona.PersonaVO;

public class VentanaConsulta extends JDialog {
	
	private JScrollPane scrollArea;
	private JTextArea textArea;
	private JLabel titulo;
	
	public VentanaConsulta(Ven ventanaPrincipal, boolean modal, HashMap<String, PersonaVO> mapaPersonas){
		super(ventanaPrincipal, modal);
		initialize();
		setLocationRelativeTo(null);
		mostrarListaPersonas(mapaPersonas);
	}
		
		private void initialize() {
		getContentPane().setLayout(null);
		setSize(300,208);
		getContentPane().setBackground(Color.pink);
		
		titulo = new JLabel("consulta Lista");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		titulo.setBounds(58, 13, 272, 47);
		getContentPane().add(titulo);
	
		
		textArea= new JTextArea();
		textArea.setBounds(10,33,264,102);
		getContentPane().add(textArea);
		
		scrollArea = new JScrollPane();
		scrollArea.setBounds(10,50,264,102);
		scrollArea.setViewportView(textArea);
		getContentPane().add(scrollArea);
	}	
		private void mostrarListaPersonas(HashMap<String, PersonaVO> mapaPersonas) {
		System.out.println(mapaPersonas);
		String mensaje="";

		Iterator<String >elemento= mapaPersonas.keySet().iterator();
		while (elemento.hasNext()) {
			String llave  = elemento.next();
			mensaje+="documento:"+mapaPersonas.get(llave).getDocumento()+" ";
			mensaje+="Nombre:"+mapaPersonas.get(llave).getNombre()+"\n";
			mensaje+="Edad:"+mapaPersonas.get(llave).getEdad()+" ";
			mensaje+="direccion:"+mapaPersonas.get(llave).getDireccion()+"\n";
			mensaje+="*************";
		}
		textArea.setText(mensaje);
	}
}

