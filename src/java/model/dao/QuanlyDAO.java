/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import model.pojo.Quanly;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VuQuang
 */
public class QuanlyDAO {
    public ArrayList<Quanly> layDSQuanly() {
        ArrayList<Quanly> listQL = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory()
        .openSession();
        try {
            String sql="FROM Quanly";
            Query query = session.createQuery(sql);
            listQL = new ArrayList<>(query.list());
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return listQL;
    }
    public Quanly layThongTinQuanly(int id) {
        Quanly Quanly = null;
        Session session = HibernateUtil.getSessionFactory()
        .openSession();
        try {
            Quanly = (Quanly)session.get(Quanly. class, id);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return Quanly;
    }
    
    public boolean themQuanly(Quanly Quanly) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (layThongTinQuanly(Quanly.getIdquanly())!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(Quanly);
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
    
    public boolean capNhatThongTinQuanly(Quanly Quanly) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (layThongTinQuanly(Quanly.getIdquanly())==null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(Quanly);
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
    
    public boolean xoaQuanly(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Quanly Quanly = layThongTinQuanly(id);
        if (Quanly == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(Quanly);
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
