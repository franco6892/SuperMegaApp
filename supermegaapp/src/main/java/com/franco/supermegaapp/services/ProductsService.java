package com.franco.supermegaapp.services;

import com.franco.supermegaapp.models.Car;
import com.franco.supermegaapp.models.Product;
import com.franco.supermegaapp.respositories.ProductsRepository;
import com.franco.supermegaapp.respositories.dtos.CarDTO;
import com.franco.supermegaapp.respositories.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public String createNewProduct(Product product){

        ProductDTO productDTO = new ProductDTO(product.name, product.price, product.stock, product.category);
        productsRepository.save(productDTO);
        return ("product saved");
    }

    public List<Product> listAllProducts() {
        List<Product> products = new LinkedList<>();
        List<ProductDTO> productDTOs = productsRepository.findAll();
        for (ProductDTO productDTO: productDTOs) {
            Product product = new Product(productDTO.id, productDTO.name, productDTO.price, productDTO.stock, productDTO.category);
            products.add(product);
        }
        return products;
//        return carsRepository.findAll()
//                .stream()
//                .map(carDTO -> new Car(carDTO.id, carDTO.name))
//                .collect(Collectors.toList());
    }

   /* private final ModelMapper modelMapper = new ModelMapper();

    public List<Product> listAllProducts() {
        List<Product> products = new LinkedList<>();
        List<ProductDTO> productDTOs = productRepository.findAll();
        for (ProductDTO productDTO : productDTOs) {
            Product product = modelMapper.map(productDTO, Product.class);
            products.add(product);
        }
        return products;
    }*/

    public String deleteProduct(int id){
        productsRepository.deleteById(id);
        return "Borradoooooo";
    }

    public Product findProductById(int id) {
        Optional<ProductDTO> productDTOs = productsRepository.findById(id);

        if (productDTOs.isPresent()) {
            ProductDTO products = productDTOs.get();
            return convertToProduct(products);
        } else {
            return null;
        }
    }

    public String updateProduct(int id, Product updatedProduct){
        Optional<ProductDTO> productDTOs = productsRepository.findById(id);

        if (productDTOs.isPresent()) {
            ProductDTO products = productDTOs.get();
            products.setName(updatedProduct.name);
            products.setPrice(updatedProduct.price);
            products.setStock(updatedProduct.stock);
            products.setCategory(updatedProduct.category);
            productsRepository.save(products);
            return "Car updated";
        } else {
            return "Cannot find the car with that id";
        }
    }

    public List<Product> listAllByCategoryProducts(String category){
        List<Product> products = new LinkedList<>();
        List<ProductDTO> productDTOs = productsRepository.findAll();
        for (ProductDTO productDTO: productDTOs) {
            if (productDTO.getCategory().equalsIgnoreCase(category)) {
                Product product = new Product(productDTO.id, productDTO.name, productDTO.price, productDTO.stock, productDTO.category);
                products.add(product);
            }
        }
        return products;
    }

    private Product convertToProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO.id, productDTO.name, productDTO.price, productDTO.stock, productDTO.category);
        return product;
    }
}
