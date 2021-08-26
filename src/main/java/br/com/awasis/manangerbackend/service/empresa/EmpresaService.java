/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.empresa;

import br.com.awasis.manangerbackend.model.Empresa;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Alecsander
 */
public interface EmpresaService {
    public Optional findById(long id);
    public List findAll();
    public List find(Empresa cp);
    public Empresa save(Empresa cp);
    public Optional<Empresa> update(Empresa cp, long id);
    public boolean delete(long id); 
}
