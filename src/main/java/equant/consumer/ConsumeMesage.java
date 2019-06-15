package equant.consumer;

import equant.dao.MessageDao;
import equant.dao.MessageDaoImpl;
import equant.model.MessageMod;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;


public class ConsumeMesage implements Runnable {
    MessageMod messageMod = null;
    MessageDao messageDao = new MessageDaoImpl();
    Logger logger = LoggerFactory.logger(ConsumeMesage.class);


    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                messageMod = messageDao.getMinIdAndRemove();
                if (messageMod != null) {
                    logger.info("send mail" + messageMod.toString());
                }
            } catch (InterruptedException e) {
                new RuntimeException("Cannot send mail");
            }

        }
    }
}
