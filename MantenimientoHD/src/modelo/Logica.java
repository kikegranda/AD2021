package modelo;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Logica implements InterfazFiles {

	@Override
	public HashMap<File, String> mapDiscoAlmacenamiento() {
		HashMap<File, String> mapDiscoAlmacenamiento = new HashMap<>();
		File[] Discos = File.listRoots();
		DecimalFormat df = new DecimalFormat(".##");
		for (File disco : Discos) {
			mapDiscoAlmacenamiento.put(disco,
					df.format((Double.valueOf(disco.getUsableSpace()) / 1024 / 1024 / 1024)) + " GB");
		}
		return mapDiscoAlmacenamiento;
	}

	@Override
	public ArrayList<File> listarFicherosRuta(File directorio, FilenameFilter filtro) {
		ArrayList<File> listaFicherosRuta = new ArrayList<>();
		File[] contenidoCarpetas = directorio.listFiles(filtro);
		for (File fichero : contenidoCarpetas) {
			if (fichero.isDirectory()) {
				for (File file : listarFicherosRuta(fichero, filtro)) {
					listaFicherosRuta.add(file);
				}
			} else {
				listaFicherosRuta.add(fichero);
			}
		}
		return listaFicherosRuta;
	}

	@Override
	public ArrayList<File> listarFicherosRuta(File directorio) {
		return listarFicherosRuta(directorio, null);
	}

	@Override
	public ArrayList<File> ordenarListaFicheros(ArrayList<File> listarFicherosRuta, String tipoOrden) throws Exception {
		if (tipoOrden.equalsIgnoreCase("nombre")) {
			listarFicherosRuta.sort(new ComparatorNombre());
			return listarFicherosRuta;
		} else if (tipoOrden.equalsIgnoreCase("tamaño")) {
			listarFicherosRuta.sort(new ComparatorSize());
			return listarFicherosRuta;
		} else if (tipoOrden.equalsIgnoreCase("extension")) {
			listarFicherosRuta.sort(new ComparatorExtension());
			return listarFicherosRuta;
		} else {
			throw new Exception("Por favor introduce un valor para tipoOrden valido");
		}
	}

	@Override
	public ArrayList<File> buscarRepetidoRuta(File ruta) {
		ArrayList<File> repetidos = listarFicherosRuta(ruta);
		ArrayList<File> sinRepetidos = listarFicherosRuta(ruta);
		for (File file1 : repetidos) {
			for (File file2 : repetidos) {
				if (file1.getName().equals(file2.getName()) && file1.length() == file2.length()
						&& !file1.getAbsolutePath().equals(file2.getAbsolutePath())) {
					sinRepetidos.remove(file1);
				}
			}
		}

		for (File file : sinRepetidos) {
			repetidos.remove(file);
		}

		return repetidos;
	}

	@Override
	public Integer eliminarFicherosRuta(File ruta) {
		Integer contador = 0;
		ArrayList<File> listaBorrar = listarFicherosRuta(ruta);
		for (File file : listaBorrar) {
			file.delete();
			contador++;
		}
		return contador;
	}

	@Override
	public Integer copiarFicheros(File rutaOrigen, File rutaDestino) throws IOException {
		Integer contador = 0;
		String[] ficheros = rutaOrigen.list();
		if (rutaOrigen.isDirectory()) {
			if (!rutaDestino.exists()) {
				rutaDestino.mkdirs();
			}
			for (String nombreFichero : ficheros) {
				File nuevaRutaOrigen = new File(rutaOrigen, nombreFichero);
				File nuevaRutaDestino = new File(rutaDestino, nombreFichero);
				contador += copiarFicheros(nuevaRutaOrigen, nuevaRutaDestino);
			}
		} else {
			Files.copy(rutaOrigen.toPath(), rutaDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
			contador++;
		}
		return contador;
	}

	@Override
	public ArrayList<File> buscarFicherosNombre(String cadenaTextoNombre, File directorio) {
		ArrayList<File> listaFicherosNombre = listarFicherosRuta(directorio);
		for (File archivo : listaFicherosNombre) {
			if (!archivo.getName().contains(cadenaTextoNombre)) {
				listaFicherosNombre.remove(archivo);
			}
		}
		return listaFicherosNombre;
	}

	class ComparatorSize implements Comparator<File> {

		@Override
		public int compare(File arg0, File arg1) {
			return (int) (arg0.length() - arg1.length());
		}

	}

	class ComparatorNombre implements Comparator<File> {

		@Override
		public int compare(File arg0, File arg1) {
			return arg0.getName().compareToIgnoreCase(arg1.getName());
		}

	}

	class ComparatorExtension implements Comparator<File> {

		@Override
		public int compare(File arg0, File arg1) {
			String[] extension0 = arg0.getName().split("\\.");
			String[] extension1 = arg1.getName().split("\\.");
			return extension0[extension0.length - 1].compareToIgnoreCase(extension1[extension1.length - 1]);
		}
	}
}