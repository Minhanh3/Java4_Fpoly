package com.example.bt_jv4_12th3.repository;

import com.example.bt_jv4_12th3.entities.HoaDonChiTiet;
import com.example.bt_jv4_12th3.entities.KichThuoc;
import com.example.bt_jv4_12th3.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public class KichThuocRepo {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<KichThuoc> findAll() {
        String hql = "SELECT entity FROM KichThuoc entity";
        Query q = hSession.createQuery(hql, KichThuoc.class);
//        List<HoaDonChiTiet> lists = hSession.createQuery("FROM HoaDonChiTiet").list();
        return q.getResultList();
    }

    public void create(KichThuoc kt) {
        try {
            hSession.getTransaction().begin();
            hSession.persist(kt);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }public void update(KichThuoc kt) {
        try {
            hSession.getTransaction().begin();
            hSession.merge(kt);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(KichThuoc kt) {
        try {
            hSession.getTransaction().begin();
            hSession.remove(kt);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public KichThuoc findById(int id){
        return this.hSession.find(KichThuoc.class , id );
    }
}
