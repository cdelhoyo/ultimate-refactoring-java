package safeUnwrap;

public class AnotherConsumer {

    public int getAmount(Model model){
        Model wrapper = model;

        return wrapper.getAmount();
    }
}
