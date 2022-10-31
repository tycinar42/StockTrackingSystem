package com.tyc.controller;

import com.tyc.dto.request.CreateProductRequestDto;
import com.tyc.dto.request.UpdateProductRequestDto;
import com.tyc.repository.entity.Product;
import com.tyc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.tyc.constant.ApiUrl.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
public class ProductController {
    private final ProductService service;

    @PostMapping(CREATE)
    public ResponseEntity<Product> create(@RequestBody @Valid CreateProductRequestDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PostMapping(UPDATE)
    public ResponseEntity<Product> update(@RequestBody @Valid UpdateProductRequestDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @PostMapping(DELETE)
    public ResponseEntity<Boolean> delete(Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }



}
