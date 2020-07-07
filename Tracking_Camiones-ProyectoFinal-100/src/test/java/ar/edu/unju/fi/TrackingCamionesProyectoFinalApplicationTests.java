package ar.edu.unju.fi;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tracking.model.Localidad;
import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Tripulante;
import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.service.LocalidadServicelmp;
import ar.edu.unju.fi.tracking.service.RegistroTrackingServicelmp;
import ar.edu.unju.fi.tracking.service.TripulanteServicelmp;
import ar.edu.unju.fi.tracking.service.VehiculoServicelmp;

@SpringBootTest
class TrackingCamionesProyectoFinalApplicationTests {
	
	@Autowired
	RegistroTrackingServicelmp registroService;
	
	@Autowired
	TripulanteServicelmp tripulanteService;
	
	@Autowired
	VehiculoServicelmp vehiculoService;
	
	@Autowired
	LocalidadServicelmp localidadService;
	
	@Test
	void contextLoads() {
		
		
			
			
			Tripulante tripulante1 = new Tripulante();
			Tripulante tripulante2 = new Tripulante();
			
			tripulante1.setDocumento("41654188");
			tripulante1.setNombres("Juan");
			tripulante1.setApellido("Perez");
			tripulante1.setNacionalidad("Argentina");
			
			tripulante2.setDocumento("41654188");
			tripulante2.setNombres("Lucas");
			tripulante2.setApellido("Perez");
			tripulante2.setNacionalidad("Argentina");
			
			tripulanteService.guardarTripulante(tripulante1);
			tripulanteService.guardarTripulante(tripulante2);;
			
			//List<Tripulante> tripulantes = new ArrayList<Tripulante>();
			List<Tripulante> tripulantes = tripulanteService.obtenerTripulantes();
			
			//List<Tripulante> tripulantes = new ArrayList<Tripulante>();
			//while ( iteratorTripulantes.h);
			
			//iteratorTripulantes.forEach(tripulantes::add);
			
			//tripulantes.add(tripulanteRepository.findAll());
			//tripulantes.add(tripulante2);
			
			Vehiculo vehiculo = new Vehiculo();
			
			vehiculo.setColor("Azul");
			vehiculo.setMarca("Mercedes Benz");
			vehiculo.setModelo("2006");
			vehiculo.setNumeroChasis("1234567890");
			vehiculo.setNumeroMotor("1234567890123");
			vehiculo.setPatente("WJD 123");
			vehiculo.setTipo("Camion");
			vehiculo.setTitular("Juan de Montreal");
			
			vehiculoService.guardaVehiculoLocalidad(vehiculo);;
			
			//Iterable<Vehiculo> iterableVehiculo = vehiculoRepository.findAll();
			
			//Vehiculo vehiculoNuevo = new Vehiculo();
			
			//vehiculoNuevo = iterableVehiculo.iterator().next();
			
			List<Vehiculo> vehiculos = vehiculoService.obtenerVehiculos();
			
			Vehiculo vehiculoReg = vehiculos.get(0);
			
			//Iterable<Localidad> localidades = localidadRepository.findAll();
			
			List<Localidad> localidades = localidadService.obtenerLocalidades();
			
			Localidad localidad = new Localidad();
			
			localidad = localidades.get(0);
			
			RegistroTracking registro1 = new RegistroTracking();
			
			registro1.setDetalleLugarRegistro("-------------------------------");
			registro1.setFechaHora(LocalDateTime.of(2020, 04, 23, 12, 30, 12));
			registro1.setTripulantes(tripulantes);
			registro1.setVehiculo(vehiculoReg);
			registro1.setLocalidad(localidad);
			
			registroService.guardarRegistroTracking(registro1);
		
	}

}
