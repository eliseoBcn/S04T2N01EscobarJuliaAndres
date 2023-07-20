package cat.itacademy.barcelonactiva.escobarjulia.andres.s04.t02.n01.model.services;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.escobarjulia.andres.s04.t02.n01.model.repository.FrutaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class FrutaServiceImpl  implements FrutaService {

	public FrutaServiceImpl() {
		// TODO Auto-generated constructor stub
	}
    private static Logger logger=Logger.getLogger(FrutaServiceImpl.class.getName());
    @Autowired
    private FrutaRepository frutaRepository;

    /**
     * Retrieve to-do list
     * @return
     */
    @Override
    public List<Fruta> getMyFrutaList(){
        List<Fruta> frutaList= new ArrayList<>();
        frutaRepository.findAll().forEach(frutaList::add);

        return  frutaList;
    }


    /**
     * retrieve to-do item
     * @param frutaId
     * @return
     */
    @Override
    public Optional<Fruta> GetFrutaByID(long frutaId){
        return frutaRepository.findById(frutaId);
    }

    /**
     * Add item to the list and return the id of the new item
     * @param fruta
     * @return
     */
    @Override
    public long AddItemToThelist(Fruta fruta){
        long frutaId=0;
        frutaRepository.save(fruta);
        frutaId=fruta.getId();

        return frutaId;


    }


    /**
     * Delete item from the list
     * @param id
     */
    @Override
    public void DeleteItem(long id){
        long itemId=0;
        frutaRepository.deleteById(id);
        logger.info("Item removed from the list");
    }

    /**
     * Update to-do item
     * @param frutaId
     * @param fruta
     * @return
     */
    @Override

    public long UpdateFrutaItem(long frutaId, Fruta fruta){

        long updateFrutaId=0;
        //Retrieve the value you want to update
        try {
            Fruta updatedFruta=frutaRepository.findById(frutaId).get();

            updatedFruta.setNombre(fruta.getNombre());
            updatedFruta.setCantidadQuilos(fruta.getCantidadQuilos());
            frutaRepository.save(updatedFruta);
            updateFrutaId=updatedFruta.getId();
            return updateFrutaId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateFrutaId;

    }

    /**
     * Verify if the id provided is valid
     * @param frutaId
     * @return
     */
    @Override
    public boolean isFrutaItemIdValid(long frutaId){
        return frutaRepository.findById(frutaId).isPresent();
    }

    /**
     * returns number of items
     * @return
     */
    @Override
    public long getNumberFrutaItem(){
      return frutaRepository.count();
    }


}




