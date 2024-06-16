package com.example.bt_jv4_12th3.repository;

import com.example.bt_jv4_12th3.entities.NhanVien;
import com.example.bt_jv4_12th3.utils.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NhanVienRepo {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<NhanVien> findAll() {
        String hql = "SELECT ENTITY FROM NhanVien ENTITY";
        Query q = hSession.createQuery(hql, NhanVien.class);

        return q.getResultList();
    }

    public Map<String, String> create(NhanVien nv) {
        Map<String, String> error = new HashMap<>();
        if (nv.getTen() == null || nv.getTen().isEmpty() || nv.getTen().length() > 50) {
            error.put("ten", "Tên không được trống và không quá 50 ký tự");
        }
        if (nv.getMa() == null || nv.getMa().isEmpty() || nv.getMa().length() > 50) {
            error.put("ma", "Mã không được trống và không quá 50 ký tự");
        }
        if (nv.getTenDangNhap() == null || nv.getTenDangNhap().isEmpty() || nv.getTenDangNhap().length() > 50) {
            error.put("tenDangNhap", "Tên đăng nhập không được trống và không quá 50 ký tự");
        }
        if (nv.getMatKhau() == null || nv.getMatKhau().isEmpty() || nv.getMatKhau().length() > 50) {
            error.put("matKhau", "Mật khẩu không được trống và không quá 50 ký tự");
        }
        if (error.isEmpty()) {
            try {
                hSession.getTransaction().begin();
                hSession.persist(nv);
                hSession.getTransaction().commit();
            } catch (Exception e) {
                hSession.getTransaction().rollback();
                e.printStackTrace();
            }
        }
        return error;
    }



    public Map<String, String> update(NhanVien nv) {
        Map<String, String> error = new HashMap<>();
        if (nv.getTen() == null || nv.getTen().isEmpty() || nv.getTen().length() > 50) {
            error.put("ten", "Tên không được trống và không quá 50 ký tự");
        }
        if (nv.getMa() == null || nv.getMa().isEmpty() || nv.getMa().length() > 50) {
            error.put("ma", "Mã không được trống và không quá 50 ký tự");
        }
        if (nv.getTenDangNhap() == null || nv.getTenDangNhap().isEmpty() || nv.getTenDangNhap().length() > 50) {
            error.put("tenDangNhap", "Tên đăng nhập không được trống và không quá 50 ký tự");
        }
        if (nv.getMatKhau() == null || nv.getMatKhau().isEmpty() || nv.getMatKhau().length() > 50) {
            error.put("matKhau", "Mật khẩu không được trống và không quá 50 ký tự");
        }
        if (error.isEmpty()) {
            try {
                hSession.getTransaction().begin();
                hSession.merge(nv);
                hSession.getTransaction().commit();
            } catch (Exception e) {
                hSession.getTransaction().rollback();
                e.printStackTrace();
            }
        }
        return error;
    }

    public void delete(NhanVien nv) {
        try {
            hSession.getTransaction().begin();
            hSession.remove(nv);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public NhanVien finById(int id) {
        return this.hSession.find(NhanVien.class, id);
    }
}
