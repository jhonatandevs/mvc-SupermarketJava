/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CargoRepository {
     private List<CargoModel> cargoList;
    
    public CargoRepository() {
        cargoList = new ArrayList<CargoModel>();
    }
    
    public List<CargoModel> getCargoList(){
        return cargoList;
    }
    
    public void addCargo(CargoModel cargo){
        cargoList.add(cargo);
    }
}
