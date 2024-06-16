package com.example.bt_jv4_12th3.repository;

import com.example.bt_jv4_12th3.entities.SanPhamChiTiet;
import com.example.bt_jv4_12th3.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SanPhamCTRepo {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<SanPhamChiTiet> findAll() {
        String hql = "SELECT entity FROM SanPhamChiTiet entity";
        Query q = hSession.createQuery(hql, SanPhamChiTiet.class);
        return q.getResultList();
    }

    public void create(SanPhamChiTiet spct) {
        Transaction tst = hSession.getTransaction();
        try {
            tst.begin();
            hSession.persist(spct);
            tst.commit();
        } catch (Exception e) {
            tst.rollback();
            e.printStackTrace();
        }
    }

    public void upddate(SanPhamChiTiet spct) {
        try {
            hSession.getTransaction().begin();
            hSession.merge(spct);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(SanPhamChiTiet spct) {
        try {
            hSession.getTransaction().begin();
            hSession.remove(spct);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public SanPhamChiTiet findByID(int id){
        return this.hSession.find(SanPhamChiTiet.class , id);
    }
}
