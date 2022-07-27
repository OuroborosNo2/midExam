package com.qgstudio.service;

import com.qgstudio.controller.Result;
import com.qgstudio.po.Version;

import java.io.IOException;
import java.util.List;

public interface VersionService {
    Result add(Version version) throws IOException;
    Result update(Version version) throws IOException;
    Result delete(Integer id);
    Result<Version> getById(Integer id);
    Result<Version> getByVersionInf(Integer software_id,String versionInf);
    Result<Version> getLatestBySoftware_id(Integer software_id);
    Result<List> getAllBySoftware_id(Integer software_id);
    Result<List> getAll();
}
