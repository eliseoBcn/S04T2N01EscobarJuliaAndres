package cat.itacademy.barcelonactiva.escobarjulia.andres.s04.t02.n01.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

import cat.itacademy.barcelonactiva.escobarjulia.andres.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s04.t02.n01.model.repository.FrutaRepository;

@RestController
@RequestMapping("/fruta")
public class FruitaController {

	@Autowired
	FrutaRepository frutaRepository;

	@PostMapping("/add")
	public ResponseEntity<Fruta> createFruta(@RequestBody Fruta fruta) {
		try {
			Fruta _fruta = frutaRepository
					.save(new Fruta(fruta.getNombre(), fruta.getCantidadQuilos() ));
			return new ResponseEntity<>(_fruta, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruta> getFrutaById(@PathVariable("id") long id) {
		Optional<Fruta> frutaData = frutaRepository.findById(id);

		if (frutaData.isPresent()) {
			return new ResponseEntity<>(frutaData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteFruta(@PathVariable("id") long id) {
		try {
			frutaRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
