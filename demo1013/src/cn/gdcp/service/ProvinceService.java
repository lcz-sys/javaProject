package cn.gdcp.service;

import cn.gdcp.domain.Province;

import java.util.List;

public interface ProvinceService {

    public List<Province> findAll();

    public String findAllJson();

}
