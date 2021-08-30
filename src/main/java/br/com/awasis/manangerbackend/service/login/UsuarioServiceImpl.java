/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.service.login;

import br.com.awasis.manangerbackend.model.Role;
import br.com.awasis.manangerbackend.model.Usuario;
import br.com.awasis.manangerbackend.repository.LoginRepository;
import br.com.awasis.manangerbackend.service.empresa.EmpresaService;
import br.com.awasis.manangerbackend.service.role.RoleService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private LoginRepository repository;
    
    @Autowired
    private EmpresaService empresaService;
    
    @Autowired
    private RoleService roleService;
    
    @Override
    public Optional findById(long id) {
        return repository.findOne(UsuarioSpecification.byIdSpecification(id));
    }

    @Override
    public List findAll() {
        return repository.findAll();
    }

    @Override
    public List find(Usuario cp) {
        Specification where = null;
        
        if(!cp.getLogin().isEmpty() || !cp.getLogin().isBlank()){
            where = UsuarioSpecification.addClausula(where, UsuarioSpecification.byLoginSpecification(cp.getLogin()));
        }
        
        if(!cp.getSenha().isEmpty() || !cp.getSenha().isBlank()){
            where = UsuarioSpecification.addClausula(where, UsuarioSpecification.bySenhaSpecification(cp.getSenha()));
        }
        
        //where = LoginSpecification.addClausula(where, LoginSpecification.byAtivoSpecification(cp.isAtivo()));
        
        return repository.findAll(where);
    }
    
    @Override
    public Optional findLogin(String cp) {
        return repository.findOne(UsuarioSpecification.byLoginSpecification(cp));
    }
    @Override
    public Usuario save(Usuario cp) {
        if(cp.getLogin().isEmpty() || cp.getLogin().isBlank()){
            return null;
        }
        
        if(cp.getSenha().isEmpty() || cp.getSenha().isBlank()){
            return null;
        }
        
        if(cp.getEmpresa() == null){
            return null;
        }
        
        if(cp.getRole() == null){
            return null;
        }
        
        return repository.save(cp);
    }

    @Override
    public Optional<Usuario> update(Usuario cp, long id) {
        return repository.findById(id)
                .map(record ->{
                    if(cp.getLogin().isEmpty() || cp.getLogin().isBlank()){
                        return null;
                    }else{
                        record.setSenha(cp.getSenha());
                    }

                    if(cp.getSenha().isEmpty() || cp.getSenha().isBlank()){
                        return null;
                    }else{
                        record.setLogin(cp.getLogin());
                    }
                    
                    if(cp.getRole() == null){
                        return null;
                    }
                    record.setAtivo(cp.isAtivo());
                    record.setRole(cp.getRole());
                    
                    repository.save(record);
                    
                    
                    return repository.getOne(id);
                    
                });
    }

    @Override
    public boolean delete(long id) {
        if(id > 0 ){
            repository.deleteById(id);
            return true;
        }else return false;
    }

    @Override
    public Usuario signup(Usuario cp) {
        
        if(cp.getEmpresa() == null){
            return null;
        }
        
        if(cp.getEmpresa().getEndereco() == null){
            return null;
        }
        
        var empresa = empresaService.save(cp.getEmpresa());
        
        if(empresa == null){
            return null;
        }
        
        if(cp.getLogin() == null){
            return null;
        }
        
        if(cp.getSenha() == null){
            return null;
        }
        
        roleService.findById(1).map((record) ->{
            cp.setRole((Role) record);
            return record;
        });

        cp.setAtivo(true);
        cp.setEmpresa(empresa);
        
        return repository.save(cp);
    }


    
}
