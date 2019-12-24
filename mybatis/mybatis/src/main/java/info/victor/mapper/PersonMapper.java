package info.victor.mapper;


import info.victor.entity.Person;

public interface PersonMapper {
    Person findById(Long id);
    Person findByPersonName(String personName);
    int deleteById(Long id);
    int save(Person person);
}