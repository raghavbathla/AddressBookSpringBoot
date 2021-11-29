package com.bridgelabz.addressbookspringboot.services;

import com.bridgelabz.addressbookspringboot.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringboot.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookData> getAddressBookData();
    AddressBookData getAddressBookDataById(int AddressBookID);
    AddressBookData createData(AddressBookDTO addressBookDTO);
    AddressBookData updateData(int AddressBookID,AddressBookDTO addressBookDTO);
    void DeleteData(int AddressBookID);
    List<AddressBookData> getAddressByCity(String city);
    List<AddressBookData> getAddressByPincode(long pincode);
    List<AddressBookData> getAddressByName(String name);
}
