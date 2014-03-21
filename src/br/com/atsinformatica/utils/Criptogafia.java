/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.utils;

import org.codehaus.plexus.util.StringUtils;

/**
 *
 * @author kennedimalheiros
 */
public class Criptogafia {

    private static String codigo_criptografado = "";

    public static String Converter(String param) {
        codigo_criptografado = "";
        int acsii;

        //Converter para CAIXA MAIUSCULO, e adicionando os espaços no final
        param = StringUtils.rightPad(param.toUpperCase(), 8, " ");

        //for inverte a string e converte para ASCII
        for (int a = param.length() - 1; a >= 0; a--) {

            acsii = param.charAt(a);

            codigo_criptografado += StringUtils.leftPad(String.valueOf(acsii), 3, "0");

        }
        return codigo_criptografado;
    }

}
