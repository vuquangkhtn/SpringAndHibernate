/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Nhanvien;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VuQuang
 */
public class NhanvienDAO {

    public ArrayList<Nhanvien> layDSNhanvien() {
        ArrayList<Nhanvien> listNV = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String sql="FROM Nhanvien";
            Query query = session.createQuery(sql);
            listNV = new ArrayList<>(query.list());
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return listNV;
    }
    
    public Nhanvien layThongTinNhanvien(int id) {
        Nhanvien nhanvien = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            nhanvien = (Nhanvien)session.get(Nhanvien.class, id);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return nhanvien;
    }
    
    public boolean themNhanvien(Nhanvien Nhanvien) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (layThongTinNhanvien(Nhanvien.getIdnhanvien())!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(Nhanvien);
            transaction.commit();
        } catch (HibernateException ex) {
        //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    
    public boolean capNhatThongTinNhanvien(Nhanvien Nhanvien) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (layThongTinNhanvien(Nhanvien.getIdnhanvien())==null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(Nhanvien);
            transaction.commit();
        } catch (HibernateException ex) {
        //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    
    public boolean xoaNhanvien(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Nhanvien Nhanvien = layThongTinNhanvien(id);
        if (Nhanvien == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(Nhanvien);
            transaction.commit();
        } catch (HibernateException ex) {
        //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    
    public Nhanvien layThongTinNhanvien(String tendn, String matkhau) {
        Nhanvien nv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            String sql="FROM Nhanvien WHERE tendn = :tendn AND matkhau = :matkhau";
            Query query = session.createQuery(sql);
            query.setParameter("tendn" ,tendn);
            query.setParameter("matkhau" ,matkhau);
            List<Nhanvien> ds = query.list();
            if(!ds.isEmpty())
                nv=ds.get(0);
        } catch (HibernateException ex) {
            System.err.println(ex);
            nv = null;
        } finally {
            session.close();
        }
        return nv;
    }
    
    public Nhanvien layThongTinNhanvien(String tendn) {
        Nhanvien nv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            String sql="FROM Nhanvien WHERE tendn = :tendn";
            Query query = session.createQuery(sql);
            query.setParameter("tendn" ,tendn);
            List<Nhanvien> ds = query.list();
            if(!ds.isEmpty())
                nv=ds.get(0);
        } catch (HibernateException ex) {
            System.err.println(ex);
            nv = null;
        } finally {
            session.close();
        }
        return nv;
    }
}
