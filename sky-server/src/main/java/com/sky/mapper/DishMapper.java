package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DishMapper {
    
    /**
     * 根据分类id查询菜品数量
     *
     * @param categoryId
     * @return
     */
    @Select ("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId (Long categoryId);
    
    /**
     * 插入菜品數據
     *
     * @param dish
     * @return
     */
    @AutoFill (OperationType.INSERT)
    int insertDish (Dish dish);
    
    /**
     * 菜品分頁查詢
     *
     * @param dishPageQueryDTO
     * @return
     */
    Page<DishVO> dishPageQuery (DishPageQueryDTO dishPageQueryDTO);
    
    @Select ("select * from dish where id = #{id}")
    Dish selectDishById (Long id);
    
    /**
     * 根據id刪除菜品
     *
     * @param id
     */
    @Delete ("delete from dish where id = #{id}")
    void deleteById (Long id);
    
    @AutoFill (OperationType.UPDATE)
    void updateDish (Dish dish);
    
    List<Dish> list (Dish dish);
    
    Integer countByMap (Map map);
}
