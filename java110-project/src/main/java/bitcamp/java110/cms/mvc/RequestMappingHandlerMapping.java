package bitcamp.java110.cms.mvc;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class RequestMappingHandlerMapping {
    
    public static class Handler{
        public Method method;
        public Object instance;
        
        public Handler(Method m , Object o) {
            method = m;
            instance = o;
        }
    }
    
    HashMap<String, Handler> handlerMap = new HashMap<>();
    
    public Handler getHandler(String url) {
        return handlerMap.get(url);
    }
    
    public void addHandler(String url,Method method,Object instance) {
        handlerMap.put(url, new Handler(method , instance));
    }
}
