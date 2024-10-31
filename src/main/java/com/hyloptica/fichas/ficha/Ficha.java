package com.hyloptica.fichas.ficha;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Column;

@Entity
@Table
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;
    private String apellido;
    private String telefono;
    private LocalDate fecha;
    private LocalDate fechaEntrega;

    private Double dioptrias;

    private String cristal;
    private String armazon;

    private Double precioTotal;
    private Double abonado;

    @Transient 
    private Double saldoPendiente;

    public Ficha() {};
    
    public Ficha(Long id, String nombre, String apellido, String telefono, LocalDate fecha,
            Double dioptrias, String cristal, String armazon, Double precioTotal, Double abonado)
         {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fecha = fecha;
        this.dioptrias = dioptrias;
        this.cristal = cristal;
        this.armazon = armazon;
        this.precioTotal = precioTotal;
        this.abonado = abonado;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public LocalDate getFecha() {
        return fecha;
    }


    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }


    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }


    public Double getDioptrias() {
        return dioptrias;
    }


    public void setDioptrias(Double dioptrias) {
        this.dioptrias = dioptrias;
    }


    public String getCristal() {
        return cristal;
    }


    public void setCristal(String cristal) {
        this.cristal = cristal;
    }


    public String getArmazon() {
        return armazon;
    }


    public void setArmazon(String armazon) {
        this.armazon = armazon;
    }


    public Double getPrecioTotal() {
        return precioTotal;
    }


    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }


    public Double getAbonado() {
        return abonado;
    }


    public void setAbonado(Double abonado) {
        this.abonado = abonado;
    }


    public Double getSaldoPendiente() {
        return this.getPrecioTotal() - this.getAbonado();
    }


    public void setSaldoPendiente(Double saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

}
