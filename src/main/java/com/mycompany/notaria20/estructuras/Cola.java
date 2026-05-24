/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notaria20.estructuras;

/**
 *
 * @author carlo
 */
public class Cola {
    private Nodo frente;
    private Nodo fin;
    private int tam;
    
    
    public Cola(){
        this.frente = null;
        this.fin = null;
        this.tam = 0;
    }
    
    public void encolar (Object dato){
            Nodo nuevo = new Nodo(dato);
            if(esVacia()){
                frente = nuevo;
            }else{
                fin.setSiguiente(nuevo);
            }
            fin = nuevo;
            tam++;
                 
            }
            
            public Object desencolar(){
                if(esVacia()) return null;
                Object dato = frente.getDato();
                frente = frente.getSiguiente();
                if (frente == null) {
                fin = null;
       
                }
                  tam--;
                  return dato;
                
                }
            
           
             public Object peek (){
               if (esVacia()) return null;
               return frente.getDato();
               
              }
             public  int tamanio(){
                 return tam;
             }
             public boolean esVacia() {
                  return frente == null;
             }

              public boolean contiene(Object dato) {
                 Nodo actual = frente;
                   while (actual != null) {
                  if (actual.getDato().equals(dato)) {
                return true;
              }
                actual = actual.getSiguiente();
               }
                  return false;
                  }

    public void limpiar() {
        this.frente = null;
        this.fin = null;
        this.tam = 0;
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("No hay trámites pendientes en la cola.");
            return;
        }
        Nodo actual = frente;
        int posicion = 1;
        while (actual != null) {
            System.out.println(posicion + ". " + actual.getDato().toString());
            actual = actual.getSiguiente();
            posicion++;
            
        }
    }
                 
                 
    
}
