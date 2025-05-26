package com.example.addressbook.Service;

import com.example.addressbook.DTO.AddressDTO;

import java.util.*;

public interface AddressBookService {
    List<AddressDTO> getAllAddress();
    AddressDTO getAddressById(int id);
    AddressDTO createAddress(AddressDTO addressBookAddressDTO);
    AddressDTO updateAddress(int id, AddressDTO newAddressBookAddressDTO);
    void deleteAddress(int id);

}
