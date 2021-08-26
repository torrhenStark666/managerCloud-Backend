/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.awasis.manangerbackend.model;

/**
 *
 * @author alecsander
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tb_compensacao")
@SQLDelete(sql = "update tb_regra_negocio set excluido = true where id_regra_negocio = ?")
@Where(clause = "excluido = false")
public class RegraNegocio {

    @ManyToMany(mappedBy = "regrasNegocio")
    @JsonIgnore
    private List<Cliente> clientes;

    @ManyToMany(mappedBy = "regrasNegocio")
    @JsonIgnore
    private List<Zona> zonas;

    @ManyToMany(mappedBy = "regrasNegocio")
    @JsonIgnore
    private List<Regiao> regioes;

    @ManyToMany(mappedBy = "regrasNegocio")
    @JsonIgnore
    private List<Setor> setores;
    
    @ManyToMany(mappedBy = "regrasNegocio")
    @JsonIgnore
    private List<Referencia> referencias;
            
    @OneToMany(mappedBy = "regraNegocio")
    private List<TabelaPreco> tabelaPreco;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_regra_negocio")
    private long idRegraNegocio;

    @Column(name="preco_one")
    private double precoOne;
    
    @Column(name="preco_two")
    private double precoTwo;
    
    @Column(name="preco_three")
    private double precoThree;
    
    @Column(name="desconto_referencia")
    private double descontoReferencia;
    
    @Column(name="comissao_referencia")
    private double comissaoReferencia;
    
    private boolean ativo;
    
    private boolean excluido;
}
