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
import javax.persistence.ManyToOne;
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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tb_subgrupo_produto")
@SQLDelete(sql = "update tb_subgrupo_produto set excluido = true where id_subgrupo_produto = ?")
@Where(clause = "excluido = false")
public class SubgrupoProduto {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subgrupo_produto")
    private long idSubgrupoProduto;
    
    @ManyToOne
    @JoinColumn(name = "id_grupo_produto")
    private GrupoProduto grupoProduto;
    
    private String descricao;
    
    private boolean ativo;
    
    private boolean excluido;
    
}
