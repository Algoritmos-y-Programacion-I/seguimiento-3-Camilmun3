package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class SchoolController {

   private String nombre;
   private int horasApoyoGastadas;
   int pisos=5;
   int columnas=10;
   int soporteMaximoHoras=100;
   private Computer[][] computadores = new Computer[pisos][columnas];

    public SchoolController(String nombre, int horasApoyoGastadas) {
        this.nombre = "Escuela Computaricemos" ;
        this.horasApoyoGastadas = 0;

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

/**
 * Revisa si un número de serie ya está registrado en alguno de los computadores.
 * 
 * Descripción: Este método recorre toda la matriz de computadores buscando coincidencias 
 * con el número de serie que se pasa por parámetro. Sirve para evitar que se 
 * registren dos computadores con el mismo identificador.
 * 
 * @param numeroSerial Número de serie que se quiere verificar.
 * @pre El número de serie no debe ser nulo ni vacío.
 * @post No se modifica nada del sistema, solo se consulta.
 * @return true si el número de serie NO existe (es único y se puede usar);
 *         false si ya hay un computador con ese mismo número.
 */

    public boolean comprobacionRepeticion(String numeroSerial) {
        for (int i = 0; i < pisos; i++) { 
            for (int j = 0; j < columnas; j++) { 
                Computer c = computadores[i][j]; 
                if (c != null && c.getNumeroSerial() != null && c.getNumeroSerial().equals(numeroSerial)) { 
                    return false; } } } return true;
    }

/**
 * Agrega un nuevo computador en el piso que indique el usuario.
 * 
 * Descripción: El método valida primero que el número de serie no esté repetido.
 * Luego busca la primera columna vacía en el piso seleccionado y allí
 * guarda el nuevo computador.
 * 
 * Si el piso está lleno o el número de serie ya existe, informa al usuario 
 * mediante un mensaje descriptivo.
 * 
 * @param numeroSerial El número de serie del nuevo computador.
 * @param pisoUser El número del piso donde se ubicará (0 a 4).
 * @pre El número de serie no debe ser nulo y el piso debe estar en el rango válido.
 * @post Si todo es correcto, el computador queda almacenado en la matriz.
 * @return Mensaje indicando si se pudo agregar o por qué no fue posible.
 */

    public String agregarComputador(String numeroSerial, int pisoUser) {
        if (!comprobacionRepeticion(numeroSerial)) {
        return "El número serial ya está registrado. No se agregó el computador.";
    }
        for (int col = 0; col < columnas; col++) {
        if (computadores[pisoUser][col] == null) {
            computadores[pisoUser][col] = new Computer(numeroSerial, false);
            return "Computador agregado exitosamente en el piso " + pisoUser + ", columna " + col + ".";
        }
    }

    return "No hay espacio disponible en el piso " + pisoUser + ".";
}
    
    
/**
 * Registra un incidente básico (sin detalles de solución) en un computador existente.
 * 
 * Descripción: El método busca el computador por su número de serie y, si lo encuentra,
 * crea un nuevo incidente con la fecha y descripción proporcionadas. 
 * Si el computador no existe, devuelve un mensaje informando la situación.
 * 
 * @param serial Número de serie del computador donde ocurrió el incidente.
 * @param fechaReporte Fecha del reporte del incidente.
 * @param descripcion Descripción breve del problema presentado.
 * @pre El serial, la fecha y la descripción deben ser válidos y no nulos.
 * @post Si se encuentra el computador, el incidente se agrega a su lista de incidentes.
 * @return Mensaje indicando si el incidente se registró correctamente o no.
 */

    public String agregarIncidenteEnComputador(String serial, LocalDate fechaReporte, String descripcion) {
        for (int piso = 0 ; piso < pisos; piso++) {
            for (int col = 0; col < columnas; col++) {
            if (computadores[piso][col] != null) {
                Computer c = computadores[piso][col];
                if (c.getNumeroSerial().equals(serial)) {
                    c.agregarIncidente(fechaReporte, descripcion);
                    return "Incidente registrado correctamente en el computador "+ serial;
                } 
            }
            
        
        }
    }return "No se encontró un computador con ese número de serie. ";
}

/**
 * Registra un incidente completo en un computador, incluyendo información
 * sobre la solución y las horas dedicadas a resolver el problema.
 * 
 * Descripción: Antes de agregar el incidente, el método verifica que las horas totales
 * de apoyo no superen el límite máximo permitido (100 horas). 
 * Si se puede registrar, las horas se suman al total y el incidente se guarda.</p>
 * 
 * También controla si el registro provoca que se alcance el límite de horas 
 * disponibles, notificando al usuario cuando esto ocurra.
 * 
 * @param numeroSerial Número de serie del computador.
 * @param fechaReporte Fecha en que se reportó el incidente.
 * @param descripcion Descripción del problema.
 * @param solucion true si el incidente fue solucionado, false si aún no.
 * @param horasSolucion Cantidad de horas invertidas en la atención del incidente.
 * @pre Todos los parámetros deben ser válidos y las horas deben ser mayores o iguales a cero.
 * @post Si no se supera el máximo de horas, el incidente se registra y las horas se acumulan.
 * @return Mensaje informando si el incidente se agregó, si se alcanzó el límite 
 *         o si no se pudo registrar por exceder las horas disponibles.
 */

    public String agregarIncidenteEnComputadorCompleto(String numeroSerial, LocalDate fechaReporte, String descripcion,boolean solucion,int horasSolucion) {

        if (horasApoyoGastadas + horasSolucion > soporteMaximoHoras) {
        return "No se puede registrar el incidente: se superan las " + soporteMaximoHoras + " horas de apoyo.";
    }
        for (int piso = 0 ; piso < pisos; piso++) {
            for (int col = 0; col < columnas; col++) {
            if (computadores[piso][col] != null) {
                Computer c = computadores[piso][col];
                if (c.getNumeroSerial().equals(numeroSerial)) {
                    c.agregarIncidenteCompleto(fechaReporte, descripcion, solucion, horasSolucion);


                horasApoyoGastadas+=horasSolucion;

                if(horasApoyoGastadas>=soporteMaximoHoras){
                    return "Incidente registrado, pero se alcanzó el límite de soporte "+soporteMaximoHoras+" horas";
                }
                    return "Incidente registrado correctamente en el computador "+ numeroSerial +" horas acumuladas "+ horasApoyoGastadas+ " Con un maximo de " + soporteMaximoHoras;
                }
            }


            }
        } return "No se encontró un computador con ese número de serie. ";



    }

/**
 * Devuelve la lista de computadores registrados en el sistema con su información básica.
 * 
 * Descripción: El método genera un arreglo de Strings donde cada posición corresponde
 * a un computador existente. Incluye su número de serie, la ubicación (piso y columna)
 * y sus incidentes registrados.
 * 
 * @pre No requiere condiciones especiales.
 * @post No altera el estado del sistema.
 * @return Un arreglo de Strings, cada uno con la información de un computador,
 *         o posiciones nulas donde no hay computadores.
 */

    public String[] mostrarComputadores(){
        String[] listaComputadores = new String[pisos * columnas];
        for (int i = 0; i < pisos; i++) {
            for (int j = 0; j < columnas; j++) {
                Computer c = computadores[i][j];
                if (c != null) {
                    listaComputadores[i * columnas + j] = c.toString() + " piso: " + (1+i)+ " " + "columna: " + (j+1)+  "\n" ;
                }
            }
        }
        return listaComputadores;

    }

    public void getComputerList(ArrayList<Computer> computadores) {

    }

/**
 * Identifica el computador con mayor cantidad de incidentes en el sistema.
 * 
 * Descripción: El método recorre toda la matriz de computadores, comparando la cantidad
 * de incidentes que tiene cada uno. Si hay un solo computador con la cantidad 
 * más alta, lo reporta junto con su ubicación. Si varios tienen la misma cantidad,
 * indica que hay un empate.
 * 
 * También maneja los casos donde no hay computadores registrados o donde 
 * ninguno tiene incidentes.
 * 
 * @pre No hay condiciones previas necesarias.
 * @post No modifica el estado del sistema, solo realiza una consulta.
 * @return Un mensaje indicando cuál es el computador con más incidentes,
 *         si hay empate o si no hay datos suficientes para determinarlo.
 */
 
    public String consultarComputadorConMasIncidentes() {
    Computer computadorMasIncidentes = null;
    int maxIncidentes = 0;
    int pisoMas = -1;
    int colMas = -1;
    boolean empate = false;
    boolean hayComputadores = false;

    for (int i = 0; i < pisos; i++) {
        for (int j = 0; j < columnas; j++) {
            Computer actual = computadores[i][j];
            if (actual != null) {
                hayComputadores = true;
                int cantidad = actual.getIncidentes().size();

                if (cantidad > maxIncidentes) {
                    maxIncidentes = cantidad;
                    computadorMasIncidentes = actual;
                    pisoMas = i;
                    colMas = j;
                    empate = false; 

                } else if (cantidad == maxIncidentes && cantidad != 0) {
                    empate = true; 
                }
            }
        }
    }

    if (!hayComputadores) {
        return "No hay computadores registrados.";
    }
    if (maxIncidentes == 0) {
        return "No hay incidentes registrados aún.";
    }

    if (empate) {
        return "Hay varios computadores con la misma cantidad máxima de incidentes (" 
                + maxIncidentes + " incidentes cada uno).";
    }

    return "El computador con más incidentes es " 
            + computadorMasIncidentes.getNumeroSerial() 
            + " (piso " + (pisoMas + 1) + ", columna " + (colMas + 1) + ") con " 
            + maxIncidentes + " incidentes.";
}




}

