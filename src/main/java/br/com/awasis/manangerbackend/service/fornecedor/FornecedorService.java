/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.fornecedor;

import br.com.awasis.manangerbackend.model.Fornecedor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface FornecedorService {
    
    public Optional<Fornecedor> findById(long id);
    public List findAll();
    public List<Fornecedor> find(Fornecedor f);
    public Fornecedor save(Fornecedor f);
    public void delete(long id);
    
    
}
