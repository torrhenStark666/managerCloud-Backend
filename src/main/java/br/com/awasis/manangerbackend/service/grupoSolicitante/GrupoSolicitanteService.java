/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.grupoSolicitante;

import br.com.awasis.manangerbackend.model.GrupoSolicitante;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface GrupoSolicitanteService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(GrupoSolicitante cp);
    public GrupoSolicitante save(GrupoSolicitante cp);
    public Optional<GrupoSolicitante> update(GrupoSolicitante cp, long id);
    public boolean delete(long id);  
    
}
