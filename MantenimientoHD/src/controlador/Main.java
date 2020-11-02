package controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Logica;

public class Main {

	public static void main(String[] args) throws IOException {
		try {
			Logica l = new Logica();

			File ruta = new File("carpeta pruebas\\carpeta pruebas");
			HashMap<File, String> mapa = l.mapDiscoAlmacenamiento();
			ArrayList<File> lista = l.listarFicherosRuta(ruta);
			ArrayList<File> lista2;
			
			lista2 = l.ordenarListaFicheros(lista, "extension");

			for (File file : mapa.keySet()) {
				System.out.println(file.getAbsolutePath() + " " + mapa.get(file));
			}
			for (File file2 : lista2) {
				System.out.println(file2.getAbsolutePath());
			}

			System.out.println();

			lista2 = l.buscarRepetidoRuta(ruta);

			for (File file2 : lista2) {
				System.out.println(file2.getAbsolutePath());
			}
			l.copiarFicheros(ruta, new File("carpeta pruebas\\carpeta pruebas copia"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}