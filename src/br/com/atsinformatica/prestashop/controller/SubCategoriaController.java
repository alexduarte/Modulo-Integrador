/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.prestashop.model.node.Name;
import br.com.atsinformatica.prestashop.model.node.LinkRewrite;
import br.com.atsinformatica.prestashop.model.node.Description;
import br.com.atsinformatica.prestashop.model.node.Language;
import br.com.atsinformatica.prestashop.clientDAO.CategoryPrestashopDAO;
import br.com.atsinformatica.prestashop.model.root.Category;
import java.util.List;

/**
 *
 * @author ricardosilva
 */
public class SubCategoriaController {

    

    /**
     * Cria uma as subcategorias no prestashop
     *
     * @param subCategoriaERP
     * @param idParent
     * @return idParentFinal
     */
    public int createSubCategoryPrestaShop(int idParent, String subCategoriaERP) {
        if (subCategoriaERP.isEmpty()) {
            return idParent;
        }
        int idPai = idParent;
        String listsubCategoria[] = subCategoriaERP.split("/");
        List<Category> listCategoryPrestaShop = new CategoryPrestashopDAO().get(Category.URLCATEGORY);
        for (String subCategoria : listsubCategoria) {
            idPai = checksCategoryExists(subCategoria, listCategoryPrestaShop,idPai);    
            }
        return idPai;
    }
    
    /**
     * Cria uma as subcategorias no prestashop
     *
     * @param nomeCategoria
     * @param idParent
     * @return idParentFinal
     */
    private int createOnPrestaShop(String nomeCategoria, int idParent) {

        Language language = new Language();
        language.setContent(nomeCategoria);

        Description d = new Description();
        d.getLanguage().add(language);

        Name n = new Name();
        n.getLanguage().add(language);

        LinkRewrite linkRewrite = new LinkRewrite();
        language.setContent(nomeCategoria.toLowerCase());
        linkRewrite.getLanguage().add(language);

        Category category = new Category();
        category.setDescription(d);
        category.setName(n);
        category.setLinkRewrite(linkRewrite);
        category.setIdParent(idParent);

        return new CategoryPrestashopDAO().postCategory(Category.URLCATEGORY, category);
    }

    private int checksCategoryExists(String descricao, List<Category> listCategoryPrestaShop,int idParent) {

        if (listCategoryPrestaShop.isEmpty()) {
            return createOnPrestaShop(descricao, idParent);
        } else {
            for (Category categoriaPrestashopBean : listCategoryPrestaShop) {
                if (categoriaPrestashopBean.getName().getTextName().toLowerCase().equals(descricao.toLowerCase())) {
                    return Integer.parseInt(categoriaPrestashopBean.getId());
                }
            }
            return createOnPrestaShop(descricao, idParent);
        }
    }
}
