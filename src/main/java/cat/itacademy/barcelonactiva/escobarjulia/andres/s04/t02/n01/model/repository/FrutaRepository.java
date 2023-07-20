package cat.itacademy.barcelonactiva.escobarjulia.andres.s04.t02.n01.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s04.t02.n01.model.domain.Fruta;

 

	
	
	public interface FrutaRepository extends JpaRepository<Fruta, Long> {
//		  List<Tutorial> findByPublished(boolean published);
//
//		  List<Fruta> findBynombre(String nombre);
	}
	
 
 