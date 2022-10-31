package com.tyc.service;

import com.tyc.dto.request.CreateProductStockRequestDto;
import com.tyc.dto.request.UpdateProductStockRequestDto;
import com.tyc.exception.ErrorType;
import com.tyc.exception.ProductStockManagerException;
import com.tyc.mapper.IProductStockMapper;
import com.tyc.repository.IProductStockRepository;
import com.tyc.repository.entity.ProductStock;
import com.tyc.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductStockService extends ServiceManager<ProductStock, Long> {
    private final IProductStockRepository repository;

    public ProductStockService(IProductStockRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Boolean save(CreateProductStockRequestDto dto) {
        ProductStock product = IProductStockMapper.INSTANCE.toProduct(dto);
        try{
            repository.save(product);
        } catch (Exception e) {
            throw new ProductStockManagerException(ErrorType.PRODUCTSTOCK_NOT_CREATE);
        }

        return true;
    }

    public Boolean update(UpdateProductStockRequestDto dto) {
        Optional<ProductStock> product = repository.findById(dto.getProductId());
        if(product.isEmpty()) throw new ProductStockManagerException(ErrorType.PRODUCTSTOCK_NOT_FIND);
        try {
            product.get().setBrand(dto.getBrand());
            product.get().setModel(dto.getModel());
            product.get().setName(dto.getName());
            product.get().setPiece(dto.getPiece());
            repository.save(product.get());

        } catch (Exception e) {
            throw new ProductStockManagerException(ErrorType.PRODUCTSTOCK_NOT_UPDATE);
        }
        return true;
    }

    public Boolean delete(Long id) {
        Optional<ProductStock> productStock = repository.findOptionalByProductId(id);
        if(productStock.isEmpty()) throw new ProductStockManagerException(ErrorType.PRODUCTSTOCK_NOT_FIND);
        try {
            repository.deleteById(productStock.get().getId());
            return true;
        } catch (Exception e) {
            throw new ProductStockManagerException(ErrorType.PRODUCTSTOCK_NOT_DELETE);
        }
    }

    public List<ProductStock> findByModelContaining(String model) {
        return repository.findByModelContaining(model);
    }
}
