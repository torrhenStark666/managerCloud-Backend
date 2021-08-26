/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.repository;

import br.com.awasis.manangerbackend.model.ItemAutorizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author alecsander
 */
public interface ItemAutorizadoRepository extends JpaSpecificationExecutor<ItemAutorizado>, JpaRepository<ItemAutorizado, Long>{
    
}
