package com.example.pfm.Controllers;

import com.example.pfm.Services.MccCodesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
@RequestMapping("/api/v1")
public class MccCodesController {

    private MccCodesService mccCodesService;

    //import mcc codes
    @PostMapping("/mccCodes")
    public void importMccCodes(InputStream inputStream) {
        mccCodesService.importMccCodes(inputStream);
    }
}
