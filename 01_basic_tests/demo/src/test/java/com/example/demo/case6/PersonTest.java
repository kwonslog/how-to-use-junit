package com.example.demo.case6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class PersonTest {

    @Autowired
    private JacksonTester<Person> json;

    @Test
    public void testSerialize() throws Exception {
        Person person = new Person("홍길동", 19);

        JsonContent<Person> jsonContent = json.write(person);

        assertThat(jsonContent).extractingJsonPathStringValue("@.name").isEqualTo("홍길동");
        assertThat(jsonContent).extractingJsonPathNumberValue("@.age").isEqualTo(19);
    }

    @Test
    public void testDeserialize() throws Exception {
        String jsonString = """
                {
                    "name": "김길동",
                    "age": 39
                }
                """;
        Person person = json.parseObject(jsonString);

        assertThat(person.getName()).isEqualTo("김길동");
        assertThat(person.getAge()).isEqualTo(39);
    }
}