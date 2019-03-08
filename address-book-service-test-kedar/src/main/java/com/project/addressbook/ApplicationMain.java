package com.project.addressbook;

import com.project.addressbook.criteria.Criteria;
import com.project.addressbook.criteria.GenderCriteria;
import com.project.addressbook.criteria.NameCriteria;
import com.project.addressbook.criteria.OldestPersonCriteria;
import com.project.addressbook.enums.Gender;
import com.project.addressbook.loader.AddressBookLoader;
import com.project.addressbook.loader.FileAddressBookLoader;
import com.project.addressbook.model.RecordEntry;
import com.project.addressbook.service.AddressBookService;
import com.project.addressbook.utils.DateUtils;

import java.util.List;

public class ApplicationMain {

        public static void main(String[] args) throws Exception {
            AddressBookService addressBookService = new AddressBookService();
            AddressBookLoader addressBookLoader = new FileAddressBookLoader("AddressBook");
            addressBookLoader.load(addressBookService);

            Criteria criteria = new GenderCriteria(Gender.MALE);
            List<RecordEntry> entriesForMale = addressBookService.findBy(criteria);
            System.out.print("How many males are in the address book?\t");
            System.out.println("Answer: " + entriesForMale.size());

            criteria = new OldestPersonCriteria();
            List<RecordEntry> entries = addressBookService.findBy(criteria);
            RecordEntry entryForOldestPerson = entries.get(0);
            System.out.print("Who is the oldest person in the address book?\t");
            System.out.println("Answer: " + entryForOldestPerson.getFirstName() + " " + entryForOldestPerson.getLastName());

            criteria = new NameCriteria("Bill", "McKnight");
            RecordEntry entryForBill = addressBookService.findBy(criteria).get(0);
            criteria = new NameCriteria("Paul", "Robinson");
            RecordEntry entryForPaul = addressBookService.findBy(criteria).get(0);
            System.out.print("How many days older is Bill than Paul?\t");
            System.out.println("Answer: " + DateUtils.daysBetween(entryForBill.getDateOfBirth(), entryForPaul.getDateOfBirth()) + " days");

        }

}
