package com.hljiang.effectivejava;

public class CreateObject {
    private CreateObject() {
    }

    /**
     * 利用枚举实现单例模式
     * 1、枚举是instance-controlled classes 实例受控类
     * 2、枚举类是可以保证不会存在两个相等的实例
     * 3、枚举是a == b 等于 a.equals(b)
     *
     * @return
     */
    public static CreateObject getInstance(){
        return singletonEnum.ENUM_INSTANCE.getObject();
    }

    // use inner enum to create a singleton class;
    protected enum singletonEnum{
        ENUM_INSTANCE(new CreateObject());
        private CreateObject object;

        singletonEnum(CreateObject object) {
            this.object = object;
        }

        public CreateObject getObject() {
            return object;
        }
    }

    public static void main(String[] args) {
        // chapter2: enumn is instance-controlled classes
        System.out.println(testEnum.ENUM_A.equals(testEnum.ENUM_A));
        System.out.println(testEnum.ENUM_A == testEnum.ENUM_A);
        // we can use Enum for singleton cause it's a instance-controlled classes
        System.out.println(CreateObject.getInstance());
        System.out.println(CreateObject.getInstance());
        System.out.println(CreateObject.getInstance().equals(CreateObject.getInstance()));
    }
}
