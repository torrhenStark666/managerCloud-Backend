/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.produto;

import br.com.awasis.manangerbackend.model.Produto;
import br.com.awasis.manangerbackend.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProdutoServiceImpl implements ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(ProdutoSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAllProdutos();
    }

    @Override
    public List find(Produto cp) {
        Specification where = null;
        
        if(cp.getTipoProduto() !=  null){
            where = ProdutoSpecification
                    .addClausula(where, ProdutoSpecification
                            .byIdTipoSpecification(cp.getTipoProduto().getIdTipoProduto()));
        }
        if(cp.getGrupoProduto()!=  null){
            where = ProdutoSpecification
                    .addClausula(where, ProdutoSpecification
                            .byIdGrupoSpecification(cp.getGrupoProduto().getIdGrupoProduto()));
        }
        if(cp.getSubGrupoProduto()!=  null){
            where = ProdutoSpecification
                    .addClausula(where, ProdutoSpecification
                            .byIdSubGrupoSpecification(cp.getSubGrupoProduto().getIdSubgrupoProduto()));
        }
        if(cp.getValor()> 0){
            where = ProdutoSpecification
                    .addClausula(where, ProdutoSpecification
                            .byValorSpecification(cp.getValor()));
        }
        if(cp.getPeso()> 0){
            where = ProdutoSpecification
                    .addClausula(where, ProdutoSpecification
                            .byPesoSpecification(cp.getPeso()));
        }
        
       
        if(!cp.getUnidadeMedida().isBlank() || !cp.getUnidadeMedida().isEmpty()){
            where = ProdutoSpecification
                    .addClausula(where, ProdutoSpecification
                            .byUnidadeMedidaSpecification(cp.getUnidadeMedida()));
        }
        if(!cp.getUnidadeMedidaTwo().isBlank() || !cp.getUnidadeMedidaTwo().isEmpty()){
            where = ProdutoSpecification
                    .addClausula(where, ProdutoSpecification
                            .byUnidadeMedidaTwoSpecification(cp.getUnidadeMedidaTwo()));
        }
        if(!cp.getDescricao().isBlank() || !cp.getDescricao().isEmpty()){
            where = ProdutoSpecification
                    .addClausula(where, ProdutoSpecification
                            .byDescricaoSpecification(cp.getDescricao()));
        }
        
        if(!cp.getFornecedores().isEmpty() || cp.getFornecedores() != null){
            where = ProdutoSpecification
                    .addClausula(where, ProdutoSpecification
                            .byIdFornecedorSpecification(cp.getFornecedores()));
        }
        if(!cp.getCores().isEmpty() || cp.getCores() != null){
            where = ProdutoSpecification
                    .addClausula(where, ProdutoSpecification
                            .byIdCoresSpecification(cp.getCores()));
        }

        
        
        return repository.findAll(where);
    }

    @Override
    public Produto save(Produto cp) {
        
        if(cp.getTipoProduto() ==  null){
            return null;
        }
        if(cp.getGrupoProduto()==  null){
            return null;
        }
        if(cp.getSubGrupoProduto()==  null){
            return null;
        }
        /* 
        if(cp.getValor() <= 0){
            return null;
        }
        if(cp.getPeso() < 0){
            return null;
        }
        
        if(cp.getAltura() < 0){
            return null;
        }
        
        if(cp.getLargura()< 0){
            return null;
        }
        
        if(cp.getCodigoBarras() < 0){
            return null;
        }
        if(cp.getFatorConversor() < 0){
            return null;
        }
        if(!cp.getConversoAbudade().isBlank() || !cp.getConversoAbudade().isEmpty()){
            return null;
        }
        if(!cp.getUnidadeMedida().isBlank() || !cp.getUnidadeMedida().isEmpty()){
            return null;
        }
        if(!cp.getUnidadeMedidaTwo().isBlank() || !cp.getUnidadeMedidaTwo().isEmpty()){
            return null;
        }
        if(!cp.getDescricao().isBlank() || !cp.getDescricao().isEmpty()){
            return null;
        }
       
        if(!cp.getFornecedores().isEmpty() || cp.getFornecedores() != null){
            return null;
        }
        if(!cp.getCores().isEmpty() || cp.getCores() != null){
            return null;
        }
        */
        return repository.save(cp);
    }

    @Override
    public Optional<Produto> update(Produto cp, long id) {
        return repository.findById(id)
                .map(record ->{
                    
                    record.setAltura(cp.getAltura());
                    record.setCodigoBarras(cp.getCodigoBarras());
                    record.setCodigoBarrasFornecedor(cp.getCodigoBarrasFornecedor());
                    record.setConversoAbudade(cp.getConversoAbudade());
                    record.setDescricao(cp.getDescricao());
                    record.setFatorConversor(cp.getFatorConversor());
                    record.setDataUltimaCompra(cp.getDataUltimaCompra());
                    record.setGrupoProduto(cp.getGrupoProduto());
                    record.setTipoProduto(cp.getTipoProduto());
                    record.setSubGrupoProduto(cp.getSubGrupoProduto());
                    record.setFornecedores(cp.getFornecedores());
                    record.setCores(cp.getCores());
                    record.setCalculoValor(cp.getCalculoValor());
                    record.setValor(cp.getValor());
                    record.setUnidadeMedida(cp.getUnidadeMedida());
                    record.setUnidadeMedidaTwo(cp.getUnidadeMedidaTwo());
                    record.setLargura(cp.getLargura());
                    record.setPeso(cp.getPeso());
                    record.setQuantidadeMax(cp.getQuantidadeMax());
                    record.setQuantidadeMin(cp.getQuantidadeMin());
                    record.setLoteEconomico(cp.getLoteEconomico());
                    record.setPontoPedido(cp.getPontoPedido());
                    
                    return repository.save(record);
                });
    }

    @Override
    public boolean delete(long id) {
        if(id > 0){
            repository.deleteById(id);
            return true;
        }else return false;
    }
    
}
