/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.subgrupoProduto;

import br.com.awasis.manangerbackend.model.SubgrupoProduto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface SubgrupoProdutoService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(SubgrupoProduto cp);
    public SubgrupoProduto save(SubgrupoProduto cp);
    public Optional<SubgrupoProduto> update(SubgrupoProduto cp, long id);
    public boolean delete(long id);   
    
}
