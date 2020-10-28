package controlador;

import java.io.File;
import java.util.ArrayList;
import modelo.*;

public class Main {

	public static void main(String[] args) {
		try {
			// EL LIBRO CON LAS FECHAS DE 2019 TIENE VARIOS PARAMETROS EN BLANCO(POR EJEMPLO
			// EN EL 24 DE ENERO O EL 2 DE FEBRERO) Y NO SE PUEDE PARSEAR
			ArrayList<DatosAemet> listaDelTiempo = Logica.listaDelTiempo(new File("LibroSeptiembre2020.csv"));

			System.out.println(Logica.diaTempMax(listaDelTiempo).toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
