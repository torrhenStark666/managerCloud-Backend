/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.fornecedor;

import br.com.awasis.manangerbackend.model.Endereco;
import br.com.awasis.manangerbackend.model.Endereco_;
import br.com.awasis.manangerbackend.model.Fornecedor;
import br.com.awasis.manangerbackend.model.Fornecedor_;
import br.com.awasis.manangerbackend.model.GrupoFornecedor;
import br.com.awasis.manangerbackend.model.GrupoFornecedor_;
import br.com.awasis.manangerbackend.model.TipoFornecedor;
import br.com.awasis.manangerbackend.model.TipoFornecedor_;
import java.util.Date;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author alecsander
 */

public class FornecedorSpecification {
    
    
    // Filtro do telefone
    public static Specification<Fornecedor> byTelefoneFixo(String telefoneFixo){
          return (root, query, builder) ->{
              Predicate equalPredicate = builder.like(root.get(Fornecedor_.telefoneFixo), "%"+telefoneFixo.trim()+"%");
              return  equalPredicate;
              
        };
    }    
    // Filtro do celular
    public static Specification<Fornecedor> byCelular(String celular){
          return (root, query, builder) ->{
              Predicate equalPredicate = builder.like(root.get(Fornecedor_.celular), "%"+celular.trim()+"%");
              return  equalPredicate;
              
        };
    }
    // Filtro do Nome Fantasia
    public static Specification<Fornecedor> byNomeFantasia(String nomeFantasia){
          return (root, query, builder) ->{
              Predicate equalPredicate = builder.like(root.get(Fornecedor_.nomeFantasia), "%"+nomeFantasia.trim()+"%");
              return  equalPredicate;
              
        };
    }
    // Filtro da Razao Social
    public static Specification<Fornecedor> byRazaosocial(String razaoSocial){
          return (root, query, builder) ->{
              Predicate equalPredicate = builder.like(root.get(Fornecedor_.razaoSocial), "%"+razaoSocial.trim()+"%");
              return  equalPredicate;
              
        };
    }    
    // Filtro da Inscriçao Estadual
    public static Specification<Fornecedor> byInscricaoEstadual(String inscricaoEstadual){
          return (root, query, builder) ->{
              Predicate equalPredicate = builder.equal(root.get(Fornecedor_.inscricaoEstadual),"%"+ inscricaoEstadual.trim()+"%");
              return  equalPredicate;
              
        };
    }
    // Filtro da Pontuaçao
    public static Specification<Fornecedor> byPontuacao(double pontuacao){
          return (root, query, builder) ->{
              Predicate equalPredicate = builder.equal(root.get(Fornecedor_.pontuacao), pontuacao);
              return  equalPredicate;
              
        };
    }
    // Filtro da Ultima da de Compra
    public static Specification<Fornecedor> byDataUltimaCompra(Date dataUltimaCompra){
          return (root, query, builder) ->{
              Predicate equalPredicate = builder.equal(root.get(Fornecedor_.dataUltimaCompra), dataUltimaCompra);
              return  equalPredicate;
              
        };
    }
    // Filtro do CNPJ
    public static Specification<Fornecedor> byCnpj(String cnpj){
          return (root, query, builder) ->{
              Predicate equalPredicate = builder.equal(root.get(Fornecedor_.cnpj), "%"+cnpj.trim()+"%");
              return  equalPredicate;
              
        };
    }
    // Filtro do CPF
    public static Specification<Fornecedor> byCpf(String cpf){
          return (root, query, builder) ->{
              Predicate equalPredicate = builder.equal(root.get(Fornecedor_.cpf), "%"+cpf.trim()+"%");
              return  equalPredicate;
              
        };
    }
    // Filtro do ID
    public static Specification<Fornecedor> byId(long id){
          return (root, query, builder) ->{
              Predicate equalPredicate = builder.equal(root.get(Fornecedor_.idFornecedor), id);
              return  equalPredicate;
              
        };
    }
    //Filtrar por tipo
    public static Specification<Fornecedor> byTipoFornecedor(TipoFornecedor tipoFornecedor){
          return (root, query, builder) ->{
              Predicate equalPredicate = builder.equal(root.get(Fornecedor_.tipoFornecedor), tipoFornecedor);
              return  equalPredicate;
              
        };
    }
    // Filtrar por descricao do tipo de fornecedor
    public static Specification<Fornecedor> byDescricaoTipoFornecedor(String descricao){
          return (Root<Fornecedor> root, CriteriaQuery<?> query,CriteriaBuilder builder) -> {
              Join<Fornecedor, TipoFornecedor> tipoFornecedorJoin = root.join(Fornecedor_.tipoFornecedor);
              Predicate equalPredicate = builder.equal(tipoFornecedorJoin.get(TipoFornecedor_.descricao), "%"+descricao.trim()+"%");

              return  equalPredicate;
              
        };
    }
    // Filtrar por grupo
    public static Specification<Fornecedor> byGrupoFornecedor(GrupoFornecedor grupoFornecedor){
          return (root, query, builder) ->{
              Predicate equalPredicate = builder.equal(root.get(Fornecedor_.grupoFornecedor), grupoFornecedor);
              return  equalPredicate;
              
        };
    }
    
