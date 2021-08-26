
package br.com.awasis.manangerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "tb_condicao_pagamento")
@SQLDelete(sql = "update tb_condicao_pagamento set excluido = true where id_condicao_pagamento = ?")
@Where(clause = "excluido = false")
public class CondicaoPagamento {
    
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "condicaoPagamento")
    private List<DiasParcelas> diasParcelas;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_condicao_pagamento")
    private long idCondicaoPagamento;
    
    private String descricao;
    
    @Column(name="quantidade_vezes")
    private int quantidadeVezes;
    
    private double juros;
    
    private double desconto;
    
    @Column(name="prazo_medio")
    private int prazoMedio;
    
    @Column(name="contas_pagar_receber")
    private String contasPagarReceber;
    
    private boolean excluido;
    
}
