package com.t11;

public class LambdaDemo {

    public static void main(String[] args) {

       /* useInter(new Inter() {
            @Override
            public void show() {
                System.out.println("接口");
            }
        });

        usetAnimal(new Animal() {
            @Override
            public void method() {
                System.out.println("抽象类");
            }
        });

        useStudent(new Student(){
            @Override
            public void study() {
                System.out.println("具体类");
            }
        });
*/
        //Lambda
//        useInter(()-> System.out.println("接口"));
//        usetAnimal(()-> System.out.println("抽象类"));
//        useStudent(()-> System.out.println("具体类"));

//        useInter(()-> System.out.println("接口"));
        useInter(new Inter() {
            @Override
            public void show() {
                System.out.println("show");
            }

            @Override
            public void show2() {
                System.out.println("show2");
            }
        });

    }

    private static void useStudent(Student s){
        s.study();
    }

    private static void usetAnimal(Animal a){
        a.method();
    }

    private static void useInter(Inter i){
        i.show();
    }

}
