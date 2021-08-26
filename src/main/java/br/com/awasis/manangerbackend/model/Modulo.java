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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
import lombok.ToString;
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
@Table(name = "tb_modulo")
@SQLDelete(sql = "update tb_modulo set excluido = true where id_modulo = ?")
@Where(clause = "excluido = false")
public class Modulo {
    
    
    public enum TipoModulo {
    COMPRAS,
    VENDAS,
    FINANCEIRO,
    CONFIG,
    FATURAMENTO,
    EXPEDICAO,
    CRIACAO,
    CONTABILIDADE,
    PCP;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_modulo")
    private long idModulo;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_role")
    @JsonIgnore @ToString.Exclude
    private Role role;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo", fetch = FetchType.LAZY)
    private List<Permissao> permissoes;
    
    @Column(columnDefinition = "ENUM('COMPRAS', 'VENDAS', 'FINANCEIRO', 'CONFIG', 'FATURAMENTO', 'EXPEDICAO', 'CRIACAO', 'CONTABILIDADE', 'PCP')")
    @Enumerated(EnumType.STRING)
    private TipoModulo descricao;
    
    private boolean excluido;
    
    
}
