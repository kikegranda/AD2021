package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.StringTokenizer;

public class Logica {

	/**
	 * Carga una ArrayList con los datos de un archivo csv del tiempo de Aemet
	 * @param archivocsv el archivo con los datos
	 * @return una ArrayList con los datos del archivo
	 * @throws IOException
	 * @throws ParseException 
	 * @throws Exception
	 */
	public static ArrayList<DatosAemet> listaDelTiempo(File archivocsvAemet) throws IOException, ParseException {
		ArrayList<DatosAemet> listaDelTiempo = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(archivocsvAemet));
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
		String linea;
		Boolean primeraLinea = true;
		while ((linea = br.readLine()) != null) {
			if (primeraLinea == true) {
				primeraLinea = false;
			} else {
				linea = linea.replaceAll(",", ".");
				StringTokenizer st = new StringTokenizer(linea, ";");
				String stringFecha = st.nextToken();
				Date fecha = sdt.parse(stringFecha);
				String indicativo = st.nextToken();
				String nombre = st.nextToken();
				String provincia = st.nextToken();
				Integer altitud = Integer.parseInt(st.nextToken());
				Double tmed = Double.parseDouble(st.nextToken());
				String prec = st.nextToken();
				Double tmin = Double.parseDouble(st.nextToken());
				String horatmin = st.nextToken();
				Double tmax = Double.parseDouble(st.nextToken());
				String horatmax = st.nextToken();
				Integer dir = Integer.parseInt(st.nextToken());
				Double velmedia = Double.parseDouble(st.nextToken());
				Double racha = Double.parseDouble(st.nextToken());
				String horaracha = st.nextToken();
				Double sol = Double.parseDouble(st.nextToken());
				Double presmax = Double.parseDouble(st.nextToken());
				String horaPresMax = st.nextToken();
				Double presmin = Double.parseDouble(st.nextToken());
				String horaPresMin = st.nextToken();
				listaDelTiempo.add(new DatosAemet(fecha, indicativo, nombre, provincia, altitud, tmed, prec, tmin,
						horatmin, tmax, horatmax, dir, velmedia, racha, horaracha, sol, presmax, horaPresMax, presmin,
						horaPresMin));
			}
		}
		br.close();
		return listaDelTiempo;
	}

	public static Date diaTempMax(ArrayList<DatosAemet> listaAemet) {
		listaAemet.sort(new ComparatorTemperatura());
		return listaAemet.get(0).getFecha();
	}

}

class ComparatorTemperatura implements Comparator<DatosAemet> {

	@Override
	public int compare(DatosAemet arg0, DatosAemet arg1) {
		return arg0.getTmax().compareTo(arg1.getTmax());
	}
}
