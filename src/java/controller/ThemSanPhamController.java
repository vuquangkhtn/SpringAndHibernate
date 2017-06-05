/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dao.SanphamDAO;
import model.pojo.Sanpham;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author VuQuang
 */
public class ThemSanPhamController extends SimpleFormController {
    
    public ThemSanPhamController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Sanpham.class);
        setCommandName("themsanpham");
        setSuccessView("sanphams"); 
        setFormView("themsanpham");
    }
    
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        Sanpham sp = (Sanpham) command;
        if(new SanphamDAO().themSanpham(sp)) {
            
            return new ModelAndView(new RedirectView("sanphams.htm"));
        }
        else {
            return null;
        }
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(getSuccessView());
        //Do something...
        return mv;
    }
     */
}
