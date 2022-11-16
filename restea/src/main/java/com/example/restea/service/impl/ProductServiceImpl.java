package com.example.restea.service.impl;

import com.example.restea.dto.ProductDto;
import com.example.restea.dto.FlavorDto;
import com.example.restea.dto.PropertyDto;
import com.example.restea.model.*;
import com.example.restea.repository.ProductFlavorRepository;
import com.example.restea.repository.ProductRepository;
import com.example.restea.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductFlavorRepository productFlavorRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductFlavorRepository productFlavorRepository) {
        this.productRepository = productRepository;
        this.productFlavorRepository = productFlavorRepository;
    }

    @Override
    public ProductDto findProductById(Long id) {
        return new ProductDto(productRepository.findById(id).get());
    }

    public List<ProductDto> findAllProducts() {
        List<Product> listOfProducts = new ArrayList<>();
        var iterableProducts = productRepository.findAll();
        iterableProducts.forEach(listOfProducts::add);
        return listOfProducts.stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProductsForMainPage() {
        return this.findAllProducts().stream().limit(4).collect(Collectors.toList());
    }

    @Override
    public JSONObject minMaxProductPrice() {
        JSONObject minMaxPriceJsonObject = new JSONObject();
        minMaxPriceJsonObject.put("min", productRepository.minProductPrice());
        minMaxPriceJsonObject.put("max", productRepository.maxProductPrice());
        return minMaxPriceJsonObject;
    }

    @Override
    public void addProduct(ProductDto productDto) {
        Product product = productDto.toProduct();
//        product.setFlavors(flavorsDtoToFlavors(productDto.getFlavors()));
//        product.setProperties(propertiesDtoToProperties(productDto.getProperties()));
        productRepository.save(product);
        productFlavorRepository.saveAll(addProductFlavors(productDto.getFlavors(), product));
    }

    private List<ProductFlavor> addProductFlavors(List<FlavorDto> flavorsDto, Product product){
        Long productId = product.getId();
        List<ProductFlavor> productFlavors = new ArrayList<>();
        for(FlavorDto flavorDto: flavorsDto){
            Long flavorId = flavorDto.getId();
            ProductFlavorId productFlavorId = new ProductFlavorId(productId, flavorId);
            ProductFlavor productFlavor = new ProductFlavor();
            productFlavor.setId(productFlavorId);
            productFlavors.add(productFlavor);
//            productFlavorRepository.save(productFlavor);
        }
        return productFlavors;
    }


    public List<Flavor> flavorsDtoToFlavors(List<FlavorDto> productFlavorsDto){
        List<Flavor> flavors = new ArrayList<>();
        for(FlavorDto flavorDto : productFlavorsDto){
            Flavor flavor = flavorDto.toProductFlavor();
            flavors.add(flavor);
        }
        return flavors;
    }

    public List<Property> propertiesDtoToProperties(List<PropertyDto> productPropertiesDto){
        List<Property> productProperties = new ArrayList<>();
        for(PropertyDto propertyDto: productPropertiesDto){
            Property property = propertyDto.toProductProperty();
            productProperties.add(property);
        }
        return productProperties;
    }
}
