/**
 * 
 */
package com.tracy.common.InterfaceAndAbstract;


/**
 * @author tracy.lu
 * @date:2016年4月22日 上午10:51:25
 * @version :
 */
public class AdvancedCar extends Car {

    @Override
    public void skylight() {
        System.out.println("The car has skylight!");
    }

    // @Override
    // void drive() {
    // System.out.println("The car can drive!");
    //
    // }
    //
    // @Override
    // void stop() {
    // System.out.println("The car can stop!");
    //
    // }
    //
    // public static void main(String[] args) {
    // // AdvancedCar car = new Car();
    // Car car = new AdvancedCar();
    // Skylight sl = new AdvancedCar();
    // sl.skylight();
    // car.trun();
    // // car.skylight();
    // car.stop();
    // }

}
