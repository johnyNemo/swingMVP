
package com.swingmvp.dc;

import com.swingmvp.ServiceFactoryMethod;
import java.util.HashMap;

/**
 *
 * @author marek
 */
public class ServiceContainer implements ServiceContainerInterface {

    private class ServiceMetadata {

        private final boolean _isCached;

        private final ServiceFactoryMethod _factory;
        
        private Object _cachedInstance;

        public ServiceMetadata(ServiceFactoryMethod factory, boolean isCached) {
            _factory = factory;
            _isCached = isCached;
        }

        public Object getService(ServiceContainerInterface sc) {
            Object service;
            
            if (_isCached && (_cachedInstance != null)) {
                service = _cachedInstance;
            } else if (_isCached && (_cachedInstance == null)) {
                service = _factory.create(sc);
                _cachedInstance = service;
            } else {
                service = _factory.create(sc);
            }
            
            return service;
        }
    }

    private HashMap<String, ServiceMetadata> _services = new HashMap<>();

    private HashMap<String, Object> _cachedInstances = new HashMap<>();

    /**
     *
     * @param serviceName
     * @param factoryMethod
     * @param cacheInstance
     */
    @Override
    public void registerService(String serviceName, ServiceFactoryMethod factoryMethod, boolean cacheInstance) {
        ServiceMetadata meta = new ServiceMetadata(factoryMethod, cacheInstance);
        _services.put(serviceName, meta);
    }
    
    public void registerService(String serviceName, ServiceFactoryMethod factoryMethod) {
        registerService(serviceName, factoryMethod, false);
    }

    /**
     * 
     * @param <T>
     * @param serviceName
     * @return 
     */
    @Override
    public <T> T getService(String serviceName) {
        ServiceMetadata meta = _services.get(serviceName);
        if (meta == null) {
            return null;
        }
        Object service = meta.getService(this);
        return (T) service;        
    }
}
