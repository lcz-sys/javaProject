package cn.gdcp.mapper;

        import cn.gdcp.domain.Cart;
        import org.apache.ibatis.annotations.Param;

        import java.util.List;

public interface CartMapper {

    int selectSumAmountByUserId(@Param("userId") int userId);

    List<Cart> selectListByUseId(@Param("userId") int userId);

    Cart selectByUserIdAndGoodId(@Param("userId") int userId, @Param("goodId") int goodId);

    boolean updateAmount(@Param("id") int id, @Param("amount") int amount);

    boolean insert(Cart cart);

    boolean delete(@Param("id") int id);

    Cart select(@Param("id") int id);

    boolean deleteByUserId(@Param("userId") int userId);
}
