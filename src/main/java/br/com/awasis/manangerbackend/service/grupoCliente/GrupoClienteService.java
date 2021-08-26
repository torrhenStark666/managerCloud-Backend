/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.grupoCliente;

import br.com.awasis.manangerbackend.model.GrupoCliente;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface GrupoClienteService {

    public Optional findById(long id);
    public List findAll();
    public List find(GrupoCliente gf);
    public GrupoCliente save(GrupoCliente gf);
    public Optional<GrupoCliente> update(GrupoCliente gf, long id);
    public boolean delete(long id);
    
}
