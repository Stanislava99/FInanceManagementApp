package com.example.pfm.Controllers;

import com.example.pfm.Services.MccCodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/api/v1")
public class MccCodesController {

    @Autowired
    private MccCodesService mccCodesService;

    //import mcc codes
    @PostMapping("/mccCodes/import")
    public void importMccCodes(@RequestBody InputStream inputStream) {
        mccCodesService.importMccCodes(inputStream);
    }
}
