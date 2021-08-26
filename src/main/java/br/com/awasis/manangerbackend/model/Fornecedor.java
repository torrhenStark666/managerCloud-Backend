/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author Alecsander
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tb_fornecedor")
@SQLDelete(sql = "update tb_fornecedor set excluido = true where id_fornecedor = ?")
@Where(clause = "excluido = false")
public class Fornecedor {

    @OneToMany(mappedBy = "fornecedor")
    @JsonIgnore @ToString.Exclude
    private List<PedidoCompra> pedidos;

    @ManyToMany(mappedBy = "fornecedores")
    @JsonIgnore @ToString.Exclude
    private List<Produto> produtos;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_fornecedor")
    private long idFornecedor;
    
    @ManyToOne
    @JoinColumn(name="id_grupo_fornecedor")
    private GrupoFornecedor grupoFornecedor;
    
    @ManyToOne
    @JoinColumn(name="id_tipo_fornecedor")
    private TipoFornecedor tipoFornecedor;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_fornecedor_contato", 
            joinColumns = {
                @JoinColumn(name = "id_fornecedor",
                            referencedColumnName = "id_fornecedor")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_contato",
                            referencedColumnName = "id_contato")}
            )
    private List<Contato> contatos;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_endereco")
    private Endereco endereco;
    
    @Column(name="razao_social")
    private String razaoSocial;
    
    @Column(name="nome_fantasia")
    private String nomeFantasia;
    
    private String cnpj;
    
    private String cpf;
    
    @Column(name="inscricao_estadual")
    private String inscricaoEstadual;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_ultima_compra")
    private Date dataUltimaCompra;
    
    private double pontuacao;
    
    @Column(name="telefone_fixo")
    private String telefoneFixo;
    
    private String celular;
    
    private boolean excluido;
}
