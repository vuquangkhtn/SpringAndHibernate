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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;


/**
 *
 * @author VuQuang
 */
public class SanPhamController implements Controller{

    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1){
        ModelAndView mv = new ModelAndView("sanphams");
        try {
            List<Sanpham> list = new SanphamDAO().layDSSanpham();
            mv.addObject("products",list);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}
