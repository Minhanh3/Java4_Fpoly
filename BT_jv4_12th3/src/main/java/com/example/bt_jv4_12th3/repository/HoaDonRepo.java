package com.example.bt_jv4_12th3.repository;

import com.example.bt_jv4_12th3.entities.HoaDon;
import com.example.bt_jv4_12th3.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoaDonRepo {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<HoaDon> findAll() {
        String hql = "SELECT ENTITY FROM HoaDon ENTITY";
        Query q = hSession.createQuery(hql, HoaDon.class);
        return q.getResultList();
    }

    public Map<String, String> create(HoaDon hd) {
        Map<String, String> error = new HashMap<>();
        if (hd.getIdNhanVien() == null || hd.getIdNhanVien().equals("")) {
            error.put("idnv", "idNhanVien không được trống ");
        }
        if (hd.getIdKhachHang() == null || hd.getIdKhachHang().equals("")) {
            error.put("idkh", "idKhachHang không được trống ");
        }
        if (hd.getNgayMuaHang() == null || hd.getNgayMuaHang().isEmpty()) {
            error.put("ngayMuaHang", "ngayMuaHang không được trống ");
        }
        if (error.isEmpty()) {
            try {
                hSession.getTransaction().begin();
                hSession.persist(hd);
                hSession.getTransaction().commit();
            } catch (Exception e) {
                hSession.getTransaction().rollback();
                e.printStackTrace();
            }
        }
        return error;
    }

    public Map<String, String> update(HoaDon hd) {
        Map<String, String> error = new HashMap<>();
        if (hd.getIdNhanVien() == null || hd.getIdNhanVien().equals("")) {
            error.put("idNhanVien", "idNhanVien không được trống ");
        }
        if (hd.getIdKhachHang() == null || hd.getIdKhachHang().equals("")) {
            error.put("idKhachHang", "idKhachHang không được trống ");
        }
        if (hd.getNgayMuaHang() == null || hd.getNgayMuaHang().isEmpty()) {
            error.put("ngayMuaHang", "ngayMuaHang không được trống ");
        }
        if (error.isEmpty()) {
            try {
                hSession.getTransaction().begin();
                hSession.merge(hd);
                hSession.getTransaction().commit();
            } catch (Exception e) {
                hSession.getTransaction().rollback();
                e.printStackTrace();
            }
        }
        return error;
    }

    public void delete(HoaDon hd) {
        try {
            hSession.getTransaction().begin();
            hSession.remove(hd);
            hSession.getTransaction().commit();
        } catch (Exception e) {
            hSession.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public HoaDon findById(int id) {
        return hSession.find(HoaDon.class, id);
    }
}
