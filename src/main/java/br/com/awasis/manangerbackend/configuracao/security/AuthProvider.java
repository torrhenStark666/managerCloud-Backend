/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.configuracao.security;

import br.com.awasis.manangerbackend.model.Usuario;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import br.com.awasis.manangerbackend.service.login.UsuarioService;

/**
 *
 * @author alecsander
 */

@AllArgsConstructor
@NoArgsConstructor
@Component
public class AuthProvider implements AuthenticationProvider{
    
    @Autowired
    private UsuarioService service;
    
    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        
        String username = a.getName();
        String senha = a.getCredentials().toString();
        
        Optional login = service.findLogin(username);
        if(!login.isEmpty()){
            
            if(((Usuario) login.get()).isAtivo()){
                
                if(((Usuario) login.get()).getSenha().equals(senha)){
                    return new UsernamePasswordAuthenticationToken(username, senha);
                }else{
                    throw new BadCredentialsException("Senha incorreta");
                }
                
            }else{
                throw new BadCredentialsException("Usuario nao esta ATIVO");
            }

        }else{
            throw new UsernameNotFoundException("Usuario invalido");
        }
        
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
    
}
