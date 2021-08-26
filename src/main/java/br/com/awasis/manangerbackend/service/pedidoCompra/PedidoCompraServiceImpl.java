/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.pedidoCompra;

import br.com.awasis.manangerbackend.model.ItemPedidoCompra;
import br.com.awasis.manangerbackend.model.PedidoCompra;
import br.com.awasis.manangerbackend.model.SituacaoCompra;
import br.com.awasis.manangerbackend.repository.ItemPedidoCompraRepository;
import br.com.awasis.manangerbackend.repository.PedidoCompraRepository;
import br.com.awasis.manangerbackend.service.grupoFornecedor.GrupoFornecedorSpecification;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 *
 * @author alecsander
 */

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PedidoCompraServiceImpl implements PedidoCompraService{
    
    @Autowired
    private PedidoCompraRepository repository;
    
    @Autowired
    private ItemPedidoCompraRepository repositoryItemParcelaCompra;

    @Override
    public Optional findById(long id) {
        return repository.findOne(PedidoCompraSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(PedidoCompra cp) {
        Specification where = null;
        
        if(cp.getFornecedor() != null || cp.getFornecedor().getIdFornecedor() >= 0 ){
            where = PedidoCompraSpecification.addClausula(where, PedidoCompraSpecification.byIdFornecedorSpecification(cp.getFornecedor().getIdFornecedor()));
        }
        if(cp.getCondicaoPagamento() != null || cp.getCondicaoPagamento().getIdCondicaoPagamento()>= 0 ){
            where = PedidoCompraSpecification.addClausula(where, PedidoCompraSpecification.byIdCondicaoPagamentoSpecification(cp.getCondicaoPagamento().getIdCondicaoPagamento()));
        }
        if(cp.getFormaPagamento() != null || cp.getFormaPagamento().getIdFormaPagamento() >= 0 ){
            where = PedidoCompraSpecification.addClausula(where, PedidoCompraSpecification.byIdFormaPagamentoSpecification(cp.getFormaPagamento().getIdFormaPagamento()));
        }

        
        return repository.findAll(where);
    }

    @Override
    public PedidoCompra save(PedidoCompra cp) {
      /*  if(cp.getFornecedor() == null                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ){
            return null;
        }
        if(cp.getCondicaoPagamento() == null ){
            return null;
        }
        if(cp.getFormaPagamento() == null ){
            return null;
        }
        if(cp.getItensPedidoCompra() == null || cp.getItensPedidoCompra().isEmpty()){
            return null;
        }

        if(cp.getDataPrevistaEntrega() == null){
            return null;
        }
        if(cp.getDataSolicitacao() == null){
            return null;
        }
        */
        
        if(cp.getItensPedidoCompra()!= null){
            
            PedidoCompra temp = repository.save(cp);

            for(ItemPedidoCompra itemPedidoCompraTemp : temp.getItensPedidoCompra()){
                itemPedidoCompraTemp.setPedidoCompra(temp);
            }

            return repository.save(temp);            
        }else return null;
        

    }

    @Override
    public Optional<PedidoCompra> update(PedidoCompra cp, long id) {
        return repository.findById(id).map(record ->{
                        
                        if(cp.getItensPedidoCompra()!= null){
                            
                            for(ItemPedidoCompra itemPedidoCompraTemp : cp.getItensPedidoCompra()){
                                itemPedidoCompraTemp.setPedidoCompra(record);
                            }
                            for(ItemPedidoCompra itemPedidoCompraTemp : record.getItensPedidoCompra()){
                                itemPedidoCompraTemp.setExcluido(true);
                                
                            }
                            record.getItensPedidoCompra().clear();
                            record.setItensPedidoCompra(cp.getItensPedidoCompra());
                        }
                        
            
                        record.setFornecedor(cp.getFornecedor());
                        record.setCondicaoPagamento(cp.getCondicaoPagamento());
                        record.setFormaPagamento(cp.getFormaPagamento());
                        record.setSolicitante(cp.getSolicitante());
                        record.setDataSolicitacao(cp.getDataSolicitacao());
                        record.setDataPrevistaEntrega(cp.getDataPrevistaEntrega());
                        record.setDataEntrega(cp.getDataEntrega());
                        record.setSifFob(cp.getSifFob());
                        record.setValorFrete(cp.getValorFrete());
                        record.setValorTotal(cp.getValorTotal());
                        record.setSituacao(cp.getSituacao());
                        
                        return repository.save(record);
                });
    }

    @Override
    public boolean delete(long id) {
        if(id > 0 ){
            repository.deleteById(id);
            return true;
        }else return false;
    }
    
}
