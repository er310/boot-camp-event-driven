package com.tw.inventory.service.impl;

import com.tw.inventory.entity.Costume;
import com.tw.inventory.helper.JmsProducer;
import com.tw.inventory.repository.CostumeRepository;
import com.tw.inventory.service.AbstractService;
import com.tw.inventory.service.CostumeService;
import com.tw.library.data.Result;
import com.tw.library.data.Status;
import com.tw.library.dto.CostumeDto;
import com.tw.library.dto.OrderDto;
import com.tw.library.model.JmsServiceCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CostumeServiceImpl extends AbstractService<Costume, Long> implements CostumeService {

    private final CostumeRepository repository;
    private final JmsProducer jmsProducer;

    @Autowired
    public CostumeServiceImpl(final CostumeRepository repository, final JmsProducer jmsProducer) {
        this.repository = repository;
        this.jmsProducer = jmsProducer;
    }

    @Override
    protected CrudRepository<Costume, Long> getRepository() {
        return repository;
    }

    @Override
    public Result<CostumeDto> create(CostumeDto dto) {
        Result<CostumeDto> result;

        try {
            Costume costume = new Costume(dto.getCostumeId(), dto.getCondition());
            costume.setName(dto.getName());

            CostumeDto costumeDto = new CostumeDto(
                    costume.getName(), costume.getRefNo(), costume.getCondition());
            Costume costume1 = repository.insert(costume);
            if (costume1 != null) {
                OrderDto orderDto = new OrderDto(costumeDto);

                this.jmsProducer.convertAndSend(JmsServiceCode.QUEUE_ORDER_COSTUME, orderDto);
            }

            result = new Result<>(dto);
        } catch (Exception e) {
            result = new Result<>(Status.FAIL, e.getMessage());
        }

        return result;
    }
}