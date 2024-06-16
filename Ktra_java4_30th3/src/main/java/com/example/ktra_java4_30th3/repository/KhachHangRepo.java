package com.example.ktra_java4_30th3.repository;

import com.example.ktra_java4_30th3.model.KhachHang;
import com.example.ktra_java4_30th3.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class KhachHangRepo {
    private Session hSession = HibernateUtil.getFACTORY().openSession();
    public List<KhachHang> findALl(){
        String hql = "SELECT entity FROM KhachHang entity";
        Query q = hSession.createQuery(hql);
        return q.getResultList();
    }
}
