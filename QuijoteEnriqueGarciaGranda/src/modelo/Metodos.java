package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Metodos {
	/**
	 * Busca el fichero seleccionado en la carpeta indicada y sus subcarpetas
	 * 
	 * @param nombreFichero el nombre del fichero a buscar
	 * @param directorio    la carpeta en la que buscar
	 * @return la ruta del fichero
	 * @throws IOException
	 */
	public static String buscarFichero(String nombreFichero, File directorio) throws IOException {
		String rutaFichero = "";
		File[] contenidoCarpetas = directorio.listFiles();
		for (File fichero : contenidoCarpetas) {
			if (fichero.isDirectory()) {
				rutaFichero = buscarFichero(nombreFichero, fichero);
			} else if (nombreFichero.equals(fichero.getName())) {
				rutaFichero = fichero.getCanonicalPath();
			}
		}

		return rutaFichero;
	}

	/**
	 * Busca el fichero seleccionado en la primera partiion del disco duro
	 * 
	 * @param nombreFichero el nombre del fichero a buscar
	 * @return la ruta del fichero
	 * @throws IOException
	 */
	public static String buscarFichero(String nombreFichero) throws IOException {
		String rutaFichero = "";
		File directorio = File.listRoots()[0];
		File[] contenidoCarpetas = directorio.listFiles();
		for (File fichero : contenidoCarpetas) {
			if (fichero.isDirectory()) {
				rutaFichero = buscarFichero(nombreFichero, fichero);
			} else if (nombreFichero.equals(fichero.getName())) {
				rutaFichero = fichero.getCanonicalPath();
			}
		}

		return rutaFichero;
	}

	/**
	 * Cuenta el numero de lineas en un fichero
	 * 
	 * @param fichero el fichero donde se van a contar
	 * @return numero de lineas
	 * @throws IOException
	 */
	public static int contarLineas(File fichero) throws IOException {
		int nLineas = 0;
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		while (br.readLine() != null) {
			nLineas++;
		}
		br.close();

		return nLineas;
	}

	/**
	 * Cuenta el numero de veces que una palabra aparece en un fichero
	 * 
	 * @param fichero el fichero donde se van a contar
	 * @param palabra la palabra que se va a contar
	 * @return numero de veces que aparece la palabra
	 * @throws IOException
	 */
	public static int contarPalabra(File fichero, String palabra) throws IOException {
		int nPalabras = 0;
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		String linea;
		while ((linea = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(linea);
			while (st.hasMoreElements()) {
				if (palabra.toUpperCase().contains(st.nextToken().toUpperCase())) {
					nPalabras++;
				}
			}
		}
		br.close();
		return nPalabras;
	}

	/**
	 * Cuenta el numero de veces que aparece la palabra "Quijote" en un fichero
	 * 
	 * @param fichero el fichero donde se va a contar
	 * @return numero de veces que aparece la palabra
	 * @throws IOException
	 */
	public static int contarPalabra(File fichero) throws IOException {
		String palabra = "Quijote";
		int nPalabras = 0;
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		String linea;
		while ((linea = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(linea);
			while (st.hasMoreElements()) {
				if (palabra.toUpperCase().contains(st.nextToken().toUpperCase())) {
					nPalabras++;
				}
			}
		}
		br.close();
		return nPalabras;
	}

	/**
	 * Cuenta el numero de letras que hay en un fichero
	 * 
	 * @param fichero el fichero donde se va a contar
	 * @return numero de letras
	 * @throws IOException
	 */
	public static int contarLetras(File fichero) throws IOException {
		int nLetras = 0;
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		String linea;
		while ((linea = br.readLine()) != null) {
			linea = linea.replaceAll("[^a-zA-Z0-9]", "");
			nLetras = nLetras + linea.length();
		}
		br.close();
		return nLetras;
	}

	/**
	 * Escribe un fichero al reves
	 * 
	 * @param fichero       el fichero que se va a cambiar
	 * @param ficheroSalida el fichero cambiado
	 * @throws IOException
	 */
	public static void escribirLineasAlReves(File fichero, File ficheroSalida) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida));
		ArrayList<String> listaLineas = new ArrayList<>();
		String linea;
		while ((linea = br.readLine()) != null) {
			listaLineas.add(linea);
		}
		for (int nLinea = listaLineas.size() - 1; nLinea >= 0; nLinea--) {
			bw.write(listaLineas.get(nLinea) + "\n");
		}
		br.close();
		bw.close();
	}

	/**
	 * Mapa con todas las palabras y el numero de veces que aparecen
	 * 
	 * @param fichero fichero a leer
	 * @return mapa con las palabras y el numero
	 * @throws IOException
	 */
	public static HashMap<String, Integer> mapaPalabras(File fichero) throws IOException {
		HashMap<String, Integer> mapaPalabras = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		String linea;
		while ((linea = br.readLine()) != null) {
			linea = linea.replaceAll("[.,;:?¿!¡']", "").toLowerCase();
			linea = linea.replace("\"", "");
			StringTokenizer st = new StringTokenizer(linea);
			while (st.hasMoreElements()) {
				String palabra = st.nextToken();
				if (!mapaPalabras.containsKey(palabra)) {
					mapaPalabras.put(palabra, Integer.valueOf(1));
				} else {
					mapaPalabras.put(palabra,
							mapaPalabras.get(palabra) + Integer.valueOf(1 + mapaPalabras.get(palabra)));
				}
			}
		}
		br.close();
		return mapaPalabras;
	}

	/**
	 * Mapa con todos los ficheros y el numero de veces que aparecen y otro mapa con
	 * todas las palabras y el numero de veces que aparecen
	 * 
	 * @param directorio directorio en el que buscar
	 * @return mapa con los ficheros y el numero
	 * @throws IOException
	 */
	public static HashMap<File, HashMap<String, Integer>> mapaFicheros(File directorio) throws IOException {
		HashMap<File, HashMap<String, Integer>> mapaFicheros = new HashMap<>();
		ArrayList<File> listaFicheros = buscarFicheros(directorio, ".txt");
		for (File fichero : listaFicheros) {
			mapaFicheros.put(fichero, mapaPalabras(fichero));
		}
		return mapaFicheros;
	}

	/**
	 * Busca todos los txts de una carpeta y los mete en una lista
	 * 
	 * @param directorio la carpeta en la buscar
	 * @return lista con ficheros
	 * @throws IOException
	 */
	private static ArrayList<File> buscarFicheros(File directorio, String extension) throws IOException {
		ArrayList<File> rutasFicheros = new ArrayList<>();
		File[] contenidoCarpetas = directorio.listFiles();
		for (File fichero : contenidoCarpetas) {
			if (fichero.isDirectory()) {
				for (File file : buscarFicheros(fichero,extension)) {
					rutasFicheros.add(file);
				}
				rutasFicheros = buscarFicheros(fichero, extension);
			} else if (fichero.getName().endsWith(extension)) {
				rutasFicheros.add(fichero);
			}
		}
		return rutasFicheros;
	}
}
