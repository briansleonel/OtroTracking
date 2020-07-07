package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.repository.IVehiculoDAO;

/**
 * Esta clase ultiza la anotacion @Repository para manejar las instancias de los objetos  
 * de la clase e implementa los metodos de la interfaz IVehiculoService para poder
 * utilizarlos luego para manipular los datos 
 * @author Toconas Ulises
 */
@Repository
public class VehiculoServicelmp implements IVehiculoService {

	@Autowired
	IVehiculoDAO  vehiculoDAOImp;
	
	@Override
	public void guardaVehiculoLocalidad(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		vehiculoDAOImp.save(vehiculo);
	}

	@Override
	public List<Vehiculo> obtenerVehiculos() {
		// TODO Auto-generated method stub
		return vehiculoDAOImp.findAll();
	}

	@Override
	public Optional<Vehiculo> obtenerUnVehiculo(Long id) {
		// TODO Auto-generated method stub
		return vehiculoDAOImp.findById(id);
	}

	@Override
	public void eliminarVehiculo(Long id) {
		// TODO Auto-generated method stub
		vehiculoDAOImp.deleteById(id);
	}

}
