package com.example.PassPermitAPI.controller;
import com.example.PassPermitAPI.Service.PassPermitService;
import com.example.PassPermitAPI.model.PassPermit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/passpermit/")
public class PassPermitController {

    private final PassPermitService service;
    public PassPermitController(PassPermitService service) {
        this.service = service;
    }
    @PostMapping("/add")
    public ResponseEntity<PassPermit> createProduct(@RequestBody PassPermit
                                                         passpermit) {
        return new ResponseEntity<>(service.createProduct(passpermit),
                HttpStatus.CREATED);

    }

    @GetMapping
    public List<PassPermit> getAllProducts() {
        return service.getAllProducts();
    }
    @GetMapping("/{id}")

    public ResponseEntity<PassPermit> getProductById(@PathVariable Long
                                                          id) {
        return service.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


// this line correct but no message
//    @
//            PutMapping("/update/{id}")
//    public ResponseEntity<PassPermit> updateProduct(@PathVariable Long
//                                                         id, @RequestBody PassPermit passpermit) {
//        PassPermit updated = service.updateProduct(id, passpermit);
//        return updated != null ? ResponseEntity.ok(updated) :
//                ResponseEntity.notFound().build();
//
//    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody PassPermit passpermit) {
        PassPermit updated = service.updateProduct(id, passpermit);
        if (updated != null) {
            String updateMessage = "Pass Permit with ID " + id + " has been successfully updated.";
            return ResponseEntity.ok(new UpdateResponse(updateMessage, updated));
        }
        else
        {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pass Permit with ID " + id + " not found.");
        }
    }

   // boolean activate part




    @PutMapping("/{id}/activate")
    public ResponseEntity<String> activatePassPermit(@PathVariable Integer id) {
        Optional<PassPermit> optionalPassPermit = service.findById(id);

        if (optionalPassPermit.isPresent()) {
            PassPermit passPermit = optionalPassPermit.get();
            if (!passPermit.isActive()) {
                passPermit.setActive(true);
                service.save(passPermit);
                return ResponseEntity.ok("Pass Permit with ID " + id + " has been successfully activated.");
            } else {
                return ResponseEntity.badRequest().body("Pass Permit with ID " + id + " is already active.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pass Permit with ID " + id + " not found.");
        }
    }


    // boolean


    //boolean deactivate part

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivatePassPermit(@PathVariable Integer id) {
        Optional<PassPermit> optionalPassPermit = service.findById(id);

        if (optionalPassPermit.isPresent()) {
            PassPermit passPermit = optionalPassPermit.get();
            if (passPermit.isActive()) {
                passPermit.setActive(false);
                service.save(passPermit);
                return ResponseEntity.ok("Pass Permit with ID " + id + " has been successfully deactivated.");
            } else {
                return ResponseEntity.badRequest().body("Pass Permit with ID " + id + " is already inactive.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pass Permit with ID " + id + " not found.");
        }
    }



//boolean deactivate part

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        String deleteMessage = "Product with ID " + id + " has been successfully deleted.";
        return ResponseEntity.ok(deleteMessage);
    }


    // only activate passpermit



    //




}