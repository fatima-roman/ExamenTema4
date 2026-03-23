package examen;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
    	
    	final String MENSAJE_MODIFICADO = "Modificado correctamente";

        int opc =0;
        try {
            do {
                System.out.println("1. Añadir vehículo\r\n"
                + "2. Listar empleados\r\n"
                + "3. Buscar empleado por DNI\r\n"
                + "4. Modificar horas extras\r\n"
                + "5. Modificar bonificación\r\n"
                + "6. Modificar precio hora extra\r\n"
                + "7. Eliminar empleado\r\n"
                + "8. Ver estadísticas\r\n"
                + "9. Salir\r\n");
                
                opc = ListaEmpleados.reader.nextInt();
                
                switch (opc) {
                case 1: {
                	try {
                        Empleado empleado = ListaEmpleados.pedirDatosEmpleado();
                        if (ListaEmpleados.añadirEmpleado(empleado)) System.out.println("Añadido correctamente");
                        break;
					} catch (InputMismatchException e) {
						System.out.println("Error en la entrada de datos. Posiblemente porcentaje recuerda usar ,");
					}

                }
                case 2 : {
                    ListaEmpleados.listarTodos();
                    break;
                }
                case 3: {
                    String dni = ListaEmpleados.pedirDni();
                    Empleado empleado = ListaEmpleados.buscarPorDni(dni);
                    if (empleado == null) {
                    	System.out.println("Empleado no encontrado");
                    	break;
                    }
                    System.out.println(empleado.toString());
                    break;
                }
                case 4: {
                    int horas = ListaEmpleados.pedirHoras();
                    String dni = ListaEmpleados.pedirDni();
                    if(ListaEmpleados.modificarHorasExtra(dni, horas)) {
                        System.out.println(MENSAJE_MODIFICADO);
                    }

                    break;
                }
                case 5: {
                    double porcentaje = ListaEmpleados.pedirPorcentaje();
                    String dni = ListaEmpleados.pedirDni();
                    if (ListaEmpleados.modificarBonificacion(dni, porcentaje)) {
                        System.out.println(MENSAJE_MODIFICADO);
                    }
                    break;
                }
                case 6: {
                    double precio = ListaEmpleados.pedirPrecio();
                    if(ListaEmpleados.modificarPrecioHorasExtra(precio)) System.out.println(MENSAJE_MODIFICADO);
                    break;
                }
                case 7: {
                    String dni = ListaEmpleados.pedirDni();
                    if (ListaEmpleados.eliminarPorDni(dni)) System.out.println("Eliminado correctamente");
                    break;
                }
                case 8: {
                    double sumaTotal = ListaEmpleados.calcularGastoBonificaciones();
                    System.out.println("Gasto en bonificaciones: " + sumaTotal);
                    System.out.println("Lista de empleados de alto desempeño");
                    ListaEmpleados.listarVehiculosPremium();
                    break;
                }
                case 9 : {
                	System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                	break;
                }
                }; 

            }while(opc !=9);

        }catch (NullPointerException e) {
			System.out.println("Encontrado valor nulo. Error: " + e);
		}catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
            System.out.println("Cerrando programa. Error: " + e );
        }finally {
			System.out.println("Programa cerrado correctamente.");
		}
    }

}
