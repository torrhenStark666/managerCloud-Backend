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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Alecsander
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="tb_produto")
@SQLDelete(sql = "update tb_produto set excluido = true where id_produto = ?")
@Where(clause = "excluido = false")
public class Produto {
    
    public enum TipoConversor{
        MULTIPLICAR,
        DIVIDIR,
        SOMAR,
        SUBTRAIR;
    }
    
    public enum TipoCalculoValor{
        MEDIO,
        MAIOR_VALOR,
        MENOR_VALOR;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_produto")
    private long idProduto;
    
    @ManyToOne
    @JoinColumn(name="id_tipo_produto")
    private TipoProduto tipoProduto;
    
    @ManyToOne
    @JoinColumn(name="id_grupo_produto")
    private GrupoProduto grupoProduto;
    
    @ManyToOne
    @JoinColumn(name="id_subgrupo_produto")
    private SubgrupoProduto subGrupoProduto;
    
    @ManyToMany
    @JoinTable(name = "tb_produto_fornecedor", 
            joinColumns = {
                @JoinColumn(name = "id_produto",
                            referencedColumnName = "id_produto")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_fornecedor",
                            referencedColumnName = "id_fornecedor")}
            )
    private List<Fornecedor> fornecedores;
    
    @ManyToMany
    @JoinTable(name="tb_produto_cor",
                joinColumns = {
                @JoinColumn(name = "id_produto",
                            referencedColumnName = "id_produto")},
            inverseJoinColumns = {
                @JoinColumn(name=   "id_cor",
                            referencedColumnName = "id_cor")}
            )
    private List<Cor> cores;    
    
    @Transient
    private long contaContabil;

    private String descricao;
    
    @Column(name="unidade_medida")
    private String unidadeMedida;
    
    @Column(name="unidade_medida2")
    private String unidadeMedidaTwo;
    
    @Column(name="conversor_abudade", columnDefinition = "ENUM('MULTIPLICAR', 'DIVIDIR', 'SOMAR', 'SUBTRAIR')")
    @Enumerated(EnumType.STRING)
    private TipoConversor conversoAbudade;
    
    @Column(name="fator_conversor")
    private Double fatorConversor;
    
    @Column(name="codigo_barras_fornecedor")
    private String codigoBarrasFornecedor;
    
    @Column(name="codigo_barras")
    private String codigoBarras;
    
    private double peso;
    
    private double altura;
    
    private double largura;
    
    @Column(name="quantidade_max")
    private double quantidadeMax;
    
    @Column(name="quantidade_min")
    private double quantidadeMin;
    
    @Column(name="ponto_pedido")
    private double pontoPedido;
    
    @Column(name="lote_economico")
    private double loteEconomico;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_ultima_compra")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataUltimaCompra;
    
    private double pontuacao;
    
    @Column(name="calculo_valor", columnDefinition = "ENUM('MEDIO', 'MAIOR_VALOR', 'MENOR_VALOR')")
    @Enumerated(EnumType.STRING)
    private TipoCalculoValor  calculoValor;
    
    
    private Double valor;
    
    private boolean excluido;

    
}
