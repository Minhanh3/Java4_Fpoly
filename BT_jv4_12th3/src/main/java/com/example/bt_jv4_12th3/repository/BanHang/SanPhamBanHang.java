package com.example.bt_jv4_12th3.repository.BanHang;

import com.example.bt_jv4_12th3.entities.SanPham;
import com.example.bt_jv4_12th3.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SanPhamBanHang {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<SanPham> findAll() {
        String hql = "SELECT entity FROM SanPham entity";
        Query q = hSession.createQuery(hql, SanPham.class);
        q.setFirstResult(0);
        q.setMaxResults(4);
        return q.getResultList();
    }
}
