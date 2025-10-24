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
    public boolean Solucion() {
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
}
