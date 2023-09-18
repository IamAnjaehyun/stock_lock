package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

//    @Transactional
    public synchronized void decrease(Long id, Long quantity) throws NotFoundException {
        //stock 조회
        //재고를 감소시킨 뒤
        //갱신된 값을 저장
        Stock stock = stockRepository.findById(id).orElseThrow(NotFoundException::new);
        stock.decrease(quantity);
        stockRepository.saveAndFlush(stock);

    }
}
