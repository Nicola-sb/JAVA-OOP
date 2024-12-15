package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {

    //Трябва да имам 3 теста за алармата
    //1.В пърия проверявам дали налягането е по-малко от 17
    //2.Във втория проверявам дали налягането е по-голямо от 21
    //3.В третия проверям дали налягането е в норма между 17 и 21


    //1.Проверявам дали налягане е под 17 пси
    @Test
    public void testAlarmWithLowerPresure(){
        //Какво трябва да правим?
        //Първо имаме аларма,която трябва да пускаме --> Трябва да си създадем аларма
        Sensor sensor= Mockito.mock(Sensor.class);//Mokwam си Senosra и трябва да кажа на sensora,когато се извиква метода popNextPressurePsiValue и искам да ми се върне стойнсот по-малка от 17(15)
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15.3);//Искам Mockitoto,когато се използва от моя sensor,методът popNextPressurePsiValue искам резултата от този мето да не се взима предвид,а
        //този метод аз да го мокна и да ми връща стойнотта 15.3
        Alarm alarm=new Alarm(sensor);
        //Искам да си проверя алармата -->
        alarm.check();
        //И След като я проверя трябва да проверя дали е включена
        Assert.assertTrue(alarm.getAlarmOn());//Искам да си проверя дали моята стойност ми е равна на true (Казвам на алармата ДАйМиДалиЕВключема(getAlarmOn) и ако е включена
        //и ми върне true всичко е точно

        //Трябва да си Мокнем налягането за да съм сигурен,че всеки път ще получвам <17  // на 21 ред си Моквам сензора
        //Иначе всеки път получавам някакво случайно число randomPressureSampleSimulator.nextDouble()


    }

    //2.Проверявам дали налягането е над 21
    @Test
    public void testAlarmWithHihgerPresure(){
        Sensor sensor=Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.4);

        Alarm alarm=new Alarm(sensor);
        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());


    }

    //3.Проверявам дали налягането си е в норма
    @Test
    public void testAlarmWithNormalValue(){
       Sensor sensor=Mockito.mock(Sensor.class);
       Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(19.4);

       Alarm alarm=new Alarm(sensor);

       alarm.check();

       Assert.assertFalse(alarm.getAlarmOn());

    }
}