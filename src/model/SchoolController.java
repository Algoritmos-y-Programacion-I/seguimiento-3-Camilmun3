package model;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Computer;

public class SchoolController {

   private String nombre;
   private int horasApoyoGastadas;
   int pisos=5;
   int columnas=10;
   int soporteMaximoHoras=100;
   private Computer[][] computadores = new Computer[pisos][columnas];

    public SchoolController(String nombre, int horasApoyoGastadas) {
        this.nombre = nombre;
        this.horasApoyoGastadas = horasApoyoGastadas;

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getHorasApoyoGastadas() {
        return horasApoyoGastadas;
    }
    public void setHorasApoyoGastadas(int horasApoyoGastadas) {
        this.horasApoyoGastadas = horasApoyoGastadas;
    }
    public Computer[][] getComputadores() {
        return computadores;
    }
    public void setComputadores(Computer[][] computadores) {
        this.computadores = computadores;
    }


    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Los siguientes metodos estan incompletos.
     * Añada los metodos que considere hagan falta para satisfacer los
     * requerimientos.
     * Para cada metodo:
     * Agregue los parametros y retorno que sean pertinentes.
     * Agregue la logica necesaria (instrucciones) para satisfacer los
     * requerimientos.
     */
    public void agregarComputador(String numeroSerial, int piso, int columna) {
       for(int i=0;i<pisos;i++){
           for(int j=0;j<columnas;j++){
               if(i==piso && j==columna){
                   Computer newComputer = new Computer(numeroSerial, false);
                   computadores[i][j]=newComputer;
               }
           }
       }

       if(computadores[piso][columna]!=null){
           System.out.println("Computador agregado exitosamente");
       } else {
           System.out.println("Error al agregar el computador");
       }
    }

    public void agregarIncidenteEnComputador(LocalDate fechaReporte, String descripcion) {

    }

    public void getComputerList(ArrayList<Computer> computadores) {

    }

}
