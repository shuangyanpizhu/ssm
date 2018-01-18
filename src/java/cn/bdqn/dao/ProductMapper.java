package cn.bdqn.dao;

import cn.bdqn.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/1/12 0012.
 */
@Repository
public interface ProductMapper {
    public List<Product> selectAll(@Param("name")String name,
                                   @Param("categoryLevel1Id")Integer categoryLevel1Id,@Param("categoryLevel2Id")Integer categoryLevel2Id,
                                   @Param("categoryLevel3Id")Integer categoryLevel3Id,
                                   @Param("pageSize")Integer pageSize,@Param("pageNo")Integer pageNo);

    public int selectCount(@Param("name")String name,
                           @Param("categoryLevel1Id")Integer categoryLevel1Id,@Param("categoryLevel2Id")Integer categoryLevel2Id,
                           @Param("categoryLevel3Id")Integer categoryLevel3Id);

    public List<Product> selectAllFd();

    public int deleteById(@Param("id")Integer id);

    public int addProduct(@Param("name")String name,@Param("description")String description,
                          @Param("price")Double price,@Param("categoryLevel1Id")Integer categoryLevel1Id,
                          @Param("categoryLevel2Id")Integer categoryLevel2Id,@Param("categoryLevel3Id")Integer categoryLevel3Id,
                          @Param("fileName")String fileName);

    public int updateById(@Param("id")Integer id,@Param("name")String name,@Param("description")String description,
                          @Param("price")Double price,@Param("categoryLevel1Id")Integer categoryLevel1Id,
                          @Param("categoryLevel2Id")Integer categoryLevel2Id,@Param("categoryLevel3Id")Integer categoryLevel3Id,
                          @Param("fileName")String fileName);

    public Product selectById(@Param("id")Integer id);

}
