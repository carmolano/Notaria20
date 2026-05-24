/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notaria20.estructuras;

/**
 *
 * @author carlo
 */
public class Lista {
    private Nodo cabeza;
    
    public Lista(){
        this.cabeza = null;
    }
    
    public void agregar(Object dato){
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente()!= null){
                actual = actual.getSiguiente();
                
            }
            actual.setSiguiente(nuevo);
            
        }
    }
    
    public void agregarAlInicio(Object dato){
        Nodo nuevo = new Nodo(dato);
        nuevo.setSiguiente(cabeza);
        cabeza = nuevo;
    }
    
    
    public void agregarEnPosicion(int indice,Object dato){
        if (indice < 0 || indice > cuentaElementos()) return;
        if (indice == 0) {
            agregarAlInicio(dato);
            return;
        }
        Nodo nuevo = new Nodo(dato);
        Nodo actual = cabeza;
        for (int i = 0; i < indice - 1; i++) {
            actual = actual.getSiguiente();
        }
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
        
        }
         
         public Object eliminarPrimero(){
             if(cabeza == null) return null;
             Object dato = cabeza.getDato();
             cabeza = cabeza.getSiguiente();
             return dato;
         }
         
         public Object eliminarUltimo(){
             if (cabeza == null) return null;
        if (cabeza.getSiguiente() == null) {
            Object dato = cabeza.getDato();
            cabeza = null;
            return dato;
        }
        Nodo actual = cabeza;
        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        Object dato = actual.getSiguiente().getDato();
        actual.setSiguiente(null);
        return dato;
             
        }
         public Object eliminarEnPosicion(int indice){
             if (indice < 0|| indice >= cuentaElementos()) return null;
             if (indice == 0) return eliminarPrimero();
             
             Nodo actual = cabeza ;
             for(int i = 0; i < indice - 1; i++){
             actual = actual.getSiguiente();
             
         }
             
             Object dato = actual.getSiguiente().getDato();
             actual.setSiguiente(actual.getSiguiente().getSiguiente());
             return dato;
         }
         public Object buscarDato(int indice){
             if (indice < 0 || indice >= cuentaElementos()) return null;
             Nodo actual = cabeza;
             for(int i = 0 ; i < indice ; i++){
                 actual = actual.getSiguiente();
             }
             return actual.getDato();
         }
         
         
         public int buscarDato(Object dato){
             Nodo  actual = cabeza;
             int indice =0;
             while (actual != null) {
            if (actual.getDato().equals(dato)) return indice;
            actual = actual.getSiguiente();
            indice++;
        }
        return -1;
        }

          public boolean contiene(Object dato) {
              return buscarDato(dato) != -1;
        }

         public int cuentaElementos() {
         int contador = 0;
         Nodo actual = cabeza;
         while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
         }
        return contador;
         }

         public void limpiar() {
           this.cabeza = null;
        }
 
         public void mostrarAdelante() {
           if (cabeza == null) {
            System.out.println("La lista general está vacía.");
            return;
           }
            Nodo actual = cabeza;
           while (actual != null) {
            System.out.println(actual.getDato().toString());
            actual = actual.getSiguiente();
           }
       }   
 
           public void mostrarAtras() {
              if (cabeza == null) {
                System.out.println("La lista general está vacía.");
               return;
            }
          recursivoMostrarAtras(cabeza);
         } 

             private void recursivoMostrarAtras(Nodo nodo) {
              if (nodo == null) return;
               recursivoMostrarAtras(nodo.getSiguiente());
               System.out.println(nodo.getDato().toString());
             
     
             }
         }
