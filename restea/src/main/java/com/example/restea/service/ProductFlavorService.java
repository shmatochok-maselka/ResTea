package com.example.restea.service;

import com.example.restea.model.ProductFlavor;
import com.example.restea.model.ProductOrigin;

public interface ProductFlavorService {
    ProductFlavor findFlavorById(Long id);

    ProductFlavor findFlavorByName(String name);
}
