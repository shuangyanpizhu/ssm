package cn.bdqn.controller;

import cn.bdqn.entity.PageUtils;
import cn.bdqn.entity.Product;
import cn.bdqn.entity.ProductCategory;
import cn.bdqn.service.ProductCategoryService;
import cn.bdqn.service.ProductService;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.channels.MulticastChannel;
import java.util.List;

/**
 * Created by Administrator on 2018/1/12 0012.
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @ResponseBody
    @RequestMapping("/selectProduct.json")
    public PageUtils<Product> selectProduct(String name, Integer categoryLevel1Id, Integer categoryLevel2Id, Integer categoryLevel3Id, Integer pageNo) {
        return productService.select(name, categoryLevel1Id, categoryLevel2Id, categoryLevel3Id, 4, pageNo);
    }

    @ResponseBody
    @RequestMapping("/selectAllFd")
    public List<Product> selectAllFd() {
        List<Product> list = productService.selectAllFd();
        return list;
//        String json= JSON.toJSONString(list);
//        return json;
    }

    @ResponseBody
    @RequestMapping("/del")
    public void delete(Integer id) {
        int a = productService.deleteById(id);
    }

    @RequestMapping("/add")
    public String add(String name, String description, Double price, Integer categoryLevel1Id,
                      Integer categoryLevel2Id, Integer categoryLevel3Id, @RequestParam("upload") MultipartFile[] files, HttpServletRequest request) {
        String upLoadPath = request.getSession().getServletContext().getRealPath("upload");
        String fileName = "";
        for (int i = 0; i < files.length; i++) {
            MultipartFile multipartFile = files[i];
            fileName = multipartFile.getOriginalFilename();
            File file = new java.io.File(upLoadPath, fileName);

            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        int a = productService.addProduct(name, description, price, categoryLevel1Id, categoryLevel2Id, categoryLevel3Id, fileName);
        if (a > 0) {
            return "redirect:/selectByName";
        } else {
            return "redirect:/addHq.jsp";
        }

    }

    @RequestMapping("/update")
    public String update(Integer id, String name, String description, Double price, Integer categoryLevel1Id, Integer categoryLevel2Id,
                         Integer categoryLevel3Id, String fileName, @RequestParam("upload") MultipartFile[] files, HttpServletRequest request) {
        String upLoadPath = request.getSession().getServletContext().getRealPath("upload");
        String fileName1 = "";
        for (int i = 0; i < files.length; i++) {
            MultipartFile multipartFile = files[i];
            fileName = multipartFile.getOriginalFilename();
            File file = new java.io.File(upLoadPath, fileName1);

            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        int a = productService.updateById(id, name, description, price, categoryLevel1Id, categoryLevel2Id, categoryLevel3Id, fileName1);
        if(a>0)
        {
            return "redirect:/selectByName";
        }else
        {
            return "redirect:/upHQ.jsp";
        }
    }


    @RequestMapping("/selectById")
    public String selectById(Integer id,HttpSession session)
    {
        Product product=productService.selectById(id);
        List<ProductCategory> list=productCategoryService.selectName();
        session.setAttribute("list",list);
        session.setAttribute("product",product);
        return "upHQ";
    }
}

