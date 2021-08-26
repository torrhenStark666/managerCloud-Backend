/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.role;

import br.com.awasis.manangerbackend.model.Role;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alecsander
 */
public interface RoleService {
    
    public Optional findById(long id);
    public List findAll();
    public List find(Role cp);
    public Role save(Role cp);
    public Optional<Role> update(Role cp, long id);
    public boolean delete(long id);
    
}
