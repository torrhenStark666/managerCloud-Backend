/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.repository.SearchRepository;

import java.util.HashMap;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alecsander
 * @param <T>
 */
public interface SearchRepository<T>{
    public List<T> findByProperties(HashMap<String,String> where,  T objeto);
}
