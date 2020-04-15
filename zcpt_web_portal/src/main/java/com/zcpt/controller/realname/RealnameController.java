package com.zcpt.controller.realname;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.zcpt.realname.IRealNameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Api(tags = "实名认证接口")
@Controller
@RequestMapping("/realname")
public class RealnameController {
    @Reference
    private IRealNameService realNameService;

    //添加实名信息 fileurl待写
    @PostMapping("/add")
    @ApiOperation(value = "添加实名信息", notes = "获取待审核实名信息")
    public String addRealname(@RequestParam MultipartFile file, @RequestBody Map<String,Object> insertMap){
        if (file == null)
            return null;
        String filename = file.getOriginalFilename();
        String fileurl = "" + filename;
        insertMap.put("img", fileurl);
        realNameService.addRealName(insertMap);
        return "success";
    }
}
