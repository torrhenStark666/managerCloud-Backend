/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.repository;

import br.com.awasis.manangerbackend.model.Cor;
import br.com.awasis.manangerbackend.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author Alecsander
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Long>, JpaSpecificationExecutor<Cor>{
    
}