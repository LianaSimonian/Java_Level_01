package com.aca.homework.week9.invoice.service;

import java.io.FileNotFoundException;

public interface InvoiceReader {
    Invoice[] read() throws FileNotFoundException;
}

