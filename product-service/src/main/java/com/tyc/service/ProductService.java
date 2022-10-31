package com.tyc.service;

import com.tyc.dto.request.CreateProductRequestDto;
import com.tyc.dto.request.CreateProductStockRequestDto;
import com.tyc.dto.request.UpdateProductRequestDto;
import com.tyc.dto.request.UpdateProductStockRequestDto;
import com.tyc.exception.ErrorType;
import com.tyc.exception.ProductManagerException;
import com.tyc.manager.IProductStockManager;
import com.tyc.mapper.IProductMapper;
import com.tyc.repository.IProductRepository;
import com.tyc.repository.entity.Product;
import com.tyc.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.lang.management.OperatingSystemMXBean;
import java.util.Optional;

@Service
public class ProductService extends ServiceManager<Product, Long> {
    private final IProductRepository repository;
    private final IProductStockManager productStockManager;

    public ProductService(IProductRepository repository, IProductStockManager productStockManager) {
        super(repository);
        this.repository = repository;
        this.productStockManager = productStockManager;
    }

    public Product save(CreateProductRequestDto dto) {
        Product product = IProductMapper.INSTANCE.toProduct(dto);
        try{
            repository.save(product);
            productStockManager.create(CreateProductStockRequestDto.builder()
                            .productId(product.getId())
                            .brand(product.getBrand())
                            .model(product.getModel())
                            .name(product.getName())
                            .piece(product.getPiece())
                    .build());
        } catch (Exception e) {
            throw new ProductManagerException(ErrorType.PRODUCT_NOT_CREATE);
        }

        return product;
    }

    public Product update(UpdateProductRequestDto dto) {
        Optional<Product> product = repository.findById(dto.getId());
        if(product.isEmpty()) throw new ProductManagerException(ErrorType.PRODUCT_NOT_FIND);
        try{
            product.get().setBrand(dto.getBrand());
            product.get().setModel(dto.getModel());
            product.get().setName(dto.getName());
            product.get().setPiece(dto.getPiece());
            repository.save(product.get());
            productStockManager.update(UpdateProductStockRequestDto.builder()
                    .productId(product.get().getId())
                    .brand(product.get().getBrand())
                    .model(product.get().getModel())
                    .name(product.get().getName())
                    .piece(product.get().getPiece())
                    .build());
        } catch (Exception e) {
            throw new ProductManagerException(ErrorType.PRODUCT_NOT_UPDATE);
        }

        return product.get();
    }

    public Boolean delete(Long id) {
        Optional<Product> product = repository.findById(id);
        if(product.isEmpty()) throw new ProductManagerException(ErrorType.PRODUCT_NOT_FIND);
        try {
            repository.deleteById(id);
            productStockManager.delete(id);
            return true;
        } catch (Exception e) {
            throw new ProductManagerException(ErrorType.PRODUCT_NOT_DELETE);
        }
    }
}
