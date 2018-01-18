package cn.bdqn.service;

import cn.bdqn.dao.ProductCategoryMapper;
import cn.bdqn.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/12 0012.
 */
@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    public List<ProductCategory> selectName()
    {
        return productCategoryMapper.selectName();
    }
    public List<ProductCategory> selectByIdName(Integer parentId){ return productCategoryMapper.selectByIdName(parentId);}
    public List<ProductCategory> selectByIdsName(Integer parentId){return  productCategoryMapper.selectByIdsName(parentId);}
}
