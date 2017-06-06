/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.NhanvienDAO;
import model.pojo.Nhanvien;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author VuQuang
 */
public class NhanVienController implements Controller{

    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1){
        ModelAndView mv = new ModelAndView("nv_thongtincanhan");
        try {
            Nhanvien list = new NhanvienDAO().layThongTinNhanvien(1);
            mv.addObject("staff",list);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}
