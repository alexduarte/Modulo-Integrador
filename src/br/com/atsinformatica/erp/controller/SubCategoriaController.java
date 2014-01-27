/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.entity.SubCategoriaERPBean;
import br.com.atsinformatica.prestashop.clientDAO.CategoryPrestashopDAO;
import br.com.atsinformatica.prestashop.model.category.Category;
import br.com.atsinformatica.prestashop.model.category.Description;
import br.com.atsinformatica.prestashop.model.category.Language;
import br.com.atsinformatica.prestashop.model.category.LinkRewrite;
import br.com.atsinformatica.prestashop.model.category.Name;

/**
 *
 * @author ricardosilva
 */
public class SubCategoriaController {

    int idPai = 0;

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
        String listsubCategoria[] = subCategoriaERP.split("/");
        for (String subCategoria : listsubCategoria) {
            idPai = createOnPrestaShop(subCategoria, idParent);
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
        category.setPosition(1);
        category.setLinkRewrite(linkRewrite);
        category.setIdParent(idParent);

        return new CategoryPrestashopDAO().postCategory(Category.URLCATEGORY, category);
    }

}
