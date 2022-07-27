package com.qgstudio.controller;

import com.qgstudio.po.License;
import com.qgstudio.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Software-management-platform
 * @description:
 * @author: stop.yc
 * @create: 2022-07-27 21:57
 **/

@RestController
@RequestMapping(value = "/licenses" ,produces = "application/json;charset=UTF-8")
public class LicenseController {

    @Autowired
    private LicenseService licenseService;


    @PostMapping
    Result<License> save(@RequestBody License license) throws Exception {
        return licenseService.save(license);
    }
}
