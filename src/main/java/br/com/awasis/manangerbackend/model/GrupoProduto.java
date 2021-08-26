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
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_grupo_produto")
@SQLDelete(sql = "update tb_grupo_produto set excluido = true where id_grupo_produto = ?")
@Where(clause = "excluido = false")
public class GrupoProduto {

    @OneToMany(mappedBy = "grupoProduto")
    @JsonIgnore @ToString.Exclude
    private List<Referencia> referencias;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo_produto")
    private long idGrupoProduto;
    
    @OneToMany(mappedBy = "grupoProduto")
    @JsonIgnore @ToString.Exclude
    private List<SubgrupoProduto> subgrupoProdutos;
    
    private String descricao;
    
    private boolean ativo;
    
    private boolean excluido;
}
