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
@Table(name="tb_grade")
@SQLDelete(sql = "update tb_grade set excluido = true where id_grade = ?")
@Where(clause = "excluido = false")
public class Grade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_grade")
    private long idGrade;
    
    @OneToMany
    @JoinColumn(name="id_tamanho")
    private List<Tamanho> tamanhos;
    
    @OneToMany
    @JoinColumn(name="id_preco")
    private List<Preco> precos;
    
    private String descricao;
    
    private boolean ativo;
    
    private boolean excluido;
    
}
