package com.example.bt_jv4_12th3.repository;

import com.example.bt_jv4_12th3.entities.MauSac;
import com.example.bt_jv4_12th3.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MauSacRepo {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<MauSac> findAll() {
        String hql = "SELECT entity FROM MauSac entity";
        Query q = hSession.createQuery(hql, MauSac.class);
        return q.getResultList();
    }

    public void create(MauSac ms) {
        Transaction tt = hSession.getTransaction();
        try {
            tt.begin();
            this.hSession.persist(ms);
            tt.commit();
        } catch (Exception e) {
            tt.rollback();
            e.printStackTrace();
        }
    }

    public void update(MauSac ms) {
        Transaction tt = hSession.getTransaction();
        try {
            tt.begin();
            this.hSession.merge(ms);
            tt.commit();
        } catch (Exception e) {
            tt.rollback();
            e.printStackTrace();
        }
    }

    public void delete(MauSac ms) {
        Transaction tt = hSession.getTransaction();
        try {
            tt.begin();
            this.hSession.remove(ms);
            tt.commit();
        } catch (Exception e) {
            tt.rollback();
            e.printStackTrace();
        }
    }

    public void deleteByid(MauSac ms) {
        Transaction tt = hSession.getTransaction();
        try {
            tt.begin();
            this.hSession.remove(ms);
            tt.commit();
        } catch (Exception e) {
            tt.rollback();
            e.printStackTrace();
        }
    }

    public MauSac findByid(int id) {
        return this.hSession.find(MauSac.class, id);
    }
}
