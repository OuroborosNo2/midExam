package com.qgstudio.service;

import com.qgstudio.controller.Result;
import com.qgstudio.po.Version;

import java.util.List;

public interface VersionService {
    Result add(Version version);
    Result update(Version version);
    Result delete(Integer id);
    Result<Version> getById(Integer id);
    Result<Version> getLatestBySoftware_id(Integer software_id);
    Result<List> getAllBySoftware_id(Integer software_id);
    Result<List> getAll();
}
