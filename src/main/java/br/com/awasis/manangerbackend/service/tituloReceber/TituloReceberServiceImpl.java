/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.tituloReceber;

import br.com.awasis.manangerbackend.model.ParcelaReceber;
import br.com.awasis.manangerbackend.model.TituloReceber;
import br.com.awasis.manangerbackend.repository.ParcelaReceberRepository;
import br.com.awasis.manangerbackend.repository.TituloReceberRepository;
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
public class TituloReceberServiceImpl implements TituloReceberService {

    private TituloReceberRepository repository;
    private ParcelaReceberRepository parcelaRepository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(TituloReceberSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(TituloReceber cp) {
        Specification where = null;
        
        if(cp.getDataInclusao() != null){
            where = TituloReceberSpecification.addClausula(where, TituloReceberSpecification.byDataInclusaoSpecification(cp.getDataInclusao()));
        }
        if(cp.getDataLancamento() != null){
            where = TituloReceberSpecification.addClausula(where, TituloReceberSpecification.byDataLancamentoSpecification(cp.getDataLancamento()));
        }
        if(cp.getCondicaoPagamento() != null){
            where = TituloReceberSpecification.addClausula(where, TituloReceberSpecification.byIdCondicaoPagamentoSpecification(cp.getCondicaoPagamento().getIdCondicaoPagamento()));
        }
        if(cp.getFormaPagamento() != null){
            where = TituloReceberSpecification.addClausula(where, TituloReceberSpecification.byIdFormaPagamentoSpecification(cp.getFormaPagamento().getIdFormaPagamento()));
        }
        if(cp.getTipoLancamento() != null){
            where = TituloReceberSpecification.addClausula(where, TituloReceberSpecification.byIdTipoLancamentoSpecification(cp.getTipoLancamento().getIdTipoLancamento()));
        }
        if(cp.getCliente()!= null){
            if(cp.getCliente().getIdCliente()> 0){
                
                where = TituloReceberSpecification.addClausula(where, TituloReceberSpecification.byIdClienteSpecification(cp.getCliente().getIdCliente()));
            
            }else if(!cp.getCliente().getCpf().isEmpty() || !cp.getCliente().getCpf().isBlank()){
                
                where = TituloReceberSpecification.addClausula(where, TituloReceberSpecification.byCpfClienteSpecification(cp.getCliente().getCpf()));
            
            }else if(!cp.getCliente().getCnpj().isEmpty() || !cp.getCliente().getCnpj().isBlank()){
                
                where = TituloReceberSpecification.addClausula(where, TituloReceberSpecification.byCnpjClienteSpecification(cp.getCliente().getCnpj()));
            
            }else if(!cp.getCliente().getInscricaoEstadual().isEmpty() || !cp.getCliente().getInscricaoEstadual().isBlank()){
                
                where = TituloReceberSpecification.addClausula(where, TituloReceberSpecification.byInscricaoEstadualClienteSpecification(cp.getCliente().getInscricaoEstadual()));
            
            }else if(!cp.getCliente().getRazaoSocial().isEmpty() || !cp.getCliente().getRazaoSocial().isBlank()){
                
                where = TituloReceberSpecification.addClausula(where, TituloReceberSpecification.byRazaoSocialClienteSpecification(cp.getCliente().getRazaoSocial()));
            
            }else if(!cp.getCliente().getNomeFantasia().isEmpty() || !cp.getCliente().getNomeFantasia().isBlank()){
                
                where = TituloReceberSpecification.addClausula(where, TituloReceberSpecification.byNomeFantasiaClienteSpecification(cp.getCliente().getNomeFantasia()));
            
            }
            
        }          
        return repository.findAll(where);
    }

    @Override
    public Optional save(TituloReceber cp) {
        
        cp.setDataInclusao(new Date());
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
        if(cp.getCliente() == null){
            return null;
        }
        
        if(cp.getParcelasReceber()== null){
            
            cp.setParcelasReceber(new ArrayList<>());
            cp = this.gerarParcelas(cp);
           
        }
        
        var temp = repository.save(cp);
        for(ParcelaReceber tempParcela : temp.getParcelasReceber()){
            tempParcela.setTituloReceber(temp);
            parcelaRepository.save(tempParcela);
        }
        
        return repository.findById(temp.getIdTituloReceber());          
    }
    
    public TituloReceber apagarParcelas(TituloReceber cp){
        for(var temp : cp.getParcelasReceber()){
            parcelaRepository.delete(temp);
        }
        cp.getParcelasReceber().clear();
        return cp;
    }
    
    public TituloReceber gerarParcelas(TituloReceber cp){
        

        double valorParcela = cp.getValorTotal() / cp.getCondicaoPagamento().getQuantidadeVezes();

        Calendar dataVencimento = Calendar.getInstance();
        dataVencimento.setTime(new Date());

        for(int i = 0 ; i < cp.getCondicaoPagamento().getQuantidadeVezes(); i++){

            dataVencimento.add(Calendar.DAY_OF_MONTH, cp.getCondicaoPagamento().getDiasParcelas().get(i).getDiasParcelas());

            ParcelaReceber parcela = new ParcelaReceber();

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
            cp.getParcelasReceber().add(parcela);
        }
        
        return cp;
    }
    
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
