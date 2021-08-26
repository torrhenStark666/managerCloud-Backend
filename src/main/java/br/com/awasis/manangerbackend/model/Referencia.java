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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
@Table(name = "tb_referencia")
@SQLDelete(sql = "update tb_referencia set excluido = true where id_referencia = ?")
@Where(clause = "excluido = false")
public class Referencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_referencia")
    private long idReferencia;
    
    @ManyToMany
    @JoinTable(name = "tb_referencia_regra_negocio", 
            joinColumns = {
                @JoinColumn(name = "id_referencia",
                            referencedColumnName = "id_referencia")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_regra_negocio",
                            referencedColumnName = "id_regra_negocio")}
            )
    private List<RegraNegocio> regrasNegocio;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_produto")
    private TipoProduto tipoProduto;
    
    @ManyToOne
    @JoinColumn(name = "id_grupo_produto")
    private GrupoProduto grupoProduto;
    
    @Column(name = "id_conta_contabil")
    private long idContaContabil;
    
    
    @ManyToOne
    @JoinColumn(name = "id_subgrupo_produto")
    private SubgrupoProduto subgrupoProduto;
    
    @ManyToMany
    @JoinTable(name = "tb_referencia_cor", 
            joinColumns = {
                @JoinColumn(name = "id_referencia",
                            referencedColumnName = "id_referencia")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_cor",
                            referencedColumnName = "id_cor")}
            )
    private List<Cor> cores;
    
    @ManyToOne
    @JoinColumn(name = "id_colecao")
    private Colecao colecao;
    
    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;
    
    @ManyToOne
    @JoinColumn(name = "id_segmento")
    private Segmento segmento;
    
    @ManyToOne
    @JoinColumn(name = "id_grade")
    private Grade grade;
    
    @ManyToOne
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;
    
    @OneToOne
    @JoinColumn(name = "id_imagem")
    private Imagem imagem;
    
    @Column(name = "data_validade_inicio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataValidadeInicio;
    
    @Column(name="data_validade_fim")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataValidadeFim;
    
    private String descricao;
    
    @Column(name ="unidade_medida")
    private int unidadeMedida;
    
    @Column(name = "unidade_medida2")
    private int unidadeMedida2;
    
    @Column(name = "conversor_abudade")
    private String conversorAbudade;
    
    @Column(name = "fator_conversor")
    private String fatorConversor;
    
    @Column(name = "codigo_barras")
    private long codigoBarras;
    
    private double peso;
    
    private double altura;
    
    private double largura;
    
    @Column(name = "data_ultima_compra")
    private Date dataUltimaCompra;
    
    private double pontuacao;
    
    private double valor;
    
    private boolean ativo;
    
    private boolean excluido;
    
}
