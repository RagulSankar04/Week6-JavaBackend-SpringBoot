package com.example.addressbook.Repository;

import com.example.addressbook.Model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressModel, Integer> {
}
