package cn.bdqn.controller;

import cn.bdqn.entity.ProductCategory;
import cn.bdqn.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/1/12 0012.
 */
@Controller
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;
    @RequestMapping("selectByName")
    public String selectByName(HttpSession session) {
        List<ProductCategory> list=productCategoryService.selectName();
        session.setAttribute("list",list);
        return "product_show";
    }

    @RequestMapping("selectByNames")
    public String selectByNames(HttpSession session) {
        List<ProductCategory> list=productCategoryService.selectName();
        session.setAttribute("list",list);
        return "addHQ";
    }

    @ResponseBody
    @RequestMapping("selectByIdName")
    public List<ProductCategory> selectByIdName(HttpSession session,Integer categoryLevel1Id)
    {
        return productCategoryService.selectByIdName(categoryLevel1Id);
    }

    @ResponseBody
    @RequestMapping("selectByIdsName")
    public List<ProductCategory> selectByIdsName(HttpSession session,Integer categoryLevel2Id)
    {
        return productCategoryService.selectByIdsName(categoryLevel2Id);
    }
}
