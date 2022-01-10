package com.example.pfm.Services;


import com.example.pfm.Models.CategoryEntity;
import com.example.pfm.Models.MccCodesEntity;
import com.example.pfm.Repos.MccCodesRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

@Service
public class MccCodesService {

    public MccCodesRepository mccCodesRepository;

    public MccCodesService(MccCodesRepository mccCodesRepository) {
        this.mccCodesRepository = mccCodesRepository;
    }

    //import mcc codes from csv file
    public String importMccCodes (InputStream inputStream)  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArray = line.split(",");
                mccCodesRepository.save(new MccCodesEntity(
                        Long.parseLong(lineArray[0]),
                        lineArray[1]
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }

}
