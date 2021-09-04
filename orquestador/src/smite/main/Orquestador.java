package smite.main;

import smite.connection.IEntrada;
import smite.connection.IRegla;
import smite.connection.ISalida;
import smite.utils.Cargador;

public class Orquestador { 
	void moderador() {
		Cargador cf  = new Cargador("front");
		try {
			Class cls = cf.getClase(IEntrada.class.getName());
			if(cls!=null) {
			   IEntrada ie  = (IEntrada)cls.newInstance();
			   ie.recibirData();			   
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		Cargador cb  = new Cargador("back");
		try {
			Class cls=cb.getClase(IRegla.class.getName());
			if(cls!=null) {
			   IRegla ie  = (IRegla)cls.newInstance();			
			   ie.verificarDisponibilidad();
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		try {
			Class cls = cf.getClase(IEntrada.class.getName());
			if(cls!=null) {
				ISalida ie  = (ISalida)cls.newInstance();
				ie.enviarData();					
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {	
		//IRegla ir = new Core();	
		//ir.verificarReglas();
		new Orquestador().moderador();
	}

}
