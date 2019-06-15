package equant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Data
@Table(name = "message")
@NoArgsConstructor
public class MessageMod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*Уникальный идентификатор*/
    private Long id;

    /* Служебное поле hibernate*/
    @Version
    private Long version;

    /*Номер документа*/
    @Column(name = "address")
    String address;

    @Column(name = "topic")
    String topic;

    @Column(name = "text_message")
    String textMessage;

    public MessageMod(String address, String topic, String textMessage) {
        this.address = address;
        this.topic = topic;
        this.textMessage = textMessage;
    }
}
