package cn.bdqn.service;

import cn.bdqn.dao.ProductMapper;
import cn.bdqn.entity.PageUtils;
import cn.bdqn.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/12 0012.
 */
@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    public PageUtils<Product> select(String name,Integer categoryLevel1Id,Integer categoryLevel2Id,Integer categoryLevel3Id,Integer pageSize,Integer pageNo)
    {
        PageUtils<Product> product=new PageUtils<Product>();
        product.setPageNo(pageNo);
        product.setPageSize(pageSize);
        int pageNo1=(pageNo-1)*pageSize;
        List<Product> list=productMapper.selectAll(name,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,pageSize,pageNo1);

        int productCount=productMapper.selectCount(name,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id);
        int pageCount=productCount%pageSize==0?productCount/pageSize:productCount/pageSize+1;
        product.setPageCount(pageCount);
        product.setList(list);

        System.out.print(list.size());

        return product;
    }
    public List<Product> selectAllFd()
    {
        return productMapper.selectAllFd();
    }

    public int deleteById(Integer id)
    {
        return productMapper.deleteById(id);
    }

    public int addProduct(String name,String description, Double price,Integer categoryLevel1Id, Integer categoryLevel2Id,Integer categoryLevel3Id, String fileName)
    {
        return productMapper.addProduct(name,description,price,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName);
    }

    public int updateById(Integer id,String name,String description, Double price,Integer categoryLevel1Id, Integer categoryLevel2Id,Integer categoryLevel3Id, String fileName)
    {
        return productMapper.updateById(id,name,description,price,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName);
    }

    public Product selectById(Integer id)
    {
        return productMapper.selectById(id);
    }
}
