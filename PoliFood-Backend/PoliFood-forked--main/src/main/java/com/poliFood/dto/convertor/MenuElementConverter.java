package com.poliFood.dto.convertor;

import com.poliFood.dto.MenuElementDTO;
import com.poliFood.dto.OrderDTO;
import com.poliFood.model.MenuElement;
import com.poliFood.model.Order;
import org.modelmapper.ModelMapper;

import java.text.ParseException;

public class MenuElementConverter {
    private static ModelMapper modelMapper;

    public static MenuElement convertToEntity(MenuElementDTO menuElementDTO) throws ParseException {
        return modelMapper.map(menuElementDTO, MenuElement.class);
    }

    public static MenuElementDTO convertToDto(MenuElement menuElement){
        return modelMapper.map(menuElement, MenuElementDTO.class);
    }

}
