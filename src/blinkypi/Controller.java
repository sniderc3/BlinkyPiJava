/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blinkypi;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


/**
 *
 * @author snide
 */
public class Controller {
    
    final GpioController gpio = GpioFactory.getInstance(); 

    public void killswitch()
        {
             gpio.shutdown();
        }
    
   public void createOutputPin()
   {
      GpioPinDigitalOutput myLED 
              = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00,   // PIN NUMBER
                "MyLED",                   // PIN FRIENDLY NAME (optional)
                PinState.LOW); // PIN STARTUP STATE (optional)
      
      myLED.low();
      
      for(int i = 0; i < 10; i++)
      {
          try{
            Thread.sleep(500);
            myLED.toggle();
            Thread.sleep(500);
            myLED.toggle();
          }
          catch(InterruptedException ex)
          {
            ex.toString();
            Thread.currentThread().interrupt();
          }         
      }
   }
    
}
