/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.awasis.manangerbackend.model;

import java.util.Date;
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
 * @author alecsander
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tb_tabela_preco")
@SQLDelete(sql = "update tb_tabela_preco set excluido = true where id_tabela_preco = ?")
@Where(clause = "excluido = false")
public class TabelaPreco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tabela_preco")
    private long idTabelaPreco;
    
    @ManyToOne
    @JoinColumn(name = "id_regra_negocio")
    private RegraNegocio regraNegocio;
    
    @ManyToMany
    @JoinTable(name = "tb_tabela_preco_representante", 
        joinColumns = {
            @JoinColumn(name = "id_tabela_preco",
                        referencedColumnName = "id_tabela_preco")},
        inverseJoinColumns = {
            @JoinColumn(name=   "id_representante",
                        referencedColumnName = "id_representante")}
    )
    private List<Representante> representantes;
    
    @ManyToMany
    @JoinTable(name = "tb_tabela_preco_setor", 
        joinColumns = {
            @JoinColumn(name = "id_tabela_preco",
                        referencedColumnName = "id_tabela_preco")},
        inverseJoinColumns = {
            @JoinColumn(name=   "id_setor",
                        referencedColumnName = "id_setor")}
    )
    private List<Setor> setores;
    
    @ManyToMany
    @JoinTable(name = "tb_tabela_preco_zona", 
        joinColumns = {
            @JoinColumn(name = "id_tabela_preco",
                        referencedColumnName = "id_tabela_preco")},
        inverseJoinColumns = {
            @JoinColumn(name=   "id_zona",
                        referencedColumnName = "id_zona")}
    )
    private List<Zona> zonas;
    
    @ManyToMany
    @JoinTable(name = "tb_tabela_preco_regiao", 
        joinColumns = {
            @JoinColumn(name = "id_tabela_preco",
                        referencedColumnName = "id_tabela_preco")},
        inverseJoinColumns = {
            @JoinColumn(name=   "id_regiao",
                        referencedColumnName = "id_regiao")}
    )
    private List<Regiao> regioes;
    
    @Column(name = "data_inicio")
    private Date dataInicio;
    
    @Column(name = "data_fim")
    private Date dataFim;
    
    @Column(name = "quantidade_minima")
    private int quantidadeMinima;
    
    @Column(name = "quantidade_maxima")
    private int quantidadeMaxima;
    
    @Column(name = "valor_minimo")
    private double valorMinimo;
    
    @Column(name = "valor_maximo")
    private double valorMaximo;
    
    private String descricao;
    
    private boolean ativo;

    private boolean excluido;
}
