/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.condicaoPagamento;

import br.com.awasis.manangerbackend.model.CondicaoPagamento;
import br.com.awasis.manangerbackend.model.DiasParcelas;
import br.com.awasis.manangerbackend.repository.CondicaoPagamentoRepository;
import br.com.awasis.manangerbackend.repository.DiasParcelasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CondicaoPagamentoServiceImpl implements CondicaoPagamentoService {
    
    @Autowired
    private CondicaoPagamentoRepository repository;
    
    @Autowired
    private DiasParcelasRepository repositoryDias;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(CondicaoPagamentoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(CondicaoPagamento cp) {
        Specification where = null;
        
        if(!cp.getContasPagarReceber().isEmpty() || !cp.getContasPagarReceber().isBlank()){
            where = CondicaoPagamentoSpecification.addClausula(where, CondicaoPagamentoSpecification.
                                                    bycontasPagarReceberSpecification(cp.getContasPagarReceber()));
        }
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank()){
            where = CondicaoPagamentoSpecification.addClausula(where, CondicaoPagamentoSpecification.
                                                    byDescricaoSpecification(cp.getDescricao()));
        }

        
        if(cp.getJuros()<= 0){
            where = CondicaoPagamentoSpecification.addClausula(where, CondicaoPagamentoSpecification.
                                                    byJurosSpecification(cp.getJuros()));
        }
        
        if(cp.getDesconto()<= 0){
            where = CondicaoPagamentoSpecification.addClausula(where, CondicaoPagamentoSpecification.
                                                    byDescontoSpecification(cp.getDesconto()));
        }
        
        if(cp.getQuantidadeVezes()<= 0){
            where = CondicaoPagamentoSpecification.addClausula(where, CondicaoPagamentoSpecification.
                                                    byQuantidadeSpecification(cp.getQuantidadeVezes()));
        }
        
        if(cp.getPrazoMedio()<= 0){
            where = CondicaoPagamentoSpecification.addClausula(where, CondicaoPagamentoSpecification.
                                                    byPrazoMedioSpecification(cp.getPrazoMedio()));
        }
        
        return repository.findAll(where);
    }

    @Override
    public CondicaoPagamento save(CondicaoPagamento cp) {
        if(cp.getDiasParcelas() != null){
            
            CondicaoPagamento temp = repository.save(cp);

            for(DiasParcelas diasParcelasTemp : temp.getDiasParcelas()){
                diasParcelasTemp.setCondicaoPagamento(temp);
            }

            return repository.save(temp);            
        }else return null;

    }

    @Override
    public Optional<CondicaoPagamento> update(CondicaoPagamento cp, long id) {
        return repository.findById(id)
                .map((CondicaoPagamento record)->{
                    record.setDescricao(cp.getDescricao());
                    record.setContasPagarReceber(cp.getContasPagarReceber());
                    record.setDesconto(cp.getDesconto());
                    record.setJuros(cp.getJuros());
                    record.setPrazoMedio(cp.getPrazoMedio());
                    record.setQuantidadeVezes(cp.getQuantidadeVezes());
                                        
                    if(cp.getDiasParcelas()!= null){
                            
                        for(DiasParcelas diasParcelasTemp : cp.getDiasParcelas()){
                            diasParcelasTemp.setCondicaoPagamento(record);
                        }
                        for(DiasParcelas diasParcelasTemp: record.getDiasParcelas()){
                            diasParcelasTemp.setExcluido(true);
                        }
                        
                        record.getDiasParcelas().clear();
                        
                        record.setDiasParcelas(cp.getDiasParcelas());
                    }
                    
                    CondicaoPagamento updated = repository.save(record);
                    return updated;
                });
    }

    @Override
    public boolean delete(long id) {
        if(id > 0){
            var temp = repository.findById(id).get();
            
            for(DiasParcelas diasParcelasTemp : temp.getDiasParcelas()){
                diasParcelasTemp.setExcluido(true);
            }
            repository.deleteById(id);
            return true;
        }else return false;
    }
    
}
