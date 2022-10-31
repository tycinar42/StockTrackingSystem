package com.tyc.mapper;

import com.tyc.dto.request.CreateProductRequestDto;
import com.tyc.dto.request.UpdateProductRequestDto;
import com.tyc.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper {
    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    Product toProduct(final CreateProductRequestDto dto);
    Product toProduct(final UpdateProductRequestDto dto);
}
