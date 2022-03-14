package com.poliFood.dto.convertor;

import com.poliFood.dto.CafeteriaDTO;
import com.poliFood.model.Cafeteria;
import org.modelmapper.ModelMapper;

import java.text.ParseException;

public class CafeteriaConverter {
    private static ModelMapper modelMapper;

    public static Cafeteria convertToEntity(CafeteriaDTO cafeteriaDTO) throws ParseException {
        return modelMapper.map(cafeteriaDTO, Cafeteria.class);
    }

    public static CafeteriaDTO convertToDto(Cafeteria cafeteria){
        return modelMapper.map(cafeteria, CafeteriaDTO.class);
    }
}
