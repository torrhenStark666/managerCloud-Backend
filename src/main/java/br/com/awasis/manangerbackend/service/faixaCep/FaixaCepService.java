/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.faixaCep;

import br.com.awasis.manangerbackend.model.FaixaCep;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface FaixaCepService {

    public Optional findById(long id);
    public List findAll();
    public List find(FaixaCep cp);
    public FaixaCep save(FaixaCep cp);
    public Optional<FaixaCep> update(FaixaCep cp, long id);
    public boolean delete(long id);  
    
}
