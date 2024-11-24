package controlador;

import java.util.List;
import modelo.CargoRepository;
import modelo.CargoModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class CargoController {
    private CargoRepository cargoListModel;
    
    public CargoController(CargoRepository cargoListModel){
        this.cargoListModel = cargoListModel;
    }
    
    public void addCargo(String cargo){
        CargoModel cargoModel = new CargoModel();
        cargoModel.setCargo(cargo);
        cargoListModel.addCargo(cargoModel);
    }
    
    public List<CargoModel> getAllCargos() {
        return cargoListModel.getCargoList();
    }
}
