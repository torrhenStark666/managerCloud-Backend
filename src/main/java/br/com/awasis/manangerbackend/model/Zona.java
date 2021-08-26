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
import javax.persistence.ManyToOne;
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
@Table(name="tb_zona")
@SQLDelete(sql = "update id_tipo_lancamento set excluido = true where id_tipo_lancamento = ?")
@Where(clause = "excluido = false")
public class Zona {

    @ManyToMany(mappedBy = "zonas")
    private List<TabelaPreco> tabelaPrecos;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona")
    private long idZona;
    
    @ManyToMany
    @JoinTable(name = "tb_zona_regra_negocio", 
            joinColumns = {
                @JoinColumn(name = "id_zona",
                            referencedColumnName = "id_zona")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_regra_negocio",
                            referencedColumnName = "id_regra_negocio")}
            )
    private List<RegraNegocio> regrasNegocio;
    
    @ManyToOne
    @JoinColumn(name = "id_regiao")
    private Regiao regiao;
    
    private String descricao;
    
    private boolean excluido;
    
}
