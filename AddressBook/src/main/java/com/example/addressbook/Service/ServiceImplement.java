package com.example.addressbook.Service;

import com.example.addressbook.DTO.AddressDTO;
import com.example.addressbook.Model.AddressModel;
import com.example.addressbook.Repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceImplement implements AddressBookService {
    @Autowired
    private AddressBookRepository repo;

    // Helper method: Convert DTO to Model
    private AddressModel convertDTOToModel(AddressDTO dto) {
        return AddressModel.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .build();
    }

    // Helper method: Convert Model to DTO
    private AddressDTO convertModelToDTO(AddressModel addressModel) {
        return AddressDTO.builder()
                .name(addressModel.getName())
                .address(addressModel.getAddress())
                .phoneNumber(addressModel.getPhoneNumber())
                .email(addressModel.getEmail())
                .build();
    }

    @Override
    public List<AddressDTO> getAllAddress() {
        List<AddressModel> addressModels = repo.findAll();
        return addressModels.stream()
                .map(this::convertModelToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO getAddressById(int id) {
        AddressModel addressModel = repo.findById(id).orElse(null);
        if (addressModel != null) {
            return convertModelToDTO(addressModel);
        }
        return null;
    }

    @Override
    public AddressDTO createAddress(AddressDTO dto) {
        AddressModel addressModel = convertDTOToModel(dto);
        AddressModel savedAddressModel = repo.save(addressModel);
        return convertModelToDTO(savedAddressModel);
    }

    @Override
    public AddressDTO updateAddress(int id, AddressDTO dto) {
        return repo.findById(id).map(existingAddressModel -> {
            existingAddressModel.setName(dto.getName());
            existingAddressModel.setAddress(dto.getAddress());
            existingAddressModel.setPhoneNumber(dto.getPhoneNumber());
            existingAddressModel.setEmail(dto.getEmail());
            AddressModel updatedAddressModel = repo.save(existingAddressModel);
            return convertModelToDTO(updatedAddressModel);
        }).orElse(null);
    }

    @Override
    public void deleteAddress(int id) {
        repo.deleteById(id);
    }
}