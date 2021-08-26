/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author Alecsander
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tb_colecao")
@SQLDelete(sql = "update tb_colecao set excluido = true where tb_colecao = ?")
@Where(clause = "excluido = false")
public class Colecao {

    @OneToMany(mappedBy = "colecao")
    private List<Referencia> referencias;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_colecao")
    private long idColecao;
    
    private String descricao;
    
    @Column(name="quantidade_prevista")
    private long quantidadePrevista;
    
    @Column(name="quantidade_vendida")
    private long quantidadeVendida;
    
    @Column(name="data_inicio_colecao")
    private Date dataInicioColecao;
    
    @Column(name="data_fim_colecao")
    private Date dataFimColecao;
    
    @Column(name="data_inicio_producao")
    private Date dataInicioProducao;
    
    @Column(name="data_fim_producao")
    private Date dataFimProducao;
    
    private boolean ativo;
    
    private boolean excluido;
}
