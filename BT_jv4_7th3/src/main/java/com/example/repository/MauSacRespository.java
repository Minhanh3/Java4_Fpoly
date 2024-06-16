package com.example.repository;

import com.example.entitles.MauSac;
import com.example.Session6_Map_Table.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MauSacRespository {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<MauSac> findAll() {
        String hql = "SELECT entity FROM MauSac entity";
        Query q = hSession.createQuery(hql, MauSac.class);

        return q.getResultList();
    }

    public String create(MauSac ms) {
        Transaction tt = hSession.getTransaction();
        try {
            tt.begin();
            this.hSession.persist(ms);
            tt.commit();
        } catch (Exception e) {
            tt.rollback();
            e.printStackTrace();
        }

        return null;

    }

    public String update(MauSac ms) {
        Transaction tt = hSession.getTransaction();
        try {
            tt.begin();
            this.hSession.merge(ms);
            tt.commit();
        } catch (Exception e) {
            tt.rollback();
            e.printStackTrace();
        }
        return null;

    }

    public String delete(MauSac ms) {
        Transaction tt = hSession.getTransaction();
        try {
            tt.begin();
            this.hSession.remove(ms);
            tt.commit();
        } catch (Exception e) {
            tt.rollback();
            e.printStackTrace();
        }
        return null;
    }

    public MauSac findByid(int id) {
        return this.hSession.find(MauSac.class, id);
    }
}
