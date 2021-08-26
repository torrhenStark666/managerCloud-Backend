/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.regranegocio;

import br.com.awasis.manangerbackend.model.RegraNegocio;
import br.com.awasis.manangerbackend.model.Segmento;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface RegraNegocioService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(RegraNegocio cp);
    public RegraNegocio save(RegraNegocio cp);
    public Optional<RegraNegocio> update(RegraNegocio cp, long id);
    public boolean delete(long id);     
    
}
