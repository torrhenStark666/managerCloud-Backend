/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.awasis.manangerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author alecsander
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tb_transportadora")
@SQLDelete(sql = "update tb_transportadora set excluido = true where id_transportadora = ?")
@Where(clause = "excluido = false")
public class Transportadora {

    @OneToMany(mappedBy = "transportadora")
    @JsonIgnore
    private List<PedidoVenda> pedidoVendas;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_transportadora")
    private long idTransportadora;
    
    @ManyToMany
    @JoinTable(name = "tb_transportadora_contato", 
            joinColumns = {
                @JoinColumn(name = "id_transportadora",
                            referencedColumnName = "id_transportadora")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_contato",
                            referencedColumnName = "id_contato")}
            )
    @JsonIgnore
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
    
    @Column(name="telefone_fixo")
    private String telefoneFixo;
    
    private String celular;
    
    private boolean excluido;
    

}
