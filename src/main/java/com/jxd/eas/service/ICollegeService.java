package com.jxd.eas.service;

import com.jxd.eas.model.College;

import java.util.List;

public interface ICollegeService {
    List<College> getColleges();//获取所有学院，包含学院编号和学院名称
}
