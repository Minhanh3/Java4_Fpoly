package com.example.bt_jv4_12th3.repository;

import com.example.bt_jv4_12th3.entities.HoaDonChiTiet;
import com.example.bt_jv4_12th3.utils.HibernateUtil;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HDChiTietRepo {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<HoaDonChiTiet> findAll() {
//        String hql = "SELECT ENTITY FROM HoaDonChiTiet entity";
//        Query q = hSession.createQuery(hql , HoaDonChiTiet.class);
        List<HoaDonChiTiet> lists = hSession.createQuery("FROM HoaDonChiTiet").list();

//        return q.getResultList();
        return lists;
    }

    public Map<String, String> create(HoaDonChiTiet hdct) {
        Transaction ts = hSession.getTransaction();
        Map<String, String> error = new HashMap<>();
        if (hdct.getIdHoaDon() == null || hdct.getIdHoaDon().equals("")) {
            error.put("idHoaDon", "idHoaDon không được trống ");
        }
        if (hdct.getIdSPCT() == null || hdct.getIdSPCT().equals("")) {
            error.put("idSPCT", "idSPCT không được trống ");
        }
        if (hdct.getSoLuong() == null) {
            error.put("soLuong", "soLuong không được trống ");
        }
        if (hdct.getDonGia() == null) {
            error.put("donGia", "donGia không được trống ");
        }
        if (hdct.getThoiGian() == null) {
            error.put("thoiGian", "thoiGian không được trống ");
        }
        if (error.isEmpty()) {
            try {
                ts.begin();
                hSession.persist(hdct);
                ts.commit();
            } catch (Exception e) {
                ts.rollback();
                e.printStackTrace();
            }
        }
        return error;
    }

    public Map<String, String> update(HoaDonChiTiet hdct) {
        Transaction ts = hSession.getTransaction();
        Map<String, String> error = new HashMap<>();
        if (hdct.getIdHoaDon() == null || hdct.getIdHoaDon().equals("")) {
            error.put("idHoaDon", "idHoaDon không được trống ");
        }
        if (hdct.getIdSPCT() == null || hdct.getIdSPCT().equals("")) {
            error.put("idSPCT", "idSPCT không được trống ");
        }
        if (hdct.getSoLuong() == null) {
            error.put("soLuong", "soLuong không được trống ");
        }
        if (hdct.getDonGia() == null) {
            error.put("donGia", "donGia không được trống ");
        }
        if (hdct.getThoiGian() == null) {
            error.put("thoiGian", "thoiGian không được trống ");
        }
        if (error.isEmpty()) {
            try {
                ts.begin();
                hSession.merge(hdct);
                ts.commit();
            } catch (Exception e) {
                ts.rollback();
                e.printStackTrace();
            }
        }
        return error;
    }

    public void delete(HoaDonChiTiet hdct) {
        Transaction ts = hSession.getTransaction();
        try {
            ts.begin();
            hSession.remove(hdct);
            ts.commit();
        } catch (Exception e) {
            ts.rollback();
            e.printStackTrace();
        }
    }

    public HoaDonChiTiet findByid(int id) {
        return this.hSession.find(HoaDonChiTiet.class, id);
    }

    public static void main(String[] args) {
        System.out.println(new HDChiTietRepo().findAll()
        );
    }
}
