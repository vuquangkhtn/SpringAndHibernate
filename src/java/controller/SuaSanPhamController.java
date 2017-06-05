/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.SanphamDAO;
import model.pojo.Sanpham;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author VuQuang
 */
public class SuaSanPhamController extends SimpleFormController{
    
//     
//     public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1){
//        ModelAndView mv = new ModelAndView("suasanpham");
//        try {
//            List<Sanpham> list = new SanphamDAO().layDSSanpham();
//            mv.addObject("products",list);
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//        return mv;
//    }
    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView("suasanpham");
        try {
            List<Sanpham> list = new SanphamDAO().layDSSanpham();
            mv.addObject("products",list);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
    
    public SuaSanPhamController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Sanpham.class);
        setCommandName("suasanpham");
        setSuccessView("sanphams"); 
        setFormView("suasanpham");
    }
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        Sanpham sp = (Sanpham) command;
        sp.setId(Integer.valueOf(request.getParameter("listIDProduct")));
        if(new SanphamDAO().capNhatThongTinSanpham(sp)) {
            
            return new ModelAndView(new RedirectView("sanphams.htm"));
        }
        else {
            return null;
        }
    }
}
