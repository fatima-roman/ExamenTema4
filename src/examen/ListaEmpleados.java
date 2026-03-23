package examen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ListaEmpleados {
	
	/**
	 * Lista para almacinar empleados 
	 *  Key = DNI | Value = Empleado
	 */
    public static Map<String, Empleado> empleadosLista = new HashMap<>();
    public static Scanner reader = new Scanner(System.in);
    final static String MENSAJE_ERROR = "Empleado no encontrado";

    public static Empleado pedirDatosEmpleado() {
    	String dni = pedirDni();
        System.out.println("Introduce el nombre");
        String nombre = reader.next();
        System.out.println("Introduce Salario Base");
        double salarioBase = reader.nextDouble();
        double porcentajeBonifica = pedirPorcentaje();
        Empleado empleado = new Empleado(dni, nombre, salarioBase, porcentajeBonifica);
        
        empleado.setCalculoBonificacion();
        empleado.setCalculoHorasExtra();
        empleado.setSalarioTotal();
        
        return empleado; 
    }
    
    /**
     * Lee dni para no repetir el código 
     * @return dni con valor asignado 
     */
    public static String pedirDni() {
    	System.out.println("Introduce el dni");
    	String dni = reader.next();
    	return dni;
    }
    
    /**
     * Lee porcentaje bonificacion para no repetir el código 
     * @return porcentaje con valor asignado 
     */
    public static double pedirPorcentaje() {
    	System.out.println("Introduce el porcentaje de bonificación");
    	double porcenta = reader.nextDouble();
    	return porcenta;
    }
    
    /**
     * Lee las horas para no repetir el código 
     * @return horas con valor asignado 
     */
    public static int pedirHoras() {
    	System.out.println("Introduce las horas extra realizadas");
    	int horas = reader.nextInt();
    	return horas;
    }
    
    /**
     * Lee las pecio horas extra para no repetir el código 
     * @return precio con valor asignado 
     */
    public static double pedirPrecio() {
    	System.out.println("Introduce el precio hora extra");
    	double precio = reader.nextInt();
    	return precio;
    }
    
    

    /**
     * Añade al empleado en la lista de valores 
     * @param empleado objeto de empleado 
     * @return si se añade en lista
     */
    public static boolean añadirEmpleado(Empleado empleado) {
    	if (empleado == null || empleado.getDni() == null || empleadosLista.containsKey(empleado.getDni())) {
            System.out.println("No es posible añadir empleado, compruebe el dni");
            return false; 
        }
        empleadosLista.put(empleado.getDni(), empleado); 
        return true; 
    }
    
    /**
     * Lista los empleados en la colección 
     */
    public static void listarTodos() {
    	if( empleadosLista.values() == null ) {
    		System.out.println("No hay empleados en la lista");
    		return; 
    	}
    	for (Empleado empleado : (Iterable<Empleado>) empleadosLista.values()) {
            System.out.println(empleado.toString());
        }
    }
    
    /**
     * Buscar por dni introducido por teclado 
     * @param dni a buscar 
     * @return si lo encuentra devuelve empleado en caso contrario null
     */
    public static Empleado buscarPorDni(String dni) {
        if (!empleadosLista.containsKey(dni)) {
            System.out.println(MENSAJE_ERROR);
            return null; 
        }else {
            return (Empleado) empleadosLista.get(dni);
        }
    }

    /**
     * Modifica las horas extras realizadas 
     * @param dni de las horas extras a cambiar
     * @param horas extra a introducir 
     * @return boolean if true or false 
     */
    public static boolean modificarHorasExtra(String dni, int horas) {
        Empleado modificar = buscarPorDni(dni);
        if (modificar == null) {
            System.out.println(MENSAJE_ERROR);
            return false;
        }else {
        	modificar.setHorasExtrasRealizadas(horas);
            empleadosLista.replace(dni, modificar);
            return true; 
        }
    }
    
    /**
     * Mopdifica la bonificacion 
     * @param dni a cambiar 
     * @param porcentaje a cambiar 
     * @return true or false if action could be realized 
     */
    public static boolean modificarBonificacion(String dni, double porcentaje) {
        Empleado modificar = buscarPorDni(dni);
        if (modificar == null) {
            System.out.println(MENSAJE_ERROR);
            return false;
        }else {
            modificar.setPorcentajeBonificacion(porcentaje);
            empleadosLista.replace(dni, modificar);
            return true; 
        }
    }
    
    /**
     *  Modifica el parametro comun a todos precio horas extra 
     * @param precio el nuevo precio a introducir 
     * @return true or false if action could be realized 
     */
    public static boolean modificarPrecioHorasExtra (double precio) {
    	if (Empleado.setPrecioHoraExtra(precio)) {
    		return true; 
    	}else {
    		return false;
    	}
    }
    

    /**
     *  Elimina por id principal = dni 
     * @param dni key para eliminar 
     * @return true or false if action could be realized 
     */
    public static boolean eliminarPorDni(String dni) {
        Empleado eliminar = buscarPorDni(dni);
        if (eliminar == null) {
            System.out.println(MENSAJE_ERROR);
            return false;
        }else {
            empleadosLista.remove(dni, eliminar);
            return true; 
        }
    }
    
    /**
     * Retorna la suma total de bonificaciones
     * @return suma total de bonificaciones 
     */
    public static double calcularGastoBonificaciones() {
        double sumaTotal = 0; 
        for (Empleado v : (Iterable<Empleado>) empleadosLista.values()) {
            sumaTotal += v.getCalculoBonificacion();
        }
        return sumaTotal;
    }
    
    /**
     * Imprime empleados con bonificación > 15%
     */
    public static void listarVehiculosPremium() {
        for ( Empleado empleado : (Iterable<Empleado>) empleadosLista.values()) {
            if(empleado.getPorcentajeBonificacion() >= 15 ) {
                System.out.println(empleado.toString());
            }
        }
    }
}
