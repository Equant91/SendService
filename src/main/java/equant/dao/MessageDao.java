package equant.dao;

import equant.model.MessageMod;

public interface MessageDao {

    void add(MessageMod messageMod);

    MessageMod getMinIdAndRemove();
}
