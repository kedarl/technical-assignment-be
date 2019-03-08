package com.project.addressbook.loader;

import com.project.addressbook.service.AddressBookService;

public interface AddressBookLoader {

    void load(AddressBookService addressBookService) throws Exception;

}