package cn.gdcp.mapper;

import cn.gdcp.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Select("select * from sys_role r,sys_user_role ur where ur.roleid =  r.id and ur.userid = #{uid}")
    List<Role> findByUid(int uid);
}
