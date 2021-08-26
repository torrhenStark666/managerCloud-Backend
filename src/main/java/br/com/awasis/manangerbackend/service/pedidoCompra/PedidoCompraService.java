/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.pedidoCompra;

import java.util.List;
import java.util.Optional;
import br.com.awasis.manangerbackend.model.PedidoCompra;

/**
 *
 * @author alecsander
 */
public interface PedidoCompraService {
    
        
    public Optional findById(long id);
    public List findAll();
    public List find(PedidoCompra cp);
    public PedidoCompra save(PedidoCompra cp);
    public Optional<PedidoCompra> update(PedidoCompra cp, long id);
    public boolean delete(long id);  
    
}
