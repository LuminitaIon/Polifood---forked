package com.poliFood.dto.convertor;

import com.poliFood.dto.MenuDTO;
import com.poliFood.dto.OrderDTO;
import com.poliFood.model.Menu;
import com.poliFood.model.Order;
import org.modelmapper.ModelMapper;

import java.text.ParseException;

public class MenuConverter {
    private static ModelMapper modelMapper;

    public static Menu convertToEntity(MenuDTO menuDTO) throws ParseException {
        return modelMapper.map(menuDTO, Menu.class);
    }

    public static MenuDTO convertToDto(Menu menu){
        return modelMapper.map(menu, MenuDTO.class);
    }

}
