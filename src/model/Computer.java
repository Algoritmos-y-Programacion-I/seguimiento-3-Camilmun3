package model;

import java.util.ArrayList;
import java.time.LocalDate;

public class Computer {

    private String numeroSerial;
    private boolean ventanaSiguiente;
    ArrayList<Incident> incidentes = new ArrayList<Incident>();

    public Computer(String numeroSerial, boolean ventanaSiguiente) {
        this.numeroSerial = numeroSerial;
        this.ventanaSiguiente = ventanaSiguiente;
        incidentes = new ArrayList<Incident>();
    }

    public String getNumeroSerial() {
        return numeroSerial;
    }
    public void setNumeroSerial(String numeroSerial) {
        this.numeroSerial = numeroSerial;
    }
    public boolean isVentanaSiguiente() {
        return ventanaSiguiente;
    }
    public void setVentanaSiguiente(boolean ventanaSiguiente) {
        this.ventanaSiguiente = ventanaSiguiente;
    }
    public ArrayList<Incident> getIncidentes() {
        return incidentes;
    }
    public void setIncidentes(ArrayList<Incident> incidentes) {
        this.incidentes = incidentes;
    }
 
/**
 * Agrega un nuevo incidente sencillo al computador.
 * 
 * Descripción: Este método se usa cuando solo se conoce la fecha y una descripción del problema.
 * Crea un objeto con esos datos y lo guarda dentro de la lista de incidentes
 * del computador correspondiente.
 * 
 * @param fechaReporte Fecha en la que se reportó el problema.
 * @param descripcion Descripción breve o detallada del incidente.
 * @pre La fecha y la descripción deben ser válidas (no nulas ni vacías).
 * @post Se agrega un nuevo incidente a la lista. 
 *       El número total de incidentes aumenta en 1.
 */

    public void agregarIncidente(LocalDate fechaReporte, String descripcion) {
        Incident nuevoIncidente = new Incident(fechaReporte, descripcion);
        incidentes.add(nuevoIncidente);

    }

/**
 * Agrega un nuevo incidente al computador con toda la información disponible.
 * 
 * Descripción: Este método se usa cuando además de la descripción y la fecha, 
 * también se conoce si el incidente ya fue solucionado y cuánto tiempo 
 * tomó atenderlo. Crea un objeto con esos datos y lo 
 * agrega a la lista del computador.
 * 
 * @param fechaReporte Fecha del reporte del incidente.
 * @param descripcion Descripción del problema detectado.
 * @param solucion true si el incidente ya fue solucionado, false en caso contrario.
 * @param horasSolucion Número de horas dedicadas a resolver el problema (debe ser >= 0).
 * @pre La fecha y la descripción deben ser válidas. 
 *      Las horas deben ser mayores o iguales a cero.
 * @post El nuevo incidente queda almacenado en la lista del computador.
 */

    public void agregarIncidenteCompleto(LocalDate fechaReporte, String descripcion,boolean solucion, int horasSolucion) {
        Incident nuevoIncidenteCompleto = new Incident(fechaReporte, descripcion,solucion,horasSolucion);
        incidentes.add(nuevoIncidenteCompleto);

    }

/**
 * Genera una representación en texto del computador.
 * 
 * @pre true (no hay precondiciones)
 * @post El estado del objeto no cambia
 * @return String con el formato "Computer [numeroSerial: X incidentes=[...]]"
 */
    public String toString() {
        return "Computer [numeroSerial: " + numeroSerial + " incidentes="
                + incidentes + "]";
    }

}
