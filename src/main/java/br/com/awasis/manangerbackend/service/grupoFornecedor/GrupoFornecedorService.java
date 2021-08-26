/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.grupoFornecedor;


import br.com.awasis.manangerbackend.model.GrupoFornecedor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface GrupoFornecedorService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(GrupoFornecedor gf);
    public GrupoFornecedor save(GrupoFornecedor gf);
    public Optional<GrupoFornecedor> update(GrupoFornecedor gf, long id);
    public boolean delete(long id);
    
}
