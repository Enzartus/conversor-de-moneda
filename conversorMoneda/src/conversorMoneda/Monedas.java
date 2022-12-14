package conversorMoneda;

public class Monedas {
	
	//Arreglo de nombres de divisas y valor
	private String[][] divisas = {
			{"Dolar estadounidense","19.60"},
			{"Euro","20.83"},
			{"Libra esterlina","24.20"},
			{"Yen japonés","0.14"},
			{"Won surcoreano","0.015"}
	};

	//Seleccion de nombre de divisas
	public String[] nombreDivisas() {
		String[] arrayNombre = new String[divisas.length];
		String titleDivisas = "Convertir del Peso Mexicano a ";
		
		for (int i = 0; i < divisas.length; i++) {
			arrayNombre[i] = titleDivisas + divisas[i][0];
		}
		
		return arrayNombre;
	}
	
	//Seleccion de costo divisas
	public double precioDivisas(String moneda) {
		double valor = 0;
		
		for (int i = 0; i < divisas.length; i++) {
			if (moneda.contains(divisas[i][0])) {
				valor = Double.parseDouble(divisas[i][1]);
			}
		}
		
		return valor;
	}
	
}
