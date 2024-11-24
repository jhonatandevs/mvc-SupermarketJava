/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.ClienteRepository;
import modelo.Cliente;
import java.math.BigDecimal;
/**
 *
 * @author ASUS
 */
public class ClienteController {
    private ClienteRepository clientesListModel;
    public enum Cargo {
        VENDEDOR("Vendedor"),
        CARPINTERO("Carpintero"),
        VETERINARIO("Veterinario"),
        MEDICO("Medico"),
        MECANICO("Mecanico");
        
        private final String valor;
        
        Cargo(String valor) {
            this.valor = valor;
        }
        
        public String getValor() {
            return valor;
        }
    }
    private void validarCliente(Cliente cliente) throws IllegalArgumentException {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (cliente.getApellido() == null || cliente.getApellido().trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
        if (cliente.getCargo() == null || cliente.getCargo().trim().isEmpty()) {
            throw new IllegalArgumentException("El cargo no puede estar vacío");
        }
        if (cliente.getSueldo() == null) {
            throw new IllegalArgumentException("El sueldo debe ser mayor que cero");
        }
    }
    public ClienteController(ClienteRepository clienteListModel){
        this.clientesListModel = clienteListModel;
    }
    
    public void addCliente(Cliente cliente){  
        validarCliente(cliente);
        clientesListModel.addCliente();
    }
    
    public List<Cliente> getAllClientes() {
        return clientesListModel.getClienteList();
    }
    
    public List<Cliente> getClientesByCargo(String cargo) {
        List<Cliente> matchingClientes = new ArrayList<>();
        if(cargo.equals("Todos")){
            matchingClientes.addAll(clientesListModel.getClienteList());
        }
        else{
            for (Cliente cliente : clientesListModel.getClienteList()) {
                System.out.println("Cliente recorrido a buscar:  "+cliente.getCargo()+"  Comparando con"+cargo);
                if (cliente.getCargo().equals(cargo)) {
                    matchingClientes.add(cliente);
                }
            }
        }
        return matchingClientes;
    }
    public void addClientesInController() {
      String[] nombres = {"Juan", "María", "Pedro", "Ana", "Carlos"};
        String[] apellidos = {"García", "Rodríguez", "López", "Martínez", "González"};
        BigDecimal sueldoBase = new BigDecimal("1500000");
        clientesListModel.addCliente();
        /*for (int i = 0; i < nombres.length; i++) {
            Cliente cliente = new Cliente();
            cliente.setId(i);
            cliente.setNombre(nombres[i]);
            cliente.setApellido(apellidos[i]);

            // Asignar cargo usando el enum
            Cargo cargoAsignado = Cargo.values()[i % Cargo.values().length];
            cliente.setCargo(cargoAsignado.getValor());

            // Calcular sueldo con una pequeña variación
            BigDecimal variacion = new BigDecimal(String.valueOf(1 + (Math.random() * 0.2 - 0.1)));
            BigDecimal sueldoFinal = sueldoBase.multiply(variacion);
            cliente.setSueldo(sueldoFinal.setScale(0, BigDecimal.ROUND_HALF_UP).toString());

            try {
                validarCliente(cliente);
                clientesListModel.addCliente(cliente);
            } catch (IllegalArgumentException e) {
                System.err.println("Error al crear cliente de prueba: " + e.getMessage());
            }
        }
        */
    }
    
}
