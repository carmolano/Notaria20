/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notaria20.estructuras;

/**
 *
 * @author carlo
 */
public class Pila {
    
    private Nodo cima;
    private int tam;
    
    
    public Pila(){
        this.cima = null;
        this.tam = 0;
        
    }
    
    public void apilar(Object dato){
        Nodo nuevo = new Nodo(dato);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        tam++;
        
        
    }
    
    public Object desapilar(){
        if (esVacia()) return null;
        Object dato = cima.getDato();
        cima = cima.getSiguiente();
        tam--;
        return dato;
    }

     public Object peek(){
         if (esVacia()) return null;
         return cima.getDato();
     }
     
     public int tamanio(){
         return tam;
     }
     public  boolean esVacia(){
         return cima == null;
         
     }
      public boolean contiene (Object dato){
          return buscar(dato) != -1;
      }

      public void limpiar(){
          this.cima = null;
          this.tam = 0;
      }
      
      public int buscar(Object dato) {
        Nodo actual = cima;
        int index = 0;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return index;
            }
            actual = actual.getSiguiente();
            index++;
        }
        return -1;
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("El historial  está vacío.");
            return;
        }
        Nodo actual = cima;
        while (actual != null) {
            System.out.println("[trasmitiendo y procesando] -> " + actual.getDato().toString());
            actual = actual.getSiguiente();
      
        }
    
    }
    
}
