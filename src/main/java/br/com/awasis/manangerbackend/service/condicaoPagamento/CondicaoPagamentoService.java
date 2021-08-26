/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.condicaoPagamento;

import br.com.awasis.manangerbackend.model.CondicaoPagamento;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface CondicaoPagamentoService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(CondicaoPagamento cp);
    public CondicaoPagamento save(CondicaoPagamento cp);
    public Optional<CondicaoPagamento> update(CondicaoPagamento cp, long id);
    public boolean delete(long id);
    
}
