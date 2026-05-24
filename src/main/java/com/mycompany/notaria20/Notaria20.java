/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.notaria20;


import com.mycompany.notaria20.estructuras.Lista;
import com.mycompany.notaria20.estructuras.Pila;
import com.mycompany.notaria20.estructuras.Cola;
import com.mycompany.notaria20.negocio.TramiteNotarial;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class Notaria20 {

    public static void main(String[] args) {     
        
        Lista listaGeneral = new Lista();
        Cola colaPendientes = new Cola();
        Pila historialProcesados = new Pila();
        
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        
        
        do {
             System.out.println("\n========================================");
            System.out.println("    SISTEMA DE GESTIÓN - NOTARÍA 20     ");
            System.out.println("========================================");
            System.out.println("1. Registrar trámite");
            System.out.println("2. Ver todos los trámites registrados (Lista)");
            System.out.println("3. Ver trámites pendientes (Cola)");
            System.out.println("4. Procesar siguiente trámite");
            System.out.println("5. Ver historial de trámites procesados (Pila)");
            System.out.println("6. Buscar trámite por número");
            System.out.println("7. Cancelar trámite pendiente");
            System.out.println("8. Deshacer último procesamiento");
            System.out.println("9. Ver cantidad de elementos en el sistema");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción (1-10): ");
            
            
            
            try{
                opcion = Integer.parseInt(leer.nextLine());
                
                switch(opcion){
                    case 1:
                       System.out.print("Ingrese el numero de su  tramite:");
                       String num = leer.nextLine();
                       System.out.print("Ingrese el tipo de trámite ( Escritura, Autenticación):");
                       String tipo = leer.nextLine();
                       System.out.print("Ingrese el nombre del cliente:");
                       String cliente = leer.nextLine();
                       
                       
                       
                       TramiteNotarial nuevoTramite = new TramiteNotarial(num , tipo, cliente,"pendiente");
                        listaGeneral.agregar(nuevoTramite);
                        colaPendientes.encolar(nuevoTramite);
                        System.out.println("¡ su Trámite registrado con éxito!");
                        break;
                    case 2: 
                        System.out.println("\n--- REGISTRO HISTÓRICO GENERAL (LISTA) ");
                        listaGeneral.mostrarAdelante();
                        break;
                        
                        
                    case 3:    
                         System.out.println("\n--- TRÁMITES EN ESPERA DE ATENCIÓN (COLA) ");
                        colaPendientes.mostrar();
                        break;

                        
                    case 4:
                         if (colaPendientes.esVacia()) {
                            System.out.println("No hay trámites pendientes por procesar.");
                        } else {
                           
                            TramiteNotarial procesado = (TramiteNotarial) colaPendientes.desencolar();
                            procesado.setEstado("Procesado");
                            historialProcesados.apilar(procesado);
                            System.out.println("Se procesó el trámite: " + procesado);
                        }
                        break;
                   
                         //ver historialde elementos procesados 
                    case 5:    
                         System.out.println("\n--- HISTORIAL DE TRÁMITES FINALIZADOS (PILA) ");
                        historialProcesados.mostrar();
                        break;
                        
                        
                        case 6: // Buscar elemento por el  código
                        System.out.print("Ingrese el número de trámite a buscar: ");
                        String buscarNum = leer.nextLine();
                        
                        TramiteNotarial temporalBusqueda = new TramiteNotarial(buscarNum, "", "", "");
                        int indice = listaGeneral.buscarDato(temporalBusqueda);
                        
                        if (indice != -1) {
                            TramiteNotarial encontrado = (TramiteNotarial) listaGeneral.buscarDato(indice);
                            System.out.println("Trámite encontrado en la posición " + (indice + 1) + ":");
                            System.out.println(encontrado);
                        } else {
                            System.out.println("El trámite con número '" + buscarNum + "' no existe.");
                        }
                        break;

                        
                    case 7: // Cancelar elemento pendiente 
                        if (colaPendientes.esVacia()) {
                            System.out.println("No hay trámites pendientes para cancelar.");
                            break;
                        }
                        System.out.print("Ingrese el número de trámite a cancelar: ");
                        String cancelarNum = leer.nextLine();
                        TramiteNotarial tempCancelar = new TramiteNotarial(cancelarNum, "", "", "");
                        
                        if (!colaPendientes.contiene(tempCancelar)) {
                            System.out.println("El trámite no se encuentra en la cola de pendientes.");
                            break;
                        }
                        
                        
                        Cola colaAuxiliar = new Cola();
                        boolean eliminado = false;
                        
                        while (!colaPendientes.esVacia()) {
                            TramiteNotarial actual = (TramiteNotarial) colaPendientes.desencolar();
                            if (actual.equals(tempCancelar)) {
                                actual.setEstado("Cancelado");
                                eliminado = true; // Lo saltamos para sacarlo del flujo
                            } else {
                                colaAuxiliar.encolar(actual);
                            }
                        }

                         while (!colaAuxiliar.esVacia()) {
                            colaPendientes.encolar(colaAuxiliar.desencolar());
                        }
                        
                        if (eliminado) {
                            System.out.println("El trámite N° " + cancelarNum + " fue cancelado y retirado.");
                        }
                        break;

                    case 8: // Deshacer último procesamiento
                        if (historialProcesados.esVacia()) {
                            System.out.println("No hay procesos en el historial para deshacer.");
                        } else {
                            // REGLA: Desapilar de la pila y volver a encolar en pendientes
                            TramiteNotarial ultimo = (TramiteNotarial) historialProcesados.desapilar();
                            ultimo.setEstado("Pendiente");
                            colaPendientes.encolar(ultimo);
                            System.out.println("Se deshizo el proceso. Regresó a pendientes: " + ultimo.getNumeroTramite());
                        }
                        break;
                        
                    case 9: // ver la cantidad de LOS  elementos
                        System.out.println("\nSTATUS DEL SISTEMA");
                        System.out.println("Total históricos registrados (Lista): " + listaGeneral.cuentaElementos());
                        System.out.println("Trámites en espera (Cola): " + colaPendientes.tamanio());
                        System.out.println("Trámites finalizados (Pila): " + historialProcesados.tamanio());
                        break;

                    case 10:
                        System.out.println("Saliendo del sistema de la Notaría 20.");
                        break;

                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                        

                        

                }
                
                
            }catch (NumberFormatException e ){
                System.out.println("Error:por favor,ingrese un numero que se valido .");
            }
            
        }while (opcion !=10);

    }      
      
}
