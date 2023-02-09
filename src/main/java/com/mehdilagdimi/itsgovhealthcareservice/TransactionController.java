package com.mehdilagdimi.itsgovhealthcareservice;

import com.mehdilagdimi.itsgovhealthcareservice.model.TransactionDto;
import com.mehdilagdimi.itsgovhealthcareservice.model.entity.Transaction;
import com.mehdilagdimi.itsgovhealthcareservice.repository.TransactionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/healthcare/transaction")
public class TransactionController {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    TransactionRepository transactionRepository;

    @PostMapping("/add")
    public void addTransaction(@RequestBody TransactionDto transactionDto) {
        try{
            Transaction transaction = transactionRepository.save(convertToEntity(transactionDto));
        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public TransactionDto getTransactionById(@PathVariable("id") Long id) {
        return convertToDto(transactionRepository.findById(id).orElseThrow(() -> new NoSuchElementException()));
    }

    private Transaction convertToEntity(TransactionDto transactionDto) throws ParseException {
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        return transaction;
    }

    private TransactionDto convertToDto(Transaction transaction) {
        TransactionDto transactionDto = modelMapper.map(transaction, TransactionDto.class);
        return transactionDto;
    }
}
