package model;

import java.time.LocalDate;

public class Incident {
  
    private LocalDate fechaReporte;
    private String descripcion;
    private boolean solucion;
    private int horasSolucion;

    public Incident(LocalDate fechaReporte, String descripcion) {
        this.fechaReporte = fechaReporte;
        this.descripcion = descripcion; 
    }
    public Incident(LocalDate fechaReporte, String descripcion, boolean solucion, int horasSolucion){
        this.fechaReporte= fechaReporte;
        this.descripcion=descripcion;
        this.solucion=solucion;
        this.horasSolucion=horasSolucion;
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }
    public void setFechaReporte(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public boolean solucion() {
        return solucion;
    }
    public void setSolucion(boolean solucion) {
        this.solucion = solucion;
    }
    public int getHorasSolucion() {
        return horasSolucion;
    }
    public void setHorasSolucion(int horasSolucion) {
        this.horasSolucion = horasSolucion;
    }

/** 
 *  Genera una representación en texto del incidente. * 
 *  @pre true (no hay precondiciones) * @post El estado del objeto no cambia 
 *  @return String con el formato "Descripción: X" donde X es la descripción del incidente 
 * */
    public String toString() {
    return "Descripción: " + descripcion;
    }
}
