/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notaria20.negocio;

/**
 *
 * @author carlo
 */
public class TramiteNotarial {
    private String numeroTramite;
    private String tipoTramite;
    private String nombreCliente;
    private String estado;
    
    
    
    public TramiteNotarial(String numeroTramite, String tipoTramite,String nombreCliente, String estado){
        this.numeroTramite = numeroTramite;
        this.nombreCliente = nombreCliente;
        this.estado = estado;
    }
    public String getNumeroTramite(){return numeroTramite;}
    public void setNumeroTramite(String numeroTramite){this.numeroTramite = numeroTramite;}
    
    public String getTipoTramite(){ return tipoTramite;}
    public void setTipoTramite(String tipoTramite) {this.tipoTramite = tipoTramite;}
    
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    
    public String toString(){
        return "Trámite N°: " + numeroTramite + " | Tipo: " + tipoTramite + " | Cliente: " + nombreCliente + " | Estado: " + estado;
    }
    
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        TramiteNotarial other = (TramiteNotarial) obj;
        return this.numeroTramite != null&& this.numeroTramite.equals(other.numeroTramite);
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
