package equant.provider;


import equant.dao.MessageDao;
import equant.dao.MessageDaoImpl;
import equant.model.MessageMod;

public class ProviderMessage implements Runnable{

    MessageDao messageDao = new MessageDaoImpl();

    public void run() {
        while (true) {
            createMessage("ppdf@mail.ru", "prof", randomString());
            double random = Math.random() * 3000;
            try {
                Thread.sleep((long)random);
            } catch (InterruptedException e) {
                new RuntimeException(e);
            }
        }
    }
    public String randomString(){
        return java.util.UUID.randomUUID().toString();
    }
    public void createMessage(String addresses, String topic, String textMessage) {
        MessageMod messageMod = new MessageMod(addresses,topic,textMessage);
        messageDao.add(messageMod);
    }
}
