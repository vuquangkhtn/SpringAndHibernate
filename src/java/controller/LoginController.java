/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.NhanvienDAO;
import model.dao.SanphamDAO;
import model.pojo.Nhanvien;
import model.pojo.Sanpham;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author VuQuang
 */
public class LoginController extends SimpleFormController {
    
    public LoginController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Nhanvien.class);
        setCommandName("login");
        setFormView("index");
    }
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        String tendn = request.getParameter("tendn");
        String matkhau = request.getParameter("matkhau");
        Nhanvien nv = new NhanvienDAO().layThongTinNhanvien(tendn,matkhau);
        HttpSession session = request.getSession();
        session.setAttribute("nv", nv);
        if(nv.getRole().equals("ADMIN")) {
            return new ModelAndView(new RedirectView("sanphams.htm"));
        }
        else if(nv.getRole().equals("USER")) {
            return new ModelAndView(new RedirectView("viewPerInfo.htm"));
        }
        else {
            return new ModelAndView(new RedirectView("index.htm"));
        }
    }
}
