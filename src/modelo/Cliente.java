/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Cliente {

    private Integer id;
    private String nombre;
    private String apellido;
    private BigDecimal sueldo;
    private String cargo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (nombre.length() < 2 || nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre debe tener entre 2 y 50 caracteres");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede ser nulo o vacío");
        }
        if (apellido.length() < 2 || apellido.length() > 50) {
            throw new IllegalArgumentException("El apellido debe tener entre 2 y 50 caracteres");
        }
        this.apellido = apellido.trim();
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        if (sueldo == null || sueldo.trim().isEmpty()) {
            throw new IllegalArgumentException("El sueldo no puede ser nulo o vacío");
        }
        try {
            BigDecimal sueldoDecimal = new BigDecimal(sueldo.trim());
            if (sueldoDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("El sueldo debe ser mayor que cero");
            }
            this.sueldo = sueldoDecimal;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El sueldo debe ser un número válido");
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("El cargo no puede ser nulo o vacío");
        }
        if (cargo.length() < 2 || cargo.length() > 50) {
            throw new IllegalArgumentException("El cargo debe tener entre 2 y 50 caracteres");
        }
        this.cargo = cargo.trim();
    }
}
