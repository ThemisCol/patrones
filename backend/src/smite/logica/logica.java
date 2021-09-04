package smite.logica;

import javax.swing.JOptionPane;
import smite.connection.IRegla;

public class logica implements IRegla {

	public void verificarDisponibilidad() {
		JOptionPane.showMessageDialog(null,getClass().getDeclaredMethods()[0].getName());
	}
}
