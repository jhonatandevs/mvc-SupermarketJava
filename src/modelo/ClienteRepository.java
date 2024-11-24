/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.ClienteController.Cargo;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ASUS
 */
public class ClienteRepository {

    //Se agregan listas inmutables y encapsuladas, para favorecer la seguridad de los elemntos del repositorio
    private final List<Cliente> clienteList;
    private ConsumoAPI objectAPI = new ConsumoAPI();

    public ClienteRepository() {
        clienteList = new ArrayList<>();
        this.getRequestAllClients();
    }

    // Lista inmutable para separar el modelo y que sea solo consulta
    public List<Cliente> getClienteList() {
        return Collections.unmodifiableList(clienteList);
    }

    public void addCliente() {
        
        /*Objects.requireNonNull(cliente, "El cliente no puede ser nulo");
        validateCliente(cliente);
        clienteList.add(cliente);*/
    }

    public void getRequestAllClients() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Ocurrió un error: " + responseCode);
            } else {
                // Leer la respuesta JSON desde la conexión
                Scanner scanner = new Scanner(conn.getInputStream());
                StringBuilder jsonString = new StringBuilder();
                while (scanner.hasNext()) {
                    jsonString.append(scanner.nextLine());
                }
                scanner.close();

                // Parsear el JSON con org.json
                JSONArray jsonArray = new JSONArray(jsonString.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    Integer id = jsonObject.getInt("id");
                    String nombre = jsonObject.getString("name");
                    String apellido = jsonObject.getString("username");
                    String cargo = jsonObject.getString("email");
                    BigDecimal sueldo = new BigDecimal("1000.00"); // Sueldo por defecto

                    // Crear y agregar cliente
                    Cliente cliente = new Cliente();
                    cliente.setId(id);
                    cliente.setNombre(nombre);
                    cliente.setApellido(apellido);
                    Cargo cargoAleatorio = getRandomCargo();
                    cliente.setCargo(cargoAleatorio.toString());
                    cliente.setSueldo(sueldo.toString());

                    clienteList.add(cliente);
                    System.out.println("Cliente añadido: " + cliente.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Cargo getRandomCargo() {
        Cargo[] cargos = Cargo.values(); // Obtenemos todos los valores del enum
        int randomIndex = new Random().nextInt(cargos.length); // Generamos un índice aleatorio
        return cargos[randomIndex]; // Retornamos el valor aleatorio
    }

    private void validateCliente(Cliente cliente) {
        if (cliente.getId() == null) {
            throw new IllegalArgumentException("El ID del cliente no puede ser nulo");
        }
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede ser nulo o vacío");
        }
        if (cliente.getApellido() == null || cliente.getApellido().trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido del cliente no puede ser nulo o vacío");
        }
        if (cliente.getSueldo() == null) {
            throw new IllegalArgumentException("El sueldo del cliente no puede ser nulo");
        }
        if (cliente.getCargo() == null || cliente.getCargo().trim().isEmpty()) {
            throw new IllegalArgumentException("El cargo del cliente no puede ser nulo o vacío");
        }
    }
}
