package com.example.grammar.concurrent.running_example;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/1/29 14:57
 */
public class CallToBackImpl implements AbstractAnimal.CallToBack {

    private AbstractAnimal animal;

    CallToBackImpl(AbstractAnimal animal){
        this.animal = animal;
    }

    @Override
    public void win() {
        animal.stop();
    }
}
