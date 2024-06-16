package com.example.tutorjv4_b7.repository;

import com.example.tutorjv4_b7.HibernateUtils;
import com.example.tutorjv4_b7.entity.GiangVien;
import org.hibernate.Session;

import java.util.List;

public class GiangVienRepository {
    //CURD
    private Session s;
    public GiangVienRepository(){
        // mo 1 lan phien sesson
        s = HibernateUtils.getFACTORY().openSession();
    }
    public List<GiangVien> getAll(){
        List<GiangVien> lists = s.createQuery("FROM GiangVien").list();
        return lists;
    }

    public void create(GiangVien gv){
        try {
            s.beginTransaction();
            //add giang vien
            s.persist(gv);
            //comit du lieu
            s.beginTransaction().commit();
        }catch (Exception e){
            //rollback
            s.beginTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void update(GiangVien gv){
        try {
            s.beginTransaction();
            //add giang vien
            s.merge(gv);
            //comit du lieu
            s.beginTransaction().commit();
        }catch (Exception e){
            //rollback
            s.beginTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void delete(GiangVien gv){
        try {
            s.beginTransaction();
            //add giang vien
            s.delete(gv);
            //comit du lieu
            s.beginTransaction().commit();
        }catch (Exception e){
            //rollback
            s.beginTransaction().rollback();
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println(new GiangVienRepository().getAll());
    }

}
