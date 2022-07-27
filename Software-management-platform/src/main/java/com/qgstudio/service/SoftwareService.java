package com.qgstudio.service;

import com.qgstudio.controller.Result;
import com.qgstudio.po.Software;
import com.qgstudio.po.User;
import com.qgstudio.po.Version;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface SoftwareService {
    Result add(Software software, Version version) throws IOException;
    Result update(Software software);
    Result delete(Integer id);
    Result<Software> getById(Integer id);

    Result<Software> getBySoftware_name(String software_name, boolean isVague);

    Result<List> getByGroup(Integer group_id);
    Result<List> getAll();



}
