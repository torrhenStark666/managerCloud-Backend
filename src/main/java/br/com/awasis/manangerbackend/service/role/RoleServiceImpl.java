/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.role;

import br.com.awasis.manangerbackend.model.DiasParcelas;
import br.com.awasis.manangerbackend.model.Modulo;
import br.com.awasis.manangerbackend.model.Permissao;
import br.com.awasis.manangerbackend.model.Role;
import br.com.awasis.manangerbackend.repository.RoleRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleRepository repository;

    @Override
    public Optional findById(long id) {
        return repository.findOne(RoleSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Role cp) {
        Specification where = null;
        
        if(!cp.getDescricao().isEmpty() || !cp.getDescricao().isBlank() || cp.getDescricao() != null){
            where = RoleSpecification.byDescricaoSpecification(cp.getDescricao());
        }
        
        
        return repository.findAll(where);
    }

    @Override
    public Role save(Role cp) {
        if(cp.getModulos() != null){
            Role temp = repository.save(cp);

            for(Modulo moduloTemp : temp.getModulos()){
                
                for(Permissao permissaoTemp : moduloTemp.getPermissoes()){
                    permissaoTemp.setModulo(moduloTemp);
                }
                
                moduloTemp.setRole(temp);
            }

            return repository.save(temp);       
        }else return null;
    }

    @Override
    public Optional<Role> update(Role cp, long id) {
                return repository.findById(id)
                .map((Role record)->{
                    record.setDescricao(cp.getDescricao());
                    record.setAtivo(cp.isAtivo());
                    for(Modulo moduloTemp : record.getModulos()){
                
                        for(Permissao permissaoTemp : moduloTemp.getPermissoes()){
                            permissaoTemp.setModulo(moduloTemp);
                        }

                        moduloTemp.setRole(record);
                    }
                    
                    Role updated = repository.save(record);
                    return updated;
                });
    }

    @Override
    public boolean delete(long id) {
        if(id > 0){
            var temp = repository.findById(id).get();
            
            for(Modulo moduloTemp : temp.getModulos()){
                
                for(Permissao permissaoTemp : moduloTemp.getPermissoes()){
                    permissaoTemp.setExcluido(true);
                }
                
                moduloTemp.setExcluido(true);
            }
            repository.deleteById(id);
            return true;
        }else return false;
    }
    
}
