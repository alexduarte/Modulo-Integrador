/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.erp.controller;

import br.com.atsinformatica.erp.dao.HistoricoIntegraDAO;
import br.com.atsinformatica.erp.entity.CategoriaEcomErpBean;
import br.com.atsinformatica.erp.entity.HistoricoIntegraERPBean;
import br.com.atsinformatica.erp.entity.ProdutoERPBean;
import com.sun.jersey.api.client.UniformInterfaceException;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 * Superclasse generica responsável por gerenciar a sincronização na loja
 * virtual
 *
 * @author AlexsanderPimenta
 */
public class SincERPController<T> implements ISincController<T> {

    public SincERPController() {
    }

    @Override
    public void post(T obj) throws Exception {
        try {
            if (obj.getClass().equals(CategoriaEcomErpBean.class)) {
                new CategoriaERPController().post((CategoriaEcomErpBean) obj);
            }
            if (obj.getClass().equals(ProdutoERPBean.class)) {
                new ProdutoERPController().post((ProdutoERPBean) obj);
            }
            atualizaDataInt(obj);
        } catch (UniformInterfaceException e) {
            System.out.println("Erro ao efetuar post: "+e);
        }

    }

    @Override
    public void update(T obj) {
        if (obj.getClass().equals(CategoriaEcomErpBean.class)) {
            new CategoriaERPController().update((CategoriaEcomErpBean) obj);
        }
        if (obj.getClass().equals(ProdutoERPBean.class)) {
            new ProdutoERPController().update((ProdutoERPBean) obj);
        }
    }

    @Override
    public void delete(T obj) {
        HistoricoIntegraERPBean objAux = (HistoricoIntegraERPBean) obj;
        if (this.getClass().equals(CategoriaEcomErpBean.class)) {
            new CategoriaERPController().delete(objAux.getCodEntidade());
        }
        new ProdutoERPController().delete(objAux.getCodEntidade());
    }

    public void atualizaDataInt(T obj) throws SQLException {
        try {
            HistoricoIntegraDAO dao = new HistoricoIntegraDAO();
            HistoricoIntegraERPBean bean = (HistoricoIntegraERPBean) obj;
            new HistoricoIntegraDAO().alteraDataInt(bean.getId());
        } catch (Exception e) {
            Logger.getLogger(SincERPController.class).error("Erro ao atualizar data de integração: " + e);
        }

    }
}
