package com.tyc.manager;

import com.tyc.dto.request.CreateProductStockRequestDto;
import com.tyc.dto.request.UpdateProductStockRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static com.tyc.constant.ApiUrl.*;

@FeignClient(name = "stock-service", url = "${myapplication.stock-service.feign-client}/productstock", decode404 = true)
public interface IProductStockManager {
    @PostMapping(CREATE)
    public ResponseEntity<Boolean> create(@RequestBody @Valid CreateProductStockRequestDto dto);

    @PostMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody @Valid UpdateProductStockRequestDto dto);

    @PostMapping(DELETE + "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id);
}