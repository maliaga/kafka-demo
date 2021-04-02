package dev.aliaga.kafka.avro.infraestructure.entrypoint.rest;


import dev.aliaga.kafka.avro.domain.kafka.KafKaProducerService;
import dev.aliaga.kafka.avro.infraestructure.entrypoint.request.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@RequestMapping("/send")
public class KafkaDemoController {

    private KafKaProducerService kafKaProducerService;


    public KafkaDemoController(KafKaProducerService kafKaProducerService) {
        this.kafKaProducerService = kafKaProducerService;

    }

    @PostMapping("/avro")
    @ResponseStatus(code = HttpStatus.OK)
    public void sendUserSincronoTemplate(@RequestBody UserRequest userRequest) {
        kafKaProducerService.sendUserTemplate(userRequest);
    }
}


