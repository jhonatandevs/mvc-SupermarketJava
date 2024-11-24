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
        VENDEDOR("VENDEDOR"),
        CARPINTERO("CARPINTERO"),
        VETERINARIO("VETERINARIO"),
        MEDICO("MEDICO"),
        MECANICO("MECANICO");

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

    public ClienteController(ClienteRepository clienteListModel) {
        this.clientesListModel = clienteListModel;
    }

    public void addCliente(Cliente cliente) {
        validarCliente(cliente);
        clientesListModel.addCliente();
    }

    public List<Cliente> getAllClientes() {
        return clientesListModel.getClienteList();
    }

    public List<Cliente> getClientesByCargo(String cargo) {
        List<Cliente> matchingClientes = new ArrayList<>();
        if (cargo.equals("TODOS")) {
            matchingClientes.addAll(clientesListModel.getClienteList());
        } else {
            for (Cliente cliente : clientesListModel.getClienteList()) {
                System.out.println("Cliente recorrido a buscar:  " + cliente.getCargo() + "  Comparando con" + cargo);
                if (cliente.getCargo().equals(cargo)) {
                    matchingClientes.add(cliente);
                }
            }
        }
        return matchingClientes;
    }

    public void addClientesInController() {
        clientesListModel.addCliente();
    }

}
