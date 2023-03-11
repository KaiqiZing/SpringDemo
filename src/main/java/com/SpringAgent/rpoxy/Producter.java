package com.SpringAgent.rpoxy;

public class Producter implements IProducter{
    @Override
    public void SaleProduct(float money) {
        System.out.println("销售产品并拿到："+money);

    }

    @Override
    public void AtferService(float money) {
        System.out.println("提供Service:"+ money);

    }
}
