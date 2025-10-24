package ui;

import java.util.Scanner;
import java.time.LocalDate;
import model.SchoolController;

public class SchoolApp {

    private SchoolController schoolController;
    private Scanner input;

    public static void main(String[] args) {

        SchoolApp ui = new SchoolApp();
        ui.menu();

    }

    // Constructor
    public SchoolApp() {
        input = new Scanner(System.in);
    }

    public SchoolController getSchoolController() {
        return schoolController;
    }   
    public void setSchoolController(SchoolController schoolController) {
        this.schoolController = schoolController;
    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * El siguiente metodo esta incompleto.
     * Agregue la logica necesaria (instrucciones) para satisfacer los
     * requerimientos
     */

    public void menu() {

        System.out.println("Bienvenido a Computaricemos");

        int option = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("--------------------------------------------------------");
            System.out.println("Digite alguna de las siguientes opciones");
            System.out.println("1) Registrar computador");
            System.out.println("2) Registrar incidente en computador");
            System.out.println("3) Consultar el computador con más incidentes");
            System.out.println("0) Salir del sistema");
            option = input.nextInt();

            switch (option) {
                case 1:
                    registrarComputador();
                    break;
                case 2:
                    registrarIncidenteEnComputador();
                    break;
                case 3:
                    consultarComputadorConMasIncidentes();
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios. Adios!");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
                    break;
            }

        } while (option != 0);

    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Los siguientes metodos estan incompletos.
     * Agregue la logica necesaria (instrucciones) para satisfacer los
     * requerimientos
     */

    public void registrarComputador() {
        System.out.println("Elegiste la opcion de registrar un computador");
        input.nextLine(); // Limpiar el buffer
        System.out.println("Agrega el Numero de Serial del dispositivo: ");
        String numeroSerial=input.nextLine();
        input.nextLine();
        System.out.println("Indica el piso donde se ubica el computador");
        int piso=input.nextInt();
        if(piso<0 || piso>=5){
            System.out.println("Piso invalido, no está dentro del rango");
            return;
        }
        System.out.println("Indica la columna donde se ubica el computador");
        int columna=input.nextInt();
        if(columna<0 || columna>=10){
            System.out.println("Columna invalida, no está dentro del rango");
            return;
        }

        schoolController.agregarComputador(numeroSerial, piso, columna);




    }

    public void registrarIncidenteEnComputador() {

    }

    public void consultarComputadorConMasIncidentes() {

    }

}
