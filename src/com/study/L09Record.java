package com.study;

import lombok.*;

record PersonDto(
        String name,
        int age){
}
//lombok : 컴파일러+개발툴
//개발툴에서 저장하면 -> lombok이 실행
//개발툴에 설치된 롬복 플러그인과 개발툴이 소켓통신하면서 저장을 감시
// -> 저장시 어노테이션으로 선언한 것을 구현
@Data
@NoArgsConstructor
@AllArgsConstructor
class AnimalDto{
    private String name;
    private int age;
}

public class L09Record {
    public static void main(String[] args) {
        PersonDto personDto=new PersonDto("경민",38);
        PersonDto personDto2=new PersonDto("경민",38);
        System.out.println(personDto);
        System.out.println(personDto.name());
        System.out.println(personDto.equals(personDto2));
        //AnimalDto animal=new AnimalDto("기린",20);
        //AnimalDto animal2=new AnimalDto();

    }
}
