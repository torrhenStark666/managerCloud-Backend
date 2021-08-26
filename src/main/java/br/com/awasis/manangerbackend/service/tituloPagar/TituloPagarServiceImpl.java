/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tituloPagar;

import br.com.awasis.manangerbackend.model.CondicaoPagamento;
import br.com.awasis.manangerbackend.model.ParcelaPagar;
import br.com.awasis.manangerbackend.model.TituloPagar;
import br.com.awasis.manangerbackend.repository.CondicaoPagamentoRepository;
import br.com.awasis.manangerbackend.repository.ParcelaPagarRepository;
import br.com.awasis.manangerbackend.repository.TituloPagarRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TituloPagarServiceImpl implements TituloPagarService {
    
    private TituloPagarRepository repository;
    private CondicaoPagamentoRepository condicaoRepository;
    private ParcelaPagarRepository parcelaRepository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(TituloPagarSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(TituloPagar cp) {
        Specification where = null;
        
        if(cp.getDataInclusao() != null){
            where = TituloPagarSpecification.addClausula(where, TituloPagarSpecification.byDataInclusaoSpecification(cp.getDataInclusao()));
        }
        if(cp.getDataLancamento() != null){
            where = TituloPagarSpecification.addClausula(where, TituloPagarSpecification.byDataLancamentoSpecification(cp.getDataLancamento()));
        }
        if(cp.getCondicaoPagamento() != null){
            where = TituloPagarSpecification.addClausula(where, TituloPagarSpecification.byIdCondicaoPagamentoSpecification(cp.getCondicaoPagamento().getIdCondicaoPagamento()));
        }
        if(cp.getFormaPagamento() != null){
            where = TituloPagarSpecification.addClausula(where, TituloPagarSpecification.byIdFormaPagamentoSpecification(cp.getFormaPagamento().getIdFormaPagamento()));
        }
        if(cp.getTipoLancamento() != null){
            where = TituloPagarSpecification.addClausula(where, TituloPagarSpecification.byIdTipoLancamentoSpecification(cp.getTipoLancamento().getIdTipoLancamento()));
        }
        if(cp.getFornecedor() != null){
            if(cp.getFornecedor().getIdFornecedor() > 0){
                
                where = TituloPagarSpecification.addClausula(where, TituloPagarSpecification.byIdFornecedorSpecification(cp.getFornecedor().getIdFornecedor()));
            
            }else if(!cp.getFornecedor().getCpf().isEmpty() || !cp.getFornecedor().getCpf().isBlank()){
                
                where = TituloPagarSpecification.addClausula(where, TituloPagarSpecification.byCpfFornecedorSpecification(cp.getFornecedor().getCpf()));
            
            }else if(!cp.getFornecedor().getCnpj().isEmpty() || !cp.getFornecedor().getCnpj().isBlank()){
                
                where = TituloPagarSpecification.addClausula(where, TituloPagarSpecification.byCnpjFornecedorSpecification(cp.getFornecedor().getCnpj()));
            
            }else if(!cp.getFornecedor().getInscricaoEstadual().isEmpty() || !cp.getFornecedor().getInscricaoEstadual().isBlank()){
                
                where = TituloPagarSpecification.addClausula(where, TituloPagarSpecification.byInscricaoEstadualFornecedorSpecification(cp.getFornecedor().getInscricaoEstadual()));
            
            }else if(!cp.getFornecedor().getRazaoSocial().isEmpty() || !cp.getFornecedor().getRazaoSocial().isBlank()){
                
                where = TituloPagarSpecification.addClausula(where, TituloPagarSpecification.byRazaoSocialFornecedorSpecification(cp.getFornecedor().getRazaoSocial()));
            
            }else if(!cp.getFornecedor().getNomeFantasia().isEmpty() || !cp.getFornecedor().getNomeFantasia().isBlank()){
                
                where = TituloPagarSpecification.addClausula(where, TituloPagarSpecification.byNomeFantasiaFornecedorSpecification(cp.getFornecedor().getNomeFantasia()));
            
            }
            
        }          
        return repository.findAll(where);
    }

    @Override
    public Optional<TituloPagar> save(TituloPagar cp) {
        
        cp.setDataLancamento(new Date());
        cp.setExcluido(false);
        
        if(cp.getDataInclusao() != null){
            return null;
        }       
        if(cp.getValorTotal() <= 0){
            return null;
        }
        if(cp.getTipoLancamento() == null){
            return null;
        }
        if(cp.getFormaPagamento() == null){
            return null;
        }
        if(cp.getCondicaoPagamento() == null){
            return null;
        }
        if(cp.getFornecedor() == null){
            return null;
        }
               
        var temp = repository.save(cp);
        
        for(ParcelaPagar tempParcela : temp.getParcelasPagar()){
            tempParcela.setTituloPagar(temp);
        }
        
        this.parcelaRepository.saveAll(temp.getParcelasPagar());
        
        return repository.findById(temp.getIdTituloPagar());        
    }
        
    public TituloPagar apagarParcelas(TituloPagar cp){
        for(var temp : cp.getParcelasPagar()){
            parcelaRepository.delete(temp);
        }
        cp.getParcelasPagar().clear();
        return cp;
    }
    
    public TituloPagar gerarParcelas(TituloPagar cp){
        

        double valorParcela = cp.getValorTotal() / cp.getCondicaoPagamento().getQuantidadeVezes();

        Calendar dataVencimento = Calendar.getInstance();
        dataVencimento.setTime(new Date());

        for(int i = 0 ; i < cp.getCondicaoPagamento().getQuantidadeVezes(); i++){

            dataVencimento.add(Calendar.DAY_OF_MONTH, cp.getCondicaoPagamento().getDiasParcelas().get(i).getDiasParcelas());

            ParcelaPagar parcela = new ParcelaPagar();

            parcela.setDataVencimento           (dataVencimento.getTime());
            parcela.setParcela                  ("Parc Nº" + (i+1));

            parcela.setPercentualJuro           (cp.getCondicaoPagamento().getJuros());
            parcela.setPercentualDesconto       (cp.getCondicaoPagamento().getDesconto());

            parcela.setValorOriginal            (valorParcela);
            parcela.setValorJuro                (parcela.getPercentualJuro()*valorParcela);
            parcela.setValorDesconto            (parcela.getPercentualDesconto()*valorParcela);

            parcela.setValorPagar               (   parcela.getValorOriginal()
                                                    -parcela.getValorDesconto()
                                                    +parcela.getValorJuro());
            parcela.setExcluido(false);
            cp.getParcelasPagar().add(parcela);
        }
        
        return cp;
    }
   /* @Override
    public Optional<TituloPagar> update(TituloPagar cp, long id) {
        return repository.findById(id)
                 .map((record) ->{
                        record.setFormaPagamento(cp.getFormaPagamento());

                     
                     TituloPagar updated = repository.save(record);
                     return updated;
                 
                 });        
    }*/

    @Override
    public boolean delete(long id) {
        if(id <= 0){
            var temp = repository.findById(id).get();
            temp = apagarParcelas(temp);
            repository.delete(temp);
            return true;
            
        }else{
            return false;
        }
    }
    
}
