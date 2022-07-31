package com.qgstudio.service;

import com.qgstudio.controller.Result;
import com.qgstudio.po.Code;

public interface CodeService {

    Result<Code> save (Code code) throws Exception;



    Result<Code> update (Code code) throws Exception;

}
