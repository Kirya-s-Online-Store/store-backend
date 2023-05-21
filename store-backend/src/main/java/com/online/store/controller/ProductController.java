package com.online.store.controller;

import com.online.store.dto.InfoClauseDTO;
import com.online.store.dto.ProductRequest;
import com.online.store.model.InfoClause;
import com.online.store.model.Product;
import com.online.store.service.FirebaseService;
import com.online.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final FirebaseService firebaseService;

    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(
            @RequestParam(name = "brand_id", required = false) Integer brandId,
            @RequestParam(name = "type_id", required = false) Integer typeId,
            Pageable pageable) {
        Page<Product> products = productService.findAll(brandId, typeId, pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        Product content = productService.findById(id);
        return ResponseEntity.ok(content);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest product) {
        Product content = productService.create(product);
        return ResponseEntity.ok()
                .location(URI.create("/api/product/" + content.getId()))
                .body(content);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Product> uploadFile(
            @RequestPart("img") MultipartFile img,
            @RequestPart("name") String name,
            @RequestPart("brandId") Integer brandId,
            @RequestPart("price") Double price,
            @RequestPart("typeId") Integer typeId,
            @RequestPart("info") List<InfoClauseDTO> info
    ) {
        String photoLink = firebaseService.upload(img);
        ProductRequest request = ProductRequest.builder()
                .name(name)
                .brandId(brandId)
                .typeId(typeId)
                .price(price)
                .photoLink(photoLink)
                .info(info)
                .build();
        Product createdProduct = productService.create(request);
        return ResponseEntity.ok(createdProduct);
}
    }
