package cat.itacademy.barcelonactiva.escobarjulia.andres.s04.t02.n01.model.services;
 


import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.escobarjulia.andres.s04.t02.n01.model.domain.Fruta;



import java.util.List;
import java.util.Optional;



@Service
public interface FrutaService {

 
    /**
     * Retrieve to-do list
     * @return
     */
   List<Fruta> getMyFrutaList();
    


    /**
     * retrieve to-do item
     * @param frutaId
     * @return
     */
     Optional<Fruta> GetFrutaByID(long frutaId);

    /**
     * Add item to the list and return the id of the new item
     * @param fruta
     * @return
     */
    long AddItemToThelist(Fruta fruta);




    /**
     * Delete item from the list
     * @param id
     */
     void DeleteItem(long id);
    
    /**
     * Update to-do item
     * @param frutaId
     * @param fruta
     * @return
     */
    long UpdateFrutaItem(long frutaId, Fruta fruta);

    /**
     * Verify if the id provided is valid
     * @param frutaId
     * @return
     */
    boolean isFrutaItemIdValid(long frutaId);
   

    /**
     * returns number of items
     * @return
     */
    long getNumberFrutaItem();


    
}



