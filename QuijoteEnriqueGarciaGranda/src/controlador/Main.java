package controlador;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import modelo.Metodos;

public class Main {

	public static void main(String[] args) throws IOException {
		File carpetaPrueba = new File("src");
		System.out.println(Metodos.buscarFichero("quijote.txt", carpetaPrueba));
		File rutaQuijote = new File(Metodos.buscarFichero("quijote.txt", carpetaPrueba));
		System.out.println("Nº Lineas " + Metodos.contarLineas(rutaQuijote));
		System.out.println("Nº veces Quijote " + Metodos.contarPalabra(rutaQuijote));
		System.out.println("Nº letras " + Metodos.contarLetras(rutaQuijote));
		Metodos.escribirLineasAlReves(rutaQuijote, new File("quijote al reves.txt"));
		HashMap<File, HashMap<String, Integer>> mapaFicheros = Metodos.mapaFicheros(new File("src"));

		for (File file : mapaFicheros.keySet()) {
			System.out.println(file.getName() + " " + mapaFicheros.get(file));
		}

	}
}
