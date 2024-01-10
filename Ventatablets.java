package tablets;

import java.util.Scanner;

public class Ventatablets {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		boolean tablet=false;
		boolean cliente=false;
		int opcion;
		final int FILAS= 100;
		final int COLUMNAS= 10;
		String tablets [][] = new String [FILAS][COLUMNAS];
		String clientes [][] = new String [FILAS][COLUMNAS];
		String serie;
		String cif;
		int indiceCliente = -1;
		
		do {
		System.out.println("Menu de opciones");
		System.out.println("1: Dar de alta una tablet");
		System.out.println("2: Dar de alta un cliente");
		System.out.println("3: Vender una tablet");
		System.out.println("4: Mostrar tablets disponibles");
		System.out.println("5: Mostrar tablets vendidas a un cliente");
		System.out.println("6: Salir");
		opcion=sc.nextInt();
		switch(opcion) {
			case 1: System.out.println("Cual es el numero de serie de la tablet?");
					serie=sc.next();
					for (int filas=0;filas<FILAS;filas++) {
						if (tablets[filas][0]!=null && tablets[filas][0].equals(serie)) {
							System.out.println("Esta tablet ya existe en este registro.");
							tablet=true;
							break;
						}
					}	
					if(!tablet) {
						for (int filas=0;filas<FILAS;filas++) {
							if (tablets[filas][0]==null) {
								tablets[filas][0]=serie;
								System.out.println("Cual es la marca de la tablet?");
								tablets[filas][1]=sc.next();
								System.out.println("Cual es el modelo de la tablet");
								tablets[filas][2]=sc.next();
								System.out.println("Cual es la capacidad de la tablet?");
								tablets[filas][3]=sc.next();
								System.out.println("Cual es la RAM de la tablet?");
								tablets[filas][4]=sc.next();
								System.out.println("Cual es el precio de venta de la tablet?");
								tablets[filas][5]=sc.next();
								System.out.println("La tablet se ha dado de alta");
								break;
							}
						}
					}
					tablet=false;	
					break;
			case 2: System.out.println("Cual es el CIF del cliente?");
					cif=sc.next();
					for (int filas=0;filas<FILAS;filas++) {
						if (clientes[filas][0]!=null && clientes [filas][0].equals(cif)){
							System.out.println("Este cliente ya existe en este registro.");
							cliente=true;
							break;
						}
					}
					if(!cliente) {
						for (int filas=0;filas<FILAS;filas++) {
							if (clientes[filas][0]==null) {
								clientes[filas][0]=cif;
								System.out.println("Cual es el nombre del cliente?");
								clientes[filas][1]=sc.next();
								System.out.println("Cual es el apellido del cliente?");
								clientes[filas][2]=sc.next();
								System.out.println("cliente guardado correctamente");
								break;
							}
						}
					}
					cliente=false;
					break;
			case 3:
				System.out.println("Introduce el CIF del cliente que comprará la tablet:");
				cif = sc.next();
		    for (int filas = 0;filas<FILAS;filas++) {
		        if (clientes[filas][0]!=null&&clientes[filas][0].equals(cif)) {
		            indiceCliente=filas;
		            break;
		        }
		    }
		    
		    if (indiceCliente == -1) {
		        System.out.println("Cliente no encontrado. Registre al cliente antes de vender una tablet.");
		    } else {
		        System.out.println("Tablets disponibles para la venta:");
		        for (int filas=0;filas<FILAS;filas++) {
		            if (tablets[filas][0]!= null) {
		                System.out.println((filas + 1) + ". " + tablets[filas][1] + " " + tablets[filas][2]+", numero de serie: "+tablets[filas][0]);
		            }
		        }
		        
		        System.out.println("Seleccione la tablet a vender (1-" + FILAS + "):");
		        int opcionTabletVenta=sc.nextInt();
		        
		        if (opcionTabletVenta >= 1 && opcionTabletVenta <= FILAS) {
		            String tabletVendida = tablets[opcionTabletVenta - 1][1];
		            String marcaTabletVendida = tablets[opcionTabletVenta - 1][2];
		            String serietabletVendida=  tablets[opcionTabletVenta - 1][0];
		            clientes[indiceCliente][3] = tabletVendida;  
		            clientes[indiceCliente][4] = marcaTabletVendida;
		            clientes[indiceCliente][5] = serietabletVendida;
		            tablets[opcionTabletVenta - 1] = new String[COLUMNAS];
		            
		            System.out.println("Venta realizada. Tablet " + tabletVendida + " vendida a " + clientes[indiceCliente][1] + " " + clientes[indiceCliente][2]);
		        } else {
		            System.out.println("Opción no válida. Seleccione una opción válida.");
		        }
		    }
		    break;	
	
			case 4:  System.out.println("Tablets disponibles para la venta:");
	        	for (int filas=0;filas<FILAS;filas++) {
	            if (tablets[filas][0]!= null) {
	            	System.out.println((filas + 1) + ". " + tablets[filas][1] + " " + tablets[filas][2]+", Numero de serie: "+tablets[filas][0]);
	            }
	        }
						
		case 5:
		    System.out.println("Introduce el CIF del cliente para mostrar las tablets vendidas:");
		    cif = sc.next();
		    
		    indiceCliente=-1;
		    for (int filas=0;filas<FILAS;filas++) {
		        if (clientes[filas][0]!=null&&clientes[filas][0].equals(cif)) {
		            indiceCliente=filas;
		            break;
		        }
		    }
		    
		    if (indiceCliente==-1) {
		        System.out.println("Cliente no encontrado en el registro.");
		    } else {
		        System.out.println("Tablets vendidas a " + clientes[indiceCliente][1] + " " + clientes[indiceCliente][2] + " (CIF: " + cif + "):");
		        boolean tabletsVendidas=false;
		        
		        for (int filas = 0; filas < FILAS; filas++) {
		            if (clientes[filas][0] != null && clientes[filas][0].equals(cif) && clientes[filas][3] != null && clientes[filas][4] != null) {
		                System.out.println("   - " + clientes[filas][3] + " " + clientes[filas][4] + ", Numero de serie: " + clientes[filas][5]) ;
		                tabletsVendidas = true;
		            }
		        }
		        
		        if (!tabletsVendidas) {
		            System.out.println("No hay tablets vendidas a este cliente.");
		        }
		    }
		    break;	
		case 6:  System.out.println("Hasta luego");
		
		default: System.out.println("Por favor ingresa una opcion valida");
			
		}
		} while(opcion!=6);
	}
}
