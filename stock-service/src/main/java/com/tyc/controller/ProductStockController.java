package com.tyc.controller;

import com.tyc.dto.request.CreateProductStockRequestDto;
import com.tyc.dto.request.UpdateProductStockRequestDto;
import com.tyc.repository.entity.ProductStock;
import com.tyc.service.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.tyc.constant.ApiUrl.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCTSTOCK)
public class ProductStockController {
    private final ProductStockService service;

    @PostMapping(CREATE)
    public ResponseEntity<Boolean> create(@RequestBody @Valid CreateProductStockRequestDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PostMapping(UPDATE)
    public ResponseEntity<Boolean> update(@RequestBody @Valid UpdateProductStockRequestDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @PostMapping(DELETE + "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<ProductStock>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(GETALLBYMODELCONTAINING + "/{model}")
    public ResponseEntity<List<ProductStock>> getAllByModelContaining(@PathVariable String model) {
        return ResponseEntity.ok(service.findByModelContaining(model));
    }



}
