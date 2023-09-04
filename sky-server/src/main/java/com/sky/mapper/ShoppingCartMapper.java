package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    
    /**
     * 動態條件查詢
     *
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list (ShoppingCart shoppingCart);
    
    
    @Update ("update shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById (ShoppingCart shoppingCart);
    
    /**
     * 插入都無車數據
     *
     * @param shoppingCart
     * @return
     */
    @Insert ("""
            insert into shopping_cart
            (name, image, user_id, dish_id, setmeal_id, dish_flavor, number, amount, create_time) VALUES
            (#{name},#{image},#{userId},#{dishId},#{setmealId},#{dishFlavor},#{number},#{amount},#{createTime})
            """)
    int insert (ShoppingCart shoppingCart);
    
    /**
     * 根據用戶id刪除購物車數據
     *
     * @param shoppingCart
     * @return
     */
    @Delete ("delete from shopping_cart where user_id = #{userId}")
    int cleanShoppingCart (ShoppingCart shoppingCart);
    
    /**
     * 批量插入购物车数据
     *
     * @param shoppingCartList
     */
    void insertBatch (List<ShoppingCart> shoppingCartList);
    
}