    // Filtrar por descricao do Grupo de fornecedor
    public static Specification<Fornecedor> byDescricaoGrupoFornecedor(String descricao){
          return (Root<Fornecedor> root, CriteriaQuery<?> query,CriteriaBuilder builder) -> {
              Join<Fornecedor, GrupoFornecedor> tipoFornecedorJoin = root.join(Fornecedor_.grupoFornecedor);
              Predicate equalPredicate = builder.equal(tipoFornecedorJoin.get(GrupoFornecedor_.descricao), "%"+descricao.trim()+"%");
              return  equalPredicate;
              
        };
    }
    
    //Filtrar por cidade
    public static Specification<Fornecedor> byCidadeFornecedor(String municipio){
          return (Root<Fornecedor> root, CriteriaQuery<?> query,CriteriaBuilder builder) -> {
              Join<Fornecedor, Endereco> enderecoJoin = root.join(Fornecedor_.endereco);
              Predicate equalPredicate = builder.like(enderecoJoin.get(Endereco_.municipio), "%"+municipio.trim()+"%");

              return  equalPredicate;
              
        };
    }
    // Filtro estado do fornecedor
    public static Specification<Fornecedor> byEstadoFornecedor(String estado){
          return (Root<Fornecedor> root, CriteriaQuery<?> query,CriteriaBuilder builder) -> {
              Join<Fornecedor, Endereco> enderecoJoin = root.join(Fornecedor_.endereco);
              Predicate equalPredicate = builder.like(enderecoJoin.get(Endereco_.estado), "%"+estado.trim()+"%");

              return  equalPredicate;
              
        };
    }   
    // Filtro endereco do fornecedor
    public static Specification<Fornecedor> byEnderecoFornecedor(String endereco){
          return (Root<Fornecedor> root, CriteriaQuery<?> query,CriteriaBuilder builder) -> {
              Join<Fornecedor, Endereco> enderecoJoin = root.join(Fornecedor_.endereco);
              Predicate equalPredicate = builder.like(enderecoJoin.get(Endereco_.endereco), "%"+endereco.trim()+"%");

              return  equalPredicate;
              
        };
          
    }   
    // Filtro cep do fornecedor
    public static Specification<Fornecedor> byCepFornecedor(long cep){
          return (Root<Fornecedor> root, CriteriaQuery<?> query,CriteriaBuilder builder) -> {
              Join<Fornecedor, Endereco> enderecoJoin = root.join(Fornecedor_.endereco);
              Predicate equalPredicate = builder.equal(enderecoJoin.get(Endereco_.cep), cep);

              return  equalPredicate;
              
        };
    }      
}
