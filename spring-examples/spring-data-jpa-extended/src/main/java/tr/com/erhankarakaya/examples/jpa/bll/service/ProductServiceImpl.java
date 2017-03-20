package tr.com.erhankarakaya.examples.jpa.bll.service;

import mapper.Mappable;
import mapper.Mapper;
import mapper.exception.ResultTypeInstantiationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tr.com.erhankarakaya.examples.jpa.bll.dto.ProductDto;
import tr.com.erhankarakaya.examples.jpa.dal.entity.Product;
import tr.com.erhankarakaya.examples.jpa.dal.repository.ProductRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  ProductRepository productRepository;

  @Override
  public ProductDto save(ProductDto productDto) {
    Assert.notNull(productDto);
    try {
      Product product = Mapper.getMapperFrom(productDto).mapTo(Product::new);
      product = productRepository.save(product);
      return product.mapTo(ProductDto.class);
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public List<ProductDto> findAll() {
    List<Product> products = productRepository.findAll();
    List<ProductDto> productDtos = Mapper.getMapperFromList(products).mapToList(ProductDto::new);
    return productDtos;
  }

  @Override
  public List<ProductDto> findAll(Pageable pageable) {
    return null;
  }
}
