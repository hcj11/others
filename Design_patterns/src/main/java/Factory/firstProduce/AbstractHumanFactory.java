package Factory.firstProduce;

/**
 * 人工厂
 * Created by hcj on 18-7-7
 */
public abstract class AbstractHumanFactory {
    public abstract <T extends  Human> T createHuman(Class<T> c);
}
