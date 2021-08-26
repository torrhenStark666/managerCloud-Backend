/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tipoProduto;

import br.com.awasis.manangerbackend.model.TipoProduto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface TipoProdutoService {

    public Optional findById(long id);
    public List findAll();
    public List find(TipoProduto cp);
    public TipoProduto save(TipoProduto cp);
    public Optional<TipoProduto> update(TipoProduto cp, long id);
    public boolean delete(long id);        
    
}
