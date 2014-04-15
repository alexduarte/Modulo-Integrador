/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.entity.CadFabricERPBean;
import br.com.atsinformatica.prestashop.clientDAO.ManufacturerDAO;
import br.com.atsinformatica.prestashop.model.node.Description;
import br.com.atsinformatica.prestashop.model.node.Language;
import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.node.ShortDescription;
import br.com.atsinformatica.prestashop.model.root.Manufacturer;

/**
 *
 * @author AlexsanderPimenta
 */
public class ManufacturerController  {
    
    /**
     * Cria fabricante na loja virtual e retorna id salvo na loja
     * @param cadFab Fabricante do ERP
     * @return inteiro com id do fabricante salvo na loja virtual
     */
    public int createManufacturerPrestashop(CadFabricERPBean cadFab){
        return new ManufacturerDAO().post(Manufacturer.URLMANUFACTURERS, createManufacturer(cadFab));
    }
    
    /**
     * Atualiza fabricante na loja virtual
     * @param cadFab fabricante do erp
     */
    public void updateManufacturerPrestashop(CadFabricERPBean cadFab){
        new ManufacturerDAO().put(Manufacturer.URLMANUFACTURERS, createManufacturer(cadFab));
    }
    
    /**
     * Deleta fabricante na loja virtual
     * @param id id do fabricante 
     */
    public void deleteManufacturerPrestashop(String id){
        new ManufacturerDAO().delete(Manufacturer.URLMANUFACTURERS, id);
    }
    /**
     * Serializa fabricante do ERP para loja virtual
     * @param m fabricante do ERP
     * @return Manufacturer 
     */
    private Manufacturer createManufacturer(CadFabricERPBean cadFab) {
        Manufacturer manufacturer = new Manufacturer();
        Description description = new Description();
        ShortDescription shortDescription = new ShortDescription();
        if(cadFab.getIdFabricanteEcom()!=0)manufacturer.setId(String.valueOf(cadFab.getIdFabricanteEcom()));
        manufacturer.setIdErp(cadFab.getCodFabric());
        manufacturer.setName(cadFab.getDescricao());
        description.getLanguage().add(new Language(cadFab.getDescricao()));
        manufacturer.setDescription(description);
        shortDescription.getLanguage().add(new Language(cadFab.getDescricao()));
        manufacturer.setShortDescription(shortDescription);
        return manufacturer;
    }
    
   
    
}
