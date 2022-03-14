package com.poliFood.dto.convertor;

import com.poliFood.dto.OrderDTO;
import com.poliFood.dto.UserDTO;
import com.poliFood.model.Order;
import com.poliFood.model.User;
import org.modelmapper.ModelMapper;

import java.text.ParseException;

public class OrderConverter {
    private static ModelMapper modelMapper;

    public static Order convertToEntity(OrderDTO orderDTO) throws ParseException {
        return modelMapper.map(orderDTO, Order.class);
    }

    public static OrderDTO convertToDto(Order order){
        return modelMapper.map(order, OrderDTO.class);
    }
}
