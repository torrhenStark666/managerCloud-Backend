/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name="tb_setor")
@SQLDelete(sql = "update tb_setor set excluido = true where id_setor = ?")
@Where(clause = "excluido = false")
public class Setor {

    @ManyToMany(mappedBy = "setores")
    @JsonIgnore
    private List<TabelaPreco> tabelaPrecos;
    
    @ManyToOne
    @JoinColumn(name = "id_zona")
    private Zona zona;
    
    @ManyToMany
    @JoinTable(name = "tb_setor_regra_negocio", 
            joinColumns = {
                @JoinColumn(name = "id_setor",
                            referencedColumnName = "id_setor")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_regra_negocio",
                            referencedColumnName = "id_regra_negocio")}
            )
    @JsonIgnore
    private List<RegraNegocio> regrasNegocio;
    
    @ManyToOne
    @JoinColumn(name = "id_faixa_cep")
    private FaixaCep faixaCep;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_setor")
    private long idSetor;
    
    private String descricao;
    
    private boolean ativo;
    
    private boolean excluido;
    
}
