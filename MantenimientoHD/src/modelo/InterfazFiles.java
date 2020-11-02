package modelo;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public interface InterfazFiles {
	/**
	 * Crea un mapa con las unidades del disco y el almacenamiento disponible
	 * 
	 * @return mapa con las unidades del disco y el almacenamiento disponible
	 */
	public HashMap<File, String> mapDiscoAlmacenamiento();

	/**
	 * Lista los archivos que hay en una ruta
	 * 
	 * @param Directorio donde busca
	 * @param filtro     para indicar si quieres solo un tipo de archivo en concreto
	 * 
	 * @return ArrayList con directorios
	 */
	public ArrayList<File> listarFicherosRuta(File directorio, FilenameFilter filtro);

	/**
	 * Lista los archivos que hay en una ruta
	 * 
	 * @param Directorio donde va a buscar
	 * 
	 * @return ArrayList con los archivos
	 */
	public ArrayList<File> listarFicherosRuta(File directorio);

	/**
	 * Ordena lista del metodo listarFicherosRuta
	 * 
	 * @param listarFicherosRuta lista
	 * @param tipoOrden          como la quieres ordenada (por tamaño, nombre o
	 *                           extensión.)
	 * @return ArrayList ordenada
	 * @throws Exception
	 */
	public ArrayList<File> ordenarListaFicheros(ArrayList<File> listarFicherosRuta, String tipoOrden) throws Exception;

	/**
	 * Busca los archivos repetidos dentro de una ruta y los mete en una lista
	 * 
	 * @param ruta donde buscar
	 * @return ArrayList con los archivos ordenados
	 */
	public ArrayList<File> buscarRepetidoRuta(File ruta);

	/**
	 * Elimina TODOS los ficheros de una ruta
	 * 
	 * @param ruta donde eliminar
	 * @return numero de archivos borrados
	 */
	public Integer eliminarFicherosRuta(File ruta);

	/**
	 * Copia los ficheros de una ruta
	 * 
	 * @param rutaOrigen  ruta de la que se van a copiar los ficheros
	 * @param rutaDestino ruta a donde se van a copiar los ficheros
	 * @return numero de archivos copiados
	 * @throws IOException
	 */
	public Integer copiarFicheros(File rutaOrigen, File rutaDestino) throws IOException;

	/**
	 * Busca los ficheros por nombre de archivo en un directorio
	 * 
	 * @param cadenaTextoNombre el nombre del archivo
	 * @param directorio        donde buscar
	 * @return Lista con los archivos que se llaman de esa forma
	 */
	public ArrayList<File> buscarFicherosNombre(String cadenaTextoNombre, File directorio);
}
