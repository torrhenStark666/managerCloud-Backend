/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tipoPedidoVenda;

import br.com.awasis.manangerbackend.model.TipoPedidoVenda;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface TipoPedidoVendaService {

    public Optional findById(long id);
    public List findAll();
    public List find(TipoPedidoVenda cp);
    public TipoPedidoVenda save(TipoPedidoVenda cp);
    public Optional<TipoPedidoVenda> update(TipoPedidoVenda cp, long id);
    public boolean delete(long id); 
    
}
