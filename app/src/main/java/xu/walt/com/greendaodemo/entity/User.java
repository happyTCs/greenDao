package xu.walt.com.greendaodemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by walt on 2019/4/15.
 */
@Entity
public class User {
    @Id
    private long id;
    private String name;
    private int age;
    private String height;
    private String handSome;
    @Generated(hash = 787069398)
    public User(long id, String name, int age, String height, String handSome) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.handSome = handSome;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getHeight() {
        return this.height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getHandSome() {
        return this.handSome;
    }
    public void setHandSome(String handSome) {
        this.handSome = handSome;
    }
}
