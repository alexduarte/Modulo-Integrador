/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.prestashop.clientDAO;

import java.util.List;

/**
 *
 * @author ricardosilva
 */
public interface IGenericPrestashopDAO<T> {
  
    public void post(String path,T prestashopPackage);
    
    public void put(String path,T prestashopPackage);
    
    public List<T> get(String path,Class<?> classePrestashopPackage);
    
    public T getId(String path,int key,Class<?> classePrestashopPackage);
}
