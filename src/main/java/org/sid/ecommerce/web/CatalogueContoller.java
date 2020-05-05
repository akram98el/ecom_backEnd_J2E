package org.sid.ecommerce.web;

import org.sid.ecommerce.Doa.ProductRepository;
import org.sid.ecommerce.entities.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@CrossOrigin("*")
@RestController
public class CatalogueContoller {
private ProductRepository productRepository;


    public CatalogueContoller(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping(path = "/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Product p=productRepository.findById(id).get();
       return  Files.readAllBytes(Paths.get(System.getProperty("user.home")+
                "/IdeaProjects/ecommerce_project/Products/"+p.getPhotoName()));
    }
    //parceque la requete envoyer est post
    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file,@PathVariable Long id) throws Exception {
        Product p=productRepository.findById(id).get();
        p.setPhotoName(file.getOriginalFilename() );
        Files.write(Paths.get(System.getProperty("user.home")+ "/IdeaProjects/ecommerce_project/Products/"+p.getPhotoName()),
                file.getBytes());
     productRepository.save(p);
    }

}
