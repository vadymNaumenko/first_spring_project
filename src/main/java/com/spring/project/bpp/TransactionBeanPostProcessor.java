package com.spring.project.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
@Component
public class TransactionBeanPostProcessor implements BeanPostProcessor {
    private Map<String,Class<?>> transactionBeans = new HashMap<>();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAnnotationPresent(Transaction.class)){
            transactionBeans.put(beanName,bean.getClass());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = transactionBeans.get(beanName);
        if(beanClass != null){
            return Proxy.newProxyInstance(beanClass.getClassLoader(),beanClass.getInterfaces(),
                    ((proxy, method, args) -> {
                        System.out.println("Open transaction");
                        try{
                            return method.invoke(bean,args);
                        }catch (Exception e){
                            System.out.println("Rollback transaction");
                        }finally {
                            System.out.println("Close transaction");
                        }
                        return proxy;
                    }));
        }
        return bean;
    }
}
