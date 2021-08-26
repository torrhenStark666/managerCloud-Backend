/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.formaPagamento;

import br.com.awasis.manangerbackend.model.FormaPagamento;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface FormaPagamentoService {

    public Optional findById(long id);
    public List findAll();
    public List find(FormaPagamento cp);
    public FormaPagamento save(FormaPagamento cp);
    public Optional<FormaPagamento> update(FormaPagamento cp, long id);
    public boolean delete(long id);    
    
}
