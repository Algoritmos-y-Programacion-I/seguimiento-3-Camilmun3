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
    
    public void addIncident(LocalDate fechaReporte, String descripcion) {
        Incident newIncident = new Incident(fechaReporte, descripcion);
        incidentes.add(newIncident);

    }

}
