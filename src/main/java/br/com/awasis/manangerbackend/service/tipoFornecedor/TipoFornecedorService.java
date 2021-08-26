/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tipoFornecedor;

import br.com.awasis.manangerbackend.model.GrupoFornecedor;
import br.com.awasis.manangerbackend.model.TipoFornecedor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface TipoFornecedorService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(TipoFornecedor tf);
    public TipoFornecedor save(TipoFornecedor tf);
    public Optional<TipoFornecedor> update(TipoFornecedor tf, long id);
    public boolean delete(long id);
    
}
