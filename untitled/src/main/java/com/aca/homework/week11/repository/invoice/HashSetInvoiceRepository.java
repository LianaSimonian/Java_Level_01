package com.aca.homework.week11.repository.invoice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetInvoiceRepository implements InvoiceRepository {
    private Set<Invoice> repository = new HashSet<>();

    @Override
    public Invoice save(Invoice invoice) {
        if (invoice == null) throw new NullInvoiceArgumentException("invoice argument in save method can not be null");
        Invoice invoice1 = findById(invoice.getId());
        if (invoice1 != null) {
            invoice1.setAmountToPay(invoice.getAmountToPay());
            invoice1.setStatus(invoice.getStatus());
            return invoice;
        }
        repository.add(invoice);
        return invoice;
    }

    @Override
    public Invoice findById(String id) {
        if (id == null) throw new NullIdException("id can not be null");
        for (Invoice invoice : repository)
            if (invoice.getId().equals(id))
                return invoice;
        return null;
    }

    @Override
    public List<Invoice> findAll() {
        return new LinkedList<Invoice>(repository);
    }

    @Override
    public void delete(Invoice invoice) {
        if (size() == 0) throw new HashSetEmptyException("HashSetRepository is empty");
        repository.remove(invoice);
    }

    public int size() {
        return repository.size();
    }
}