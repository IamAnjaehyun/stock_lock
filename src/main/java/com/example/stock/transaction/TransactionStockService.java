package com.example.stock.transaction;

import com.example.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionStockService {
    private StockService stockService;

    public void decrease(Long id, Long quantity) throws ChangeSetPersister.NotFoundException {
        startTransaction();
        stockService.decrease(id, quantity);
        endTransaction();
    }

    private void startTransaction() {
        System.out.println("transaction start");
    }

    private void endTransaction() {
        System.out.println("transaction end");
    }
}
