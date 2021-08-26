/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.awasis.manangerbackend.repository.SearchRepository;

import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public class SearchRepositoryImpl<T> implements SearchRepository<T> {
   

    @Override
    public List<T> findByProperties(HashMap<String,String> where, T objeto) {
        EntityManager em = null;
        
        CriteriaBuilder  builder = em.getCriteriaBuilder();

        return null;
    }
}
