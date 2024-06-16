package com.example.ktra_java4_30th3.repository;

import com.example.ktra_java4_30th3.model.HoaDon;
import com.example.ktra_java4_30th3.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HoaDonRepo {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<HoaDon> findALl(){
        String hql = "SELECT entity FROM HoaDon entity";
        Query q = hSession.createQuery(hql);

        return q.getResultList();
    }
    public void create(HoaDon hd){
        try {
            hSession.getTransaction().begin();
            hSession.merge(hd);
            hSession.getTransaction().commit();
        }catch (Exception e){
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void delete(HoaDon hd){
        try {
            hSession.getTransaction().begin();
            hSession.delete(hd);
            hSession.getTransaction().commit();
        }catch (Exception e){
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public HoaDon findByid(int id){
        return hSession.find(HoaDon.class , id);
    }
}
