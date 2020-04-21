package com.tw.backend.service.command;

import com.tw.backend.helper.JmsProducer;
import com.tw.library.data.Result;
import com.tw.library.data.Status;
import com.tw.library.dto.CostumeDto;
import com.tw.library.model.JmsServiceCode;
import org.springframework.stereotype.Service;

@Service
public class CostumeServiceImpl implements CostumeService {

    private final JmsProducer jmsProducer;

    public CostumeServiceImpl(JmsProducer jmsProducer) {
        this.jmsProducer = jmsProducer;
    }

    @Override
    public Result<CostumeDto> sendMessage(CostumeDto costume) {
        Result<CostumeDto> result;

        try {
            this.jmsProducer.convertAndSend(JmsServiceCode.QUEUE_INVENTORY_COSTUME, costume);

            result = new Result<>(costume);
        } catch (Exception e) {
            result = new Result<>(Status.FAIL, e.getMessage());
        }

        return result;
    }
}
