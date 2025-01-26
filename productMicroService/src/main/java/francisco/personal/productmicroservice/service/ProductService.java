package francisco.personal.productmicroservice.service;

import francisco.personal.productmicroservice.entities.ProductDTO;
import francisco.personal.productmicroservice.exceptions.custom.NotFoundException;
import francisco.personal.productmicroservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public ProductDTO createProduct(ProductDTO product) {
        return productRepository.save(product);
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public ProductDTO updateProduct(Long id, ProductDTO product) {
        ProductDTO existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        ProductDTO existingProduct = getProductById(id);
        productRepository.delete(existingProduct);
    }
}
