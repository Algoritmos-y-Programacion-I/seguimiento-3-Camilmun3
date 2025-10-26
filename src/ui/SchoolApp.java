package ui;

import java.util.Scanner;
import java.time.LocalDate;
import model.SchoolController;

public class SchoolApp {
    private SchoolController schoolController;
    private Scanner input;

    public static void main(String[] args) {

        SchoolApp ui = new SchoolApp();
        ui.schoolController = new SchoolController("Escuela Computaricemos", 0);
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


/**
 * Verifica si ya existe o no un computador con el número de serie indicado.
 * 
 * Descripción: Este método se usa antes de registrar un nuevo computador para asegurarse
 * de que no haya duplicados en el sistema. Básicamente revisa toda la matriz 
 * de computadores y busca coincidencias por número de serie.
 * 
 * @param numeroSerial El número de serie que se quiere verificar.
 * @pre El número de serie no debe ser nulo ni estar vacío.
 * @post No cambia nada en el sistema, solo consulta información.
 * @return true si el serial NO existe (es decir, se puede registrar); 
 *         false si ya está en uso.
 */

    public boolean verificacionExistencia(String numeroSerial) {
        return schoolController.comprobacionRepeticion(numeroSerial);
    }

/**
 * Permite registrar un nuevo computador dentro del sistema.
 * 
 * Descripción: Este método le pide al usuario que ingrese el número de serie y el piso 
 * donde se ubicará el computador. También valida que el número de serie no 
 * esté repetido y que el piso esté dentro del rango permitido (0 a 4). 
 * Si todo es correcto, se envía la información al controlador para que el 
 * computador quede guardado en la matriz.
 * 
 * @pre El controlador (schoolController) debe estar inicializado.
 * @post Si los datos son válidos, el computador se agrega correctamente.
 */

    public void registrarComputador() {
        boolean serialValido=false;
        String numeroSerial="";
        System.out.println("Elegiste la opcion de registrar un computador");
        while(!serialValido){
        input.nextLine();
        System.out.println("Agrega el Numero de Serial del dispositivo: ");
        numeroSerial=input.nextLine();
    
        if (schoolController.comprobacionRepeticion(numeroSerial)) {
        serialValido = true;
    } else {
        System.out.println("El número de serial ya existe, ingrese uno diferente.");
    }
    }
        System.out.println("Indica el piso donde se ubica el computador");
        int pisoUser=input.nextInt();
        if(pisoUser<0 || pisoUser>5){
            System.out.println("Piso invalido, no está dentro del rango");
            return;
        }
    

       String mensaje =  schoolController.agregarComputador(numeroSerial, pisoUser);
    System.out.println(mensaje);

    }

/**
 * Muestra todos los computadores registrados en el sistema, 
 * junto con su información básica (serial, piso, columna, e incidentes asociados).
 * 
 * Descripción: Este método no cambia nada del sistema, simplemente imprime los datos 
 * obtenidos del controlador. Si no hay computadores registrados, no se mostrará nada.
 * 
 * @pre El controlador debe estar inicializado.
 * @post No cambia el estado del sistema.
 */

    public void mostrarComputadores(){
        String [] listaComputadores = schoolController.mostrarComputadores();
        for (String computadorInfo : listaComputadores) {
            if(computadorInfo != null){
            System.out.print(computadorInfo);
        }
        }
    }

/**
 * Registra un nuevo incidente en un computador ya existente.
 * 
 * Descripción: Primero muestra la lista de computadores y pide al usuario que seleccione 
 * el número de serie donde ocurrió el problema. Luego solicita una descripción, 
 * la fecha del reporte y, si se desea, los datos de la solución (si se resolvió 
 * o no, y cuántas horas tomó o se invirtieron).
 * 
 * El incidente queda guardado dentro del computador correspondiente.
 * 
 * @pre Debe haber al menos un computador registrado para poder asociarle el incidente.
 * @post Si los datos son válidos, el incidente se agrega correctamente.
 */

    public void registrarIncidenteEnComputador() {
        System.out.println("Elegiste la opcion de registrar un incidente en un computador");

        mostrarComputadores();

        input.nextLine();
        System.out.println("Dime el numero de serial del computador donde deseas registrar el incidente:");
        String numeroSerial=input.nextLine();
        

        if(verificacionExistencia(numeroSerial)){
            System.out.println("El numero de serial no existe,Primero registra un computador. ");
            return;
        }
        System.out.println("Dime la descripcion del incidente:");
        String descripcion=input.nextLine();

        System.out.println("Ahora vamos a ver la fecha del reporte del incidente.");
        System.out.println("Dime el día: ");
        int dia=input.nextInt();
        System.out.println("Dime el mes: ");
        int mes=input.nextInt();
        System.out.println("Dime el anio: ");
        int anio=input.nextInt();
        LocalDate fechaReporte = LocalDate.of(anio, mes, dia);
        input.nextLine();

        System.out.println("¿Deseas agregar información sobre la solución del Incidente? (Si/No): ");
        String decision=input.nextLine();

        if(decision.equalsIgnoreCase("si")){
            System.out.println("¿El incidente ya fue solucionado? (si/no):");
            String respuesta = input.nextLine();
            boolean solucion = respuesta.equalsIgnoreCase("si");

            
            System.out.println("Ahora dime en horas el tiempo que se invirtió en solución o tratando de solucionar el inicidente que se transcurrieron");
            int horasSolucion=input.nextInt();
            input.nextLine();

            if(horasSolucion>0 && horasSolucion<=100){
                System.out.println("Horas de solución aceptadas");

            }else{
                System.out.println("El número de horas no esta en el rango, ingrésalo de nuevo");
                return;
            }
            String mensaje = schoolController.agregarIncidenteEnComputadorCompleto(numeroSerial ,fechaReporte, descripcion, solucion, horasSolucion);
            System.out.println(mensaje);
            
            }else{ 
            String mensaje = schoolController.agregarIncidenteEnComputador(numeroSerial,  fechaReporte, descripcion);
            System.out.println(mensaje);
        }

        }

/**
 * Consulta cuál es el computador con mayor cantidad de incidentes registrados.
 * 
 * Descripción: El método recorre todos los computadores y compara la cantidad de incidentes
 * que tiene cada uno. Si hay varios con la misma cantidad máxima, informa que 
 * existe un empate. También maneja los casos donde no hay computadores o donde 
 * ninguno tiene incidentes.
 * 
 * @pre Debe existir al menos el controlador inicializado.
 * @post No modifica el estado del sistema.
 */

    public void consultarComputadorConMasIncidentes() {
        String mensaje = schoolController.consultarComputadorConMasIncidentes();
        System.out.println(mensaje);
    }

}
