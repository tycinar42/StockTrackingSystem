package com.tyc.mapper;

import com.tyc.dto.request.CreateProductStockRequestDto;
import com.tyc.dto.request.UpdateProductStockRequestDto;
import com.tyc.repository.entity.ProductStock;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductStockMapper {
    IProductStockMapper INSTANCE = Mappers.getMapper(IProductStockMapper.class);

    ProductStock toProduct(final CreateProductStockRequestDto dto);
    ProductStock toProduct(final UpdateProductStockRequestDto dto);
}
