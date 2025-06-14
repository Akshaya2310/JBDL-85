package org.gfg.expdemo;

public class CustomExceptionDemo {


    public static void main(String[] args) {
        CustomExceptionDemo customExceptionDemo = new CustomExceptionDemo();

        try {
            customExceptionDemo.getById("2345");
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public Product getById(String id) throws ProductNotFoundException{
        //
         //
         //
         //if exist
        {
            // return product
        }
        throw new ProductNotFoundException("12345","Does not exist");
    }
}

class Product{
    String id;
    String name;

}
