package com.company.agenda;

import java.util.HashMap;
import java.util.Scanner;

public class AgendaContactos {

    //variable local de la clase.
    private HashMap<Long, String> agenda = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private int opcion = 0;

    public void iniciarApp(){
        do {
            showMenu();
            comprobarOpcion(opcion);
        } while (opcion != 4);
    }

    private void showMenu() {
        System.out.println("==============================");
        System.out.println("1. Nuevo contacto");
        System.out.println("2. Eliminar contacto");
        System.out.println("3. Mostrar todos los contactos");
        System.out.println("4. Salir del programa");
        System.out.println();
        System.out.print("Elije una opción: ");
        opcion = sc.nextInt();
        System.out.println("==============================");
    }

    private void comprobarOpcion(int opcion){
        switch (opcion) {
            case 1:
                nuevoContacto();
                break;
            case 2:
                eliminarContacto();
                break;
            case 3:
                mostrarContactos();
                break;
            case 4:
                //SALIMOS DEL PROGRAMA
                System.out.println("Hasta Pronto!!!!!!!");
                break;
            default:
                System.out.println("La opcion elegida no es valida");
        }
    }

    private void nuevoContacto(){
        System.out.print("Introduce su DNI: ");
        long dni = sc.nextLong();
        sc.nextLine();
        System.out.print("Introduce su NOMBRE: ");
        String nombre = sc.nextLine();

        agenda.put(dni, nombre);

    }

    private void eliminarContacto(){
        System.out.print("Introduce su DNI: ");
        long dni = sc.nextLong();

        if(agenda.containsKey(dni)){
            agenda.remove(dni);
        } else {
            System.out.println("El DNI introducido no existe en la agenda");
        }
    }

    private void mostrarContactos(){
        agenda.forEach( (a,b) -> System.out.println(a + "-" + b));
    }

}
