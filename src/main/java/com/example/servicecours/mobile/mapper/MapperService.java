package com.example.servicecours.mobile.mapper;

import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MapperService {
    private MapperService(){
    }
  private static final ThreadLocal<ObjectMapper> om = new ThreadLocal<ObjectMapper>() {
       @Override
       protected ObjectMapper initialValue() {
           ObjectMapper objectMapper = new ObjectMapper();
           objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
           objectMapper.registerModule(new JavaTimeModule());
           return objectMapper;
       }
   };


   public static ObjectMapper mapper() {
       return om.get();
   }
   public static <T,R> T mapToEntity(R element, Class<T> TClass) {
       return mapper().convertValue(element, TClass);
   }
   public static <T,R>  List<T> mapToListEntity(List<R>  listDto,Class<T> TClass) {
       return listDto
               .stream()
               .map(data->mapper().convertValue(data,TClass))
               .toList();


   }
  
}
