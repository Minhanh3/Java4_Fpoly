package com.example.bt_jv4_12th3.repository;

import com.example.bt_jv4_12th3.entities.SanPham;
import com.example.bt_jv4_12th3.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SanPhamRepo {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<SanPham> findAll() {
        String hql = "SELECT entity FROM SanPham entity";
        Query q = hSession.createQuery(hql, SanPham.class);
        return q.getResultList();
    }

    public Map<String, String> create(SanPham sp) {
        Transaction tt = hSession.getTransaction();
        Map<String, String> error = new HashMap<>();
        if (sp.getTen() == null || sp.getTen().isEmpty() || sp.getTen().length() > 50) {
            error.put("ten", "Tên không được trống và không quá 50 ký tự");
        }
        if (sp.getMa() == null || sp.getMa().isEmpty() || sp.getMa().length() > 50) {
            error.put("ma", "Mã không được trống và không quá 50 ký tự");
        }

        if (error.isEmpty()) {
            try {
                tt.begin();
                hSession.persist(sp);
                tt.commit();
            } catch (Exception e) {
                tt.rollback();
                e.printStackTrace();
            }
        }
        return error;
    }

    public Map<String, String> update(SanPham sp) {
        Transaction tt = hSession.getTransaction();
        Map<String, String> error = new HashMap<>();
        if (sp.getTen() == null || sp.getTen().isEmpty() || sp.getTen().length() > 50) {
            error.put("ten", "Tên không được trống và không quá 50 ký tự");
        }
        if (sp.getMa() == null || sp.getMa().isEmpty() || sp.getMa().length() > 50) {
            error.put("ma", "Mã không được trống và không quá 50 ký tự");
        }

        if (error.isEmpty()) {
            try {
                tt.begin();
                hSession.merge(sp);
                tt.commit();
            } catch (Exception e) {
                tt.rollback();
                e.printStackTrace();
            }
        }
        return error;
    }

    public void delete(SanPham sp) {
        Transaction tt = hSession.getTransaction();
        try {
            tt.begin();
            hSession.remove(sp);
            tt.commit();
        } catch (Exception e) {
            tt.rollback();
            e.printStackTrace();
        }
    }

    public SanPham findByid(int id) {
        return this.hSession.find(SanPham.class, id);
    }
}
