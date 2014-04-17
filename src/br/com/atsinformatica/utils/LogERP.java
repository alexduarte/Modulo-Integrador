/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.utils;

import br.com.atsinformatica.erp.dao.LogERPDao;
import br.com.atsinformatica.erp.entity.LogERPBean;
import br.com.atsinformatica.erp.entity.UsuarioERPBean;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kennedimalheiros
 */
public class LogERP {

    public static void geraLog(String nomeTabela, String chave, String acao, String obs) throws SQLException {
        LogERPDao logERPDao = new LogERPDao();
        LogERPBean logERP = new LogERPBean();
        DateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
        String hora = horaFormat.format(new Date());        
        logERP.setNomeTabela(nomeTabela);
        logERP.setChaveRegistro(chave);
        logERP.setAcao(acao);
        logERP.setSistema("MID");
        logERP.setObservacao(obs);
        logERP.setUsuario(UsuarioERPBean.getUsuario());
        logERP.setData(new Date());
        logERP.setHora(hora);

        logERPDao.gravar(logERP);

    }

}
