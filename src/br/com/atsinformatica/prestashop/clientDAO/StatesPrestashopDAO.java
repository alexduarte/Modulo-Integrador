/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.prestashop.clientDAO;
import br.com.atsinformatica.prestashop.model.root.Prestashop;
import br.com.atsinformatica.prestashop.model.root.State;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kennedimalheiros
 */
public class StatesPrestashopDAO extends GenericPrestashopDAO<State> implements IGenericPrestashopDAO<State>{

    @Override
    public void post(String path, State t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void put(String path, State t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> get(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State getId(String path, int key) {
        
         Prestashop prestashop = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(Prestashop.class);
        return prestashop.getState();       
        
    }

    @Override
    public void delete(String path, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
