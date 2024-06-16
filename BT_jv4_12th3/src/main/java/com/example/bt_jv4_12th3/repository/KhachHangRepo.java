package com.example.bt_jv4_12th3.repository;

import com.example.bt_jv4_12th3.entities.KhachHang;
import com.example.bt_jv4_12th3.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KhachHangRepo {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<KhachHang> findAll() {
        String hql = "SELECT entity FROM KhachHang entity";
        Query q = hSession.createQuery(hql, KhachHang.class);
        return q.getResultList();
    }

    public Map<String, String> create(KhachHang kh) {
        Transaction tt = hSession.getTransaction();
        Map<String, String> error = new HashMap<>();
        if (kh.getTen() == null || kh.getTen().isEmpty() || kh.getTen().length() > 50) {
            error.put("ten", "Tên không được trống và không quá 50 ký tự");
        }
        if (kh.getMa() == null || kh.getMa().isEmpty() || kh.getMa().length() > 50) {
            error.put("ma", "Mã không được trống và không quá 50 ký tự");
        }
        if (kh.getSdt() == null || kh.getSdt().isEmpty() || kh.getSdt().length() > 10) {
            error.put("sdt", "sdt không được trống và không quá 10 ký tự");
        } else {
            try {
                Long.parseLong(kh.getSdt());
                if (!kh.getSdt().startsWith("0")) {
                    error.put("sdt", "Số điện thoại phải bắt đầu bằng số 0");
                }
            } catch (NumberFormatException e) {
                error.put("sdt", "Số điện thoại không hợp lệ");
            }
        }
        if (error.isEmpty()) {
            try {
                tt.begin();
                hSession.persist(kh);
                tt.commit();
            } catch (Exception e) {
                tt.rollback();
                e.printStackTrace();
            }
        }
        return error;
    }

    public Map<String, String> update(KhachHang kh) {
        Transaction tt = hSession.getTransaction();
        Map<String, String> error = new HashMap<>();
        if (kh.getTen() == null || kh.getTen().isEmpty() || kh.getTen().length() > 50) {
            error.put("ten", "Tên không được trống và không quá 50 ký tự");
        }
        if (kh.getMa() == null || kh.getMa().isEmpty() || kh.getMa().length() > 50) {
            error.put("ma", "Mã không được trống và không quá 50 ký tự");
        }
        if (kh.getSdt() == null || kh.getSdt().isEmpty() || kh.getSdt().length() > 10) {
            error.put("sdt", "sdt không được trống và không quá 10 ký tự");
        } else {
            try {
                Long.parseLong(kh.getSdt());
                if (!kh.getSdt().startsWith("0")) {
                    error.put("sdt", "Số điện thoại phải bắt đầu bằng số 0");
                }
            } catch (NumberFormatException e) {
                error.put("sdt", "Số điện thoại không hợp lệ");
            }
        }
        if (error.isEmpty()) {
            try {
                tt.begin();
                hSession.merge(kh);
                tt.commit();
            } catch (Exception e) {
                tt.rollback();
                e.printStackTrace();
            }
        }
        return error;
    }

    public void delete(KhachHang kh) {
        try {
            hSession.getTransaction().begin();
            hSession.remove(kh);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public KhachHang findByid(int id) {
        return this.hSession.find(KhachHang.class, id);
    }
}
