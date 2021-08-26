/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="tb_regiao")
@SQLDelete(sql = "update tb_regiao set excluido = true where id_regiao = ?")
@Where(clause = "excluido = false")
public class Regiao {

    @ManyToMany(mappedBy = "regioes")
    private List<TabelaPreco> tabelaPrecos;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_regiao")
    private long idRegiao;
    
    @ManyToMany
    @JoinTable(name = "tb_regiao_regra_negocio", 
            joinColumns = {
                @JoinColumn(name = "id_regiao",
                            referencedColumnName = "id_regiao")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_regra_negocio",
                            referencedColumnName = "id_regra_negocio")}
            )
    private List<RegraNegocio> regrasNegocio;
    
    @OneToMany(mappedBy = "regiao")
    private List<Zona> zonas;
    
    private String descricao;
    
    private boolean excluido;
    
}
