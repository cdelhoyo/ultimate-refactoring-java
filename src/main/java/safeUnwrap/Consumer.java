package safeUnwrap;

public class Consumer {

    public String getColor(Model model){
        Model wrapper = model;

        return wrapper.getColor();
    }
}
