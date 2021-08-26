/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.repository;

import br.com.awasis.manangerbackend.model.ItemPedidoVenda;
import br.com.awasis.manangerbackend.model.Liberador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alecsander
 */

@Repository
public interface LiberadorRepository extends JpaRepository<Liberador, Long>, JpaSpecificationExecutor<Liberador>{
    
}
