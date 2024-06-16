package com.example.demo_ktra_9th4.repository;

import com.example.demo_ktra_9th4.entity.Ban;
import com.example.demo_ktra_9th4.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BanRepoSi {
    private Session hSession = HibernateUtil.getFACTORY().openSession();
    public List<Ban> getAll (){
        String hql = "select entity from Ban entity";
        Query q = hSession.createQuery(hql , Ban.class);
        return q.getResultList();
    }

    public Ban findByid(int id){
        return hSession.find(Ban.class , id);
    }
}
