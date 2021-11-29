package com.bridgelabz.addressbookspringboot.services;

import com.bridgelabz.addressbookspringboot.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringboot.exceptions.EmployeePayrollException;
import com.bridgelabz.addressbookspringboot.model.AddressBookData;
import com.bridgelabz.addressbookspringboot.repository.AddressBookRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressBookService implements IAddressBookService{

    @Autowired
   private AddressBookRepositery addressBookRepositery;


    @Override
    public List<AddressBookData> getAddressBookData() {
     return addressBookRepositery.findAll();
    }

    @Override
    public AddressBookData getAddressBookDataById(int AddressBookID) {
        return addressBookRepositery.findById(AddressBookID)
                .orElseThrow(() -> new EmployeePayrollException("Employee with EmployeeId" + AddressBookID
                        + " Doesn't Exists...!"));
    }

    @Override
    public AddressBookData createData(AddressBookDTO addressBookDTO) {
        AddressBookData addData = null;
        addData = new AddressBookData(addressBookDTO);
        return addressBookRepositery.save(addData);
    }

    @Override
    public AddressBookData updateData(int AddressBookID, AddressBookDTO addressBookDTO) {
        AddressBookData addData = this.getAddressBookDataById(AddressBookID);
        addData.updateData(addressBookDTO);
        return addressBookRepositery.save(addData);
    }

    @Override
    public void DeleteData(int AddressBookID) {
        AddressBookData addData = this.getAddressBookDataById(AddressBookID);
        addressBookRepositery.delete(addData);
    }

    @Override
    public List<AddressBookData> getAddressByCity(String city) {
        return addressBookRepositery.findByCity(city);
    }

    @Override
    public List<AddressBookData> getAddressByPincode(long pincode) {
        return addressBookRepositery.findByPincode(pincode);
    }

    @Override
    public List<AddressBookData> getAddressByName(String name) {
        return addressBookRepositery.findByName(name);
    }
}
