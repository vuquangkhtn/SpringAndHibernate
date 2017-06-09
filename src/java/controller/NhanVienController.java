/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.User;
import model.dao.NhanvienDAO;
import model.pojo.Nhanvien;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author VuQuang
 */
public class NhanVienController implements Controller{

    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername(); //get logged in username
        ModelAndView mv = new ModelAndView("nv_thongtincanhan");
        try {
            Nhanvien nv = new NhanvienDAO().layThongTinNhanvien(name);
            mv.addObject("staff",nv);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}
