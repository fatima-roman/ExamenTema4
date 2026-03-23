package examen;

public class Empleado {
	
	private String dni; 
	private String nombre; 
	private double salarioBase; 
	private double porcentajeBonificacion; 
	private static double precioHoraExtra = 5.0; 
	private int horasExtrasRealizadas;
	
	
	public Empleado(String dni, String nombre, double salarioBase, double porcentajeBonificacion) {
		setDni(dni);
		setNombre(nombre);
		setPorcentajeBonificacion(porcentajeBonificacion);
		setSalarioBase(salarioBase);
		this.horasExtrasRealizadas = 0;
	}
	
	//============================
	//		GETTERS Y SETTERS 
	//============================
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni=dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null || nombre == "") {
			System.out.println("Nombre mal introducido");
			return; 
		}
		this.nombre = nombre;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		if (salarioBase < 0) {
			System.out.println("Salario base en negativo ");
		}else {
			this.salarioBase = salarioBase;
		}
	}
	public double getPorcentajeBonificacion() {
		return porcentajeBonificacion;
	}
	public void setPorcentajeBonificacion(double porcentajeBonificacion) {
		this.porcentajeBonificacion = porcentajeBonificacion;
	}
	public double getPrecioHoraExtra() {
		return precioHoraExtra;
	}
	public static boolean setPrecioHoraExtra(double precioHoraExtras) {
		if (precioHoraExtra < 0) {
			System.out.println("Precio horas extra en negativo ");
			return false;
		}else {
			precioHoraExtra = precioHoraExtras;
			return true; 
		}
	}
	public int getHorasExtrasRealizadas() {
		return horasExtrasRealizadas;
	}
	public void setHorasExtrasRealizadas(int horasExtrasRealizadas) {
		if (horasExtrasRealizadas < 0) {
			System.out.println("Horas extra en negativo ");
		}else {
			this.horasExtrasRealizadas = horasExtrasRealizadas;
		}
	} 
	
	//==========================
	//			METODOS
	//==========================
	
	/**
	 * Calcula el total de las horas extra junto sus metodos
	 */
	private double calculoHorasExtra;
	public double getCalculoHorasExtra() {
		return calculoHorasExtra;
	}
	public void setCalculoHorasExtra() {
		this.calculoHorasExtra = horasExtrasRealizadas * precioHoraExtra;
	}
	
	
	/**
	 * Método que devuelve salario base+bonificación+complemento horas extra
	 * 
	 */
	private double salarioTotal;
	public double getSalarioTotal() {
		return salarioTotal;
	}
	public void setSalarioTotal() {
		this.salarioTotal = salarioBase + ((porcentajeBonificacion * salarioBase)/100) + calculoHorasExtra;
	}


	/**
	 * Calculo bonificación 
	 */
	private double calculoBonificacion;
	public double getCalculoBonificacion() {
		return calculoBonificacion;
	}
	public void setCalculoBonificacion() {
		this.calculoBonificacion = (porcentajeBonificacion * salarioBase)/100;
	}
	
	
	/**
	 * Método que al imprimir el objeto muestre con formato personalizado
	 */
    @Override
	public String toString() {
		return dni + " - " + nombre + "\n"
				+ "Salario Base: " + salarioBase
				+ " | Bonificación: " + calculoBonificacion + " ("+ porcentajeBonificacion+"%) \n"
				+ "Horas Extra: " + horasExtrasRealizadas + " | Total Bruto: " + salarioTotal;
	}
	
	
	/**
	 * Comprueba si dos empleados tienen el mismo dni 
	 */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (!(obj instanceof Empleado)) return false;
        Empleado o = (Empleado) obj;
        return dni.equals(o.dni); 
    }
    

	/**
     * Basado solo en dni ya que no se repiten 
     */
    @Override
    public int hashCode() {
    	return dni != null ? dni.hashCode() : 0; 
    }

}
