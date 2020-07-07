/**
 * 
 */
package ar.edu.unju.fi.tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.tracking.model.RegistroTracking;
import ar.edu.unju.fi.tracking.model.Vehiculo;
import ar.edu.unju.fi.tracking.service.IRegistroTrackingService;
import ar.edu.unju.fi.tracking.service.LocalidadServicelmp;
import ar.edu.unju.fi.tracking.service.RegistroTrackingServicelmp;

//import ar.edu.unju.fi.tracking.service.RegistroTrackingServicelmp;

/**
 * Controlador de Usuario Consultor
 * @author Gonzalez Brian Leonel
 *
 */
@Controller
@RequestMapping
public class ConsultorController {

	//private RegistroTrackingServicelmp registroTrackingService;
	
	@Autowired
	private LocalidadServicelmp localidadServiceImp;
	
	@Autowired
	private RegistroTrackingServicelmp registroTrackingServiceImp;
	
	@Autowired
	private IRegistroTrackingService registroService;
	
	@Autowired
	private Vehiculo unVehiculo;
	
	@Autowired
	private RegistroTracking registroTracking;

	/**
	 * 
	 */
	public ConsultorController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/bienvenida")
	public String bienvenidaConsutor(Model model) {
		return "consultorInfo";
	}
	
	@GetMapping("/consulta")
	public String realizarConsultas(Model model) {
		model.addAttribute("vehiculo", new Vehiculo());
		
		//todos los registros
		model.addAttribute("todosRegistros", registroTrackingServiceImp.obtenerRegistros());
		
		//lista con localidades guardadas
		model.addAttribute("localidades", localidadServiceImp.obtenerLocalidades());
		return "consulta";
	}
	
	@GetMapping("/buscarPorPatente")
	public String buscarPorPatente(
				@RequestParam String patente, Model model, @ModelAttribute("registroTracking") RegistroTracking registroTrack 
			) {
		model.addAttribute("registrosPorPatene", registroService.buscarPorVehiculoPatente(patente));
		return "consulta";
	}
	/*
	@RequestMapping(value="/buscarPorPatente", method = RequestMethod.POST)
	public String buscarPorPatente(
				@RequestParam String patente, Model model, @ModelAttribute("registroTracking") RegistroTracking registroTrack 
			) {
		model.addAttribute("registrosPorPatene", registroService.buscarPorVehiculoPatente(patente));
		return "consulta";
	}*/
}
