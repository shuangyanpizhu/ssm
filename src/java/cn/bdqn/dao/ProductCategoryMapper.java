package cn.bdqn.dao;

import cn.bdqn.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/1/12 0012.
 */
@Repository
public interface ProductCategoryMapper {
    public List<ProductCategory> selectName();

    public List<ProductCategory> selectByIdName(@Param("parentId")Integer parentId);

    public List<ProductCategory> selectByIdsName(@Param("parentId")Integer parentId);
}
