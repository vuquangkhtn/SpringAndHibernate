/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.pojo.Sanpham;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VuQuang
 */
public class SanphamDAO {
    public ArrayList<Sanpham> layDSSanpham() {
        ArrayList<Sanpham> listSP = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory()
        .openSession();
        try {
            String sql="FROM Sanpham";
            Query query = session.createQuery(sql);
            listSP = new ArrayList<>(query.list());
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return listSP;
    }
    
    public Sanpham layThongTinSanpham(int id) {
        Sanpham Sanpham = null;
        Session session = HibernateUtil.getSessionFactory()
        .openSession();
        try {
            Sanpham = (Sanpham)session.get(Sanpham. class, id);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return Sanpham;
    }
    
    //id sp de la null
    public boolean themSanpham(Sanpham Sanpham) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (Sanpham.getId()!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(Sanpham);
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
    
    public boolean capNhatThongTinSanpham(Sanpham Sanpham) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (Sanpham.getId()==null) {
            return false;
        }
        if (layThongTinSanpham(Sanpham.getId())==null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(Sanpham);
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
    
    public boolean xoaSanpham(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Sanpham Sanpham = layThongTinSanpham(id);
        if (Sanpham == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(Sanpham);
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
    
}
