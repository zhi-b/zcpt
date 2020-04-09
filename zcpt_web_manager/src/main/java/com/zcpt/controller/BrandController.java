package com.zcpt.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zcpt.entity.ResponseData;
import com.zcpt.goods.IBrandService;
import com.zcpt.pojo.Brand;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager/goods")
@Api(tags = "商品品牌列表")
public class BrandController {
    @Reference
    private IBrandService brandService;
    @GetMapping("/login")
    @ApiOperation(value = "品牌列表", notes = "获取所有品牌信息")
    public ResponseData<Brand> brandList() {

        List<Brand> brands = brandService.brandList();

        if (brands != null) {
            return ResponseData.success().putDataVule("brandList", brands);
        } else {
            return ResponseData.serverInternalError();
        }
    }
}