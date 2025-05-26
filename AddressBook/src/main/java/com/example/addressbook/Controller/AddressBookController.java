package com.example.addressbook.Controller;

import com.example.addressbook.DTO.AddressDTO;
import com.example.addressbook.Service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/AddressBook")
public class AddressBookController {
    @Autowired
    private AddressBookService service;

    @GetMapping
    public ResponseEntity<List<AddressDTO>> GetAll() {
        List<AddressDTO> addresses = service.getAllAddress();
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> GetById(@PathVariable int id) {
        return ResponseEntity.ok(service.getAddressById(id));
    }

    @PostMapping
    public ResponseEntity<AddressDTO> CreateAddress(@RequestBody AddressDTO address) {
        return ResponseEntity.ok(service.createAddress(address));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> UpdateAddress(@PathVariable int id, @RequestBody AddressDTO address) {
        return ResponseEntity.ok(service.updateAddress(id, address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteAddress(@PathVariable int id) {
        service.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
