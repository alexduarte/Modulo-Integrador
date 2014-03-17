/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.clientDAO;

import br.com.atsinformatica.prestashop.model.list.prestashop.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.model.list.prestashop.PrestashopItens;
import br.com.atsinformatica.prestashop.model.root.prestashop.Prestashop;
import br.com.atsinformatica.prestashop.model.root.Category;
import com.sun.jersey.api.client.ClientResponse;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ricardosilva
 */
public class CategoryPrestashopDAO extends GenericPrestashopDAO<Category> implements IGenericPrestashopDAO<Category> {
    
    /**
     * Adiciona um item Categoria
     *
     * @param path
     * @param t
     */
    @Override
    public void post(String path, Category t) {
        Prestashop prestashopCategory = new Prestashop();
        prestashopCategory.setCategory(t);
        String xml = createTOXML(prestashopCategory);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(ClientResponse.class, xml);
        System.out.println(response.getStatus());
    }
    
    @Override
    public void delete(String path, String idCategorie) {
        Prestashop prestashopCategory = new Prestashop();
        Category cat = new Category();
        cat.setId(idCategorie);
        prestashopCategory.setCategory(cat);
        String xml = createTOXML(prestashopCategory);
        getWebResource().path(path).path(idCategorie).type(MediaType.APPLICATION_XML).delete();
        //ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).delete(ClientResponse.class, xml);
        //System.out.println(response.getStatus());
    }

    /**
     * Adiciona uma categoria e retorna o objeto salvo
     * @param path
     * @param t
     * @return
     */
    public int postCategory(String path, Category t) {
        Prestashop prestashopCategory = new Prestashop();
        prestashopCategory.setCategory(t);
        String xml = createTOXML(prestashopCategory);
        Prestashop post = getWebResource().path(path).type(MediaType.APPLICATION_XML).post(Prestashop.class, xml);        
        return Integer.parseInt(post.getCategory().getId());
    }
    
    /**
     * Atualiza um item específico de Categoria.
     *
     * @param path
     * @param t
     */
    @Override
    public void put(String path, Category t) {
        Prestashop prestashopCategory = new Prestashop();
        prestashopCategory.setCategory(t);
        String xml = createTOXML(prestashopCategory);
        ClientResponse response = getWebResource().path(path).type(MediaType.APPLICATION_XML).put(ClientResponse.class, xml);        
        System.out.println("Response: "+response);
    }

    /**
     * retorna todos itens de categoria
     *
     * @param path
     * @return
     */
    @Override
    public List<Category> get(String path) {
        PrestashopItens getListItens = getWebResource().path(path).type(MediaType.APPLICATION_XML).get(PrestashopItens.class);
        List<Category> listCategory = new ArrayList<>();
        for (AccessXMLAttribute accessXMLAttribute : getListItens.getCategories().getCategory()) {
            Prestashop prestashop = getWebResource().path(path).path(accessXMLAttribute.getId()).type(MediaType.APPLICATION_XML).get(Prestashop.class);
            listCategory.add(prestashop.getCategory());  
        }
        return listCategory;
    }

    /**
     * Retorna um item em específico da Categoria
     *
     * @param path
     * @param key
     * @return
     */
    @Override
    public Category getId(String path, int key) {    
        Prestashop prestashop = getWebResource().path(path).path(String.valueOf(key)).type(MediaType.APPLICATION_XML).get(Prestashop.class);
        return prestashop.getCategory();
    }

}
