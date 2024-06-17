package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public class ModelView {
    private Map<String, Object> modelMap = new HashMap<>();
    private String viewName;

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

    public void setModelMap(Map<String, Object> modelMap) {
        this.modelMap = modelMap;
    }
}
