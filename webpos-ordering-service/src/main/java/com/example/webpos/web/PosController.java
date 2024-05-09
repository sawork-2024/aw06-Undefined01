package com.example.webpos.web;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.webpos.biz.PosService;
import com.example.webpos.model.Product;
import com.example.webpos.model.ProductDto;

@RestController
public class PosController {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @GetMapping(value = "/settings", produces = "application/json")
    public String settings() {
        return 
            "   [ {\n" +
            "      \"_id\": 1,\n" +
            "      \"settings\": {\n" +
            "        \"app\": \"Standalone Point of Sale\",\n" +
            "        \"store\": \"Store-Pos\",\n" +
            "        \"address_one\": \"10086\",\n" +
            "        \"address_two\": \"10087\",\n" +
            "        \"contact\": \"15968774896\",\n" +
            "        \"tax\": \"\",\n" +
            "        \"symbol\": \"$\",\n" +
            "        \"percentage\": \"10\",\n" +
            "        \"footer\": \"\",\n" +
            "        \"img\": \"\"\n" +
            "      },\n" +
            "      \"id\": \"d36d\"\n" +
            "    }]\n";
    }

    @GetMapping(value = "/categories", produces = "application/json")
    public String categories() {
        return 
            "[\n" +
            "    {\n" +
            "      \"id\": \"1711853606\",\n" +
            "      \"name\": \"drink\",\n" +
            "      \"_id\": 1711853606\n" +
            "    }\n" +
            "  ]\n";
    }
}
