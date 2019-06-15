package equant.consumer;

import equant.provider.ProviderMessage;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsumeMesageTest {

@Test
    public void startTest() {
        ConsumeMesage consumeMesage = new ConsumeMesage();
        ProviderMessage providerMessage = new ProviderMessage();

        Thread thread = new Thread(providerMessage);
        thread.start();

        Thread thread1 = new Thread(consumeMesage);
        thread1.start();
        long x = 0;
while ( x < 7);
x =  consumeMesage.messageMod.getId();
    }
}