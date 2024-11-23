package com.example.PassPermitAPI.Service;
import com.example.PassPermitAPI.model.PassPermit;
import com.example.PassPermitAPI.repository.PassPermitRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PassPermitService {

    private final PassPermitRepository repository;




// for activate
    public PassPermitService(PassPermitRepository repository) {
        this.repository = repository;
    }

    public Optional<PassPermit> findById(Integer id) {
        return repository.findById(Long.valueOf(id));
    }

    public PassPermit save(PassPermit passpermit) {
        return repository.save(passpermit);
    }
// for activate finish

//exception handling


    //exception handling finish









    public List<PassPermit> getAllProducts() {
        return repository.findAll();
    }
    public Optional<PassPermit> getProductById(Long id) {
        return repository.findById(id);
    }
    public PassPermit createProduct(PassPermit passpermit) {
        return repository.save(passpermit);
    }


    public PassPermit updateProduct(Long id, PassPermit passpermit) {
        if (repository.existsById(id)) {
            passpermit.setId(Math.toIntExact(id));
            return repository.save(passpermit);
        }
        return null;
    }


    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }



}