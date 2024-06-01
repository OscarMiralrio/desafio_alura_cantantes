package com.aluracursos.artist.util;

import java.time.LocalDate;
import java.util.Scanner;

public class Util {

    private static Scanner teclado = new Scanner(System.in);

    public static String nombreValidado(){
        System.out.println("Ingresa el nombre completo del cantante.");
        var nombreCompleto = teclado.nextLine().trim();
        // Validar que el nombre completo contiene al menos dos palabras y dos letras
        while (!esNombreValido(nombreCompleto)) {
            System.out.println("Nombre incompleto. Por favor, ingrese el nombre completo (nombre y apellido):");
            nombreCompleto = teclado.nextLine().trim();
        }
        return nombreCompleto;
    }

    public static String nombreArtisticoValidado(){
        System.out.println("Ingresa el nombre artistico del cantante.");
        var nombreArtistico = teclado.nextLine().trim();
        // Validar que el nombre completo contiene al menos una palabra y dos letras
        while (!esNombreArtisticoValido(nombreArtistico)) {
            System.out.println("Nombre incompleto. Por favor, ingrese el nombre artistico correcto:");
            nombreArtistico = teclado.nextLine().trim();
        }
        return nombreArtistico;
    }

    public static LocalDate fechaDeNacimientoValidada(){
        boolean isValid = false;
        var fechaDeNacimiento = "";
        LocalDate fechaNacimiento = null;
        do {
            System.out.println("Ingresa la fecha de nacimiento del cantante en el siguiente formato :: YYYY-MM-DD");
            fechaDeNacimiento = teclado.nextLine();
            try {
                fechaNacimiento = LocalDate.parse(fechaDeNacimiento);
                isValid = true;
            } catch (Exception e) {
                System.out.println(" :: FORMATO DE FECHA INVALIDO ::");
            }
        } while (!isValid);
        return fechaNacimiento;
    }

    public static String lugarDeNacimientoValidado(){
        System.out.println("Ingresa el lugar de nacimiento del cantante:");
        var lugarDeNacimiento = teclado.nextLine();
        return lugarDeNacimiento;
    }

    public static String nacionalidadValidado(){
        System.out.println("Ingresa la nacionalidad del cantante:");
        var nacionalidad = teclado.nextLine();
        return nacionalidad;
    }



    private static boolean esNombreValido(String nombreCompleto) {
        // Dividir la cadena en palabras usando espacios como separadores
        String[] palabras = nombreCompleto.split("\\s+");
        // Verificar que haya al menos dos palabras y que cada palabra tenga al menos 2 caracteres
        if (palabras.length < 2) {
            return false;
        }
        for (String palabra : palabras) {
            if (palabra.length() < 2) {
                return false;
            }
        }
        return true;
    }

    private static boolean esNombreArtisticoValido(String nombreCompleto) {
        // Dividir la cadena en palabras usando espacios como separadores
        String[] palabras = nombreCompleto.split("\\s+");
        // Verificar que haya al menos dos palabras y que cada palabra tenga al menos 2 caracteres
        if (palabras.length < 1) {
            return false;
        }
        for (String palabra : palabras) {
            if (palabra.length() < 2) {
                return false;
            }
        }
        return true;
    }

}
