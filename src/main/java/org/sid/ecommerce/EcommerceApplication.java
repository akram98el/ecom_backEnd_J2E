package org.sid.ecommerce;

import net.bytebuddy.utility.RandomString;
import org.sid.ecommerce.Doa.CategoryRepository;
import org.sid.ecommerce.Doa.ProductRepository;
import org.sid.ecommerce.entities.Category;
import org.sid.ecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class EcommerceApplication  implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
//injection spring datan
    private CategoryRepository categorieRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Product.class ,Category.class);
        categorieRepository.save(new Category(null,"ORDINATEUR",null,null));
        categorieRepository.save(new Category(null,"PHONE",null,null));
        categorieRepository.save(new Category(null,"IMPRIMANT",null,null));
        Random rnd=new Random();
        categorieRepository.findAll().forEach(c-> {
            for(int i=0; i<10 ;i++) {
                Product p=new Product();
                p.setName(RandomString.make(12));
                p.setCurrentPrice(100+rnd.nextInt());
                p.setAvailable(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setCategory(c);
                p.setPhotoName("unknown.png");
                productRepository.save(p);}
        });

    }
}
