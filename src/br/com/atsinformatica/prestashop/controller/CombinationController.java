/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.prestashop.controller;

import br.com.atsinformatica.erp.dao.GradeERPDAO;
import br.com.atsinformatica.erp.dao.ProdutoDAO;
import br.com.atsinformatica.erp.dao.SubGradeERPDAO;
import br.com.atsinformatica.erp.entity.GradeERPBean;
import br.com.atsinformatica.erp.entity.ProdGradeERPBean;
import br.com.atsinformatica.erp.entity.SubGradeERPBean;
import br.com.atsinformatica.prestashop.clientDAO.CombinationDAO;
import br.com.atsinformatica.prestashop.model.node.AssociationsNode;
import br.com.atsinformatica.prestashop.model.node.Price;
import br.com.atsinformatica.prestashop.model.node.ProductOptionValuesNode;
import br.com.atsinformatica.prestashop.model.node.ProductOptionsValuesNode;
import br.com.atsinformatica.prestashop.model.root.Combination;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlexsanderPimenta
 */
public class CombinationController {
    
    /** 
     * Cria combinação de grade na loja virtual 
     * @param prodGrade
     * @return 
     */
    public int createCombination(ProdGradeERPBean prodGrade) throws SQLException{
       return new CombinationDAO().postCombination(Combination.URLCOMBINATION, this.create(prodGrade));
    }
    
    private Combination create(ProdGradeERPBean prodGrade) throws SQLException{
        Combination combination = new Combination();        
        combination.setIdProduct(new ProdutoDAO().abrir(prodGrade.getCodProd()).getIdProdutoEcom());
        Price price = new Price();
        price.setContent(String.valueOf(prodGrade.getPrecoGrade()));
        combination.setPrice(price);
        combination.setQuantity(prodGrade.getEstoque().intValue());
        combination.setMinimalQuantity(1);
        AssociationsNode associations = new AssociationsNode();
        associations.setProductOptionValues(this.createProductOptionValues(prodGrade));
        combination.setAssociations(associations);
        return combination;       
    }

    private ProductOptionValuesNode createProductOptionValues(ProdGradeERPBean prodGrade) {
        SubGradeERPDAO subGradeDAO = new SubGradeERPDAO();
        GradeERPDAO gradeDAO = new GradeERPDAO();
        ProductOptionValuesNode prodOptionValues = new ProductOptionValuesNode();
        try{
            List<ProductOptionsValuesNode> listProdOptionsValues = new ArrayList<>();
            //grade simples
            if(prodGrade.getTipoGrade()==1){
                ProductOptionsValuesNode prodOptionsValues = new ProductOptionsValuesNode();
                GradeERPBean grade = gradeDAO.abrir(prodGrade.getCodGrade());
                prodOptionsValues.setId(grade.getIdGradeEcom());
                listProdOptionsValues.add(prodOptionsValues);
            }
            //grade composta
            if(prodGrade.getTipoGrade()==2){
                ProductOptionsValuesNode gradeOptionsValue = new ProductOptionsValuesNode();
                SubGradeERPBean grade = subGradeDAO.abrir(prodGrade.getCodGrade().substring(0, 1));
                gradeOptionsValue.setId(grade.getIdSubgradeEcom());
                listProdOptionsValues.add(gradeOptionsValue);
                ProductOptionsValuesNode subGradeOptionsValue = new ProductOptionsValuesNode();
                SubGradeERPBean subGrade = subGradeDAO.abrir(prodGrade.getCodGrade().substring(2, 3));
                subGradeOptionsValue.setId(subGrade.getIdSubgradeEcom());
                listProdOptionsValues.add(subGradeOptionsValue);
            }            
            prodOptionValues.setProdOptionsValues(listProdOptionsValues);
            return prodOptionValues;
        }catch(Exception e){
            return null;
            
        }
    }
    
}
