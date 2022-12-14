package conversorMoneda;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Conversor {
	
	Monedas mo = new Monedas();
	DecimalFormat df = new DecimalFormat("#.###");
	
	public void seleccionarDivisas() {
		
		String[] nombres = mo.nombreDivisas();
		Object opcion = JOptionPane.showInputDialog(null, "Selecciona el tipo de cambio:", "Conversor de divisas", JOptionPane.PLAIN_MESSAGE, null, nombres, null);
		cantidad(opcion.toString());
	}
	
	public void cantidad(String divisa) {
		String cantidad = JOptionPane.showInputDialog(null, "Ingresa la cantidad que deseas convertir:", "Conversor de divisas", JOptionPane.QUESTION_MESSAGE);
		double valor = 0;
		
		try {
			
			valor = Double.parseDouble(cantidad);
			convertir(divisa, valor);
			
		} catch (Exception e) {
			// TODO: handle exception
			mensajes("La cantidad ingresada no es valida: " + cantidad, 0);
		}
	}
	
	public void convertir(String divisa, double cantidad) {
		double valorDivisa = mo.precioDivisas(divisa);
		double total = 0;
		
		try {
			
			total = cantidad / valorDivisa;
			mensajes("Tienes: $" + df.format(total), 1);
			confirmacion();
		} catch (Exception e) {
			// TODO: handle exception
			mensajes(e.toString(), 0);
		}
		
	}
	
	public void mensajes(String msg, int tipoMsg) {
		JOptionPane.showMessageDialog(null, msg, "Conversor de divisas", tipoMsg);
	}
	
	public void confirmacion() {
		int confirm = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Conversor de divisas",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		
		if (confirm == 0) {
			seleccionarDivisas();
		}else if (confirm == 1 || confirm == 2) {
			mensajes("Programa Finalizado", 1);
		}
	}
	
	/*
	   JOptionPane.showInputDialog( <Ventana padre>,
	   "mensaje a desplegar",
	   "titulo de la ventana",
	    Tipo de JoptionPane,
	    Icono,
	    Opciones,
	    Opcion default);
	*/
	
}
